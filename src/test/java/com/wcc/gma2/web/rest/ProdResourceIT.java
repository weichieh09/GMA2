package com.wcc.gma2.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wcc.gma2.IntegrationTest;
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.repository.ProdRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ProdResource} REST controller.
 */
@IntegrationTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
class ProdResourceIT {

    private static final String DEFAULT_PROD_NO = "AAAAAAAAAA";
    private static final String UPDATED_PROD_NO = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_HS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_HS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CCC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CCC_CODE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/prods";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ProdRepository prodRepository;

    @Mock
    private ProdRepository prodRepositoryMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProdMockMvc;

    private Prod prod;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Prod createEntity(EntityManager em) {
        Prod prod = new Prod().prodNo(DEFAULT_PROD_NO).name(DEFAULT_NAME).hsCode(DEFAULT_HS_CODE).cccCode(DEFAULT_CCC_CODE);
        return prod;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Prod createUpdatedEntity(EntityManager em) {
        Prod prod = new Prod().prodNo(UPDATED_PROD_NO).name(UPDATED_NAME).hsCode(UPDATED_HS_CODE).cccCode(UPDATED_CCC_CODE);
        return prod;
    }

    @BeforeEach
    public void initTest() {
        prod = createEntity(em);
    }

    @Test
    @Transactional
    void createProd() throws Exception {
        int databaseSizeBeforeCreate = prodRepository.findAll().size();
        // Create the Prod
        restProdMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(prod)))
            .andExpect(status().isCreated());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeCreate + 1);
        Prod testProd = prodList.get(prodList.size() - 1);
        assertThat(testProd.getProdNo()).isEqualTo(DEFAULT_PROD_NO);
        assertThat(testProd.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testProd.getHsCode()).isEqualTo(DEFAULT_HS_CODE);
        assertThat(testProd.getCccCode()).isEqualTo(DEFAULT_CCC_CODE);
    }

    @Test
    @Transactional
    void createProdWithExistingId() throws Exception {
        // Create the Prod with an existing ID
        prod.setId(1L);

        int databaseSizeBeforeCreate = prodRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restProdMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(prod)))
            .andExpect(status().isBadRequest());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllProds() throws Exception {
        // Initialize the database
        prodRepository.saveAndFlush(prod);

        // Get all the prodList
        restProdMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(prod.getId().intValue())))
            .andExpect(jsonPath("$.[*].prodNo").value(hasItem(DEFAULT_PROD_NO)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].hsCode").value(hasItem(DEFAULT_HS_CODE)))
            .andExpect(jsonPath("$.[*].cccCode").value(hasItem(DEFAULT_CCC_CODE)));
    }

    @SuppressWarnings({ "unchecked" })
    void getAllProdsWithEagerRelationshipsIsEnabled() throws Exception {
        when(prodRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restProdMockMvc.perform(get(ENTITY_API_URL + "?eagerload=true")).andExpect(status().isOk());

        verify(prodRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({ "unchecked" })
    void getAllProdsWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(prodRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restProdMockMvc.perform(get(ENTITY_API_URL + "?eagerload=false")).andExpect(status().isOk());
        verify(prodRepositoryMock, times(1)).findAll(any(Pageable.class));
    }

    @Test
    @Transactional
    void getProd() throws Exception {
        // Initialize the database
        prodRepository.saveAndFlush(prod);

        // Get the prod
        restProdMockMvc
            .perform(get(ENTITY_API_URL_ID, prod.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(prod.getId().intValue()))
            .andExpect(jsonPath("$.prodNo").value(DEFAULT_PROD_NO))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.hsCode").value(DEFAULT_HS_CODE))
            .andExpect(jsonPath("$.cccCode").value(DEFAULT_CCC_CODE));
    }

    @Test
    @Transactional
    void getNonExistingProd() throws Exception {
        // Get the prod
        restProdMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingProd() throws Exception {
        // Initialize the database
        prodRepository.saveAndFlush(prod);

        int databaseSizeBeforeUpdate = prodRepository.findAll().size();

        // Update the prod
        Prod updatedProd = prodRepository.findById(prod.getId()).get();
        // Disconnect from session so that the updates on updatedProd are not directly saved in db
        em.detach(updatedProd);
        updatedProd.prodNo(UPDATED_PROD_NO).name(UPDATED_NAME).hsCode(UPDATED_HS_CODE).cccCode(UPDATED_CCC_CODE);

        restProdMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedProd.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedProd))
            )
            .andExpect(status().isOk());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
        Prod testProd = prodList.get(prodList.size() - 1);
        assertThat(testProd.getProdNo()).isEqualTo(UPDATED_PROD_NO);
        assertThat(testProd.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testProd.getHsCode()).isEqualTo(UPDATED_HS_CODE);
        assertThat(testProd.getCccCode()).isEqualTo(UPDATED_CCC_CODE);
    }

    @Test
    @Transactional
    void putNonExistingProd() throws Exception {
        int databaseSizeBeforeUpdate = prodRepository.findAll().size();
        prod.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProdMockMvc
            .perform(
                put(ENTITY_API_URL_ID, prod.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(prod))
            )
            .andExpect(status().isBadRequest());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchProd() throws Exception {
        int databaseSizeBeforeUpdate = prodRepository.findAll().size();
        prod.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProdMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(prod))
            )
            .andExpect(status().isBadRequest());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamProd() throws Exception {
        int databaseSizeBeforeUpdate = prodRepository.findAll().size();
        prod.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProdMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(prod)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateProdWithPatch() throws Exception {
        // Initialize the database
        prodRepository.saveAndFlush(prod);

        int databaseSizeBeforeUpdate = prodRepository.findAll().size();

        // Update the prod using partial update
        Prod partialUpdatedProd = new Prod();
        partialUpdatedProd.setId(prod.getId());

        partialUpdatedProd.name(UPDATED_NAME);

        restProdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedProd.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedProd))
            )
            .andExpect(status().isOk());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
        Prod testProd = prodList.get(prodList.size() - 1);
        assertThat(testProd.getProdNo()).isEqualTo(DEFAULT_PROD_NO);
        assertThat(testProd.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testProd.getHsCode()).isEqualTo(DEFAULT_HS_CODE);
        assertThat(testProd.getCccCode()).isEqualTo(DEFAULT_CCC_CODE);
    }

    @Test
    @Transactional
    void fullUpdateProdWithPatch() throws Exception {
        // Initialize the database
        prodRepository.saveAndFlush(prod);

        int databaseSizeBeforeUpdate = prodRepository.findAll().size();

        // Update the prod using partial update
        Prod partialUpdatedProd = new Prod();
        partialUpdatedProd.setId(prod.getId());

        partialUpdatedProd.prodNo(UPDATED_PROD_NO).name(UPDATED_NAME).hsCode(UPDATED_HS_CODE).cccCode(UPDATED_CCC_CODE);

        restProdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedProd.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedProd))
            )
            .andExpect(status().isOk());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
        Prod testProd = prodList.get(prodList.size() - 1);
        assertThat(testProd.getProdNo()).isEqualTo(UPDATED_PROD_NO);
        assertThat(testProd.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testProd.getHsCode()).isEqualTo(UPDATED_HS_CODE);
        assertThat(testProd.getCccCode()).isEqualTo(UPDATED_CCC_CODE);
    }

    @Test
    @Transactional
    void patchNonExistingProd() throws Exception {
        int databaseSizeBeforeUpdate = prodRepository.findAll().size();
        prod.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, prod.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(prod))
            )
            .andExpect(status().isBadRequest());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchProd() throws Exception {
        int databaseSizeBeforeUpdate = prodRepository.findAll().size();
        prod.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(prod))
            )
            .andExpect(status().isBadRequest());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamProd() throws Exception {
        int databaseSizeBeforeUpdate = prodRepository.findAll().size();
        prod.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProdMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(prod)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Prod in the database
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteProd() throws Exception {
        // Initialize the database
        prodRepository.saveAndFlush(prod);

        int databaseSizeBeforeDelete = prodRepository.findAll().size();

        // Delete the prod
        restProdMockMvc
            .perform(delete(ENTITY_API_URL_ID, prod.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Prod> prodList = prodRepository.findAll();
        assertThat(prodList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
