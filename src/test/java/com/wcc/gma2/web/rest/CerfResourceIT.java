package com.wcc.gma2.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wcc.gma2.IntegrationTest;
import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.repository.CerfRepository;
import java.time.LocalDate;
import java.time.ZoneId;
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
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link CerfResource} REST controller.
 */
@IntegrationTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
class CerfResourceIT {

    private static final String DEFAULT_CERF_NO = "AAAAAAAAAA";
    private static final String UPDATED_CERF_NO = "BBBBBBBBBB";

    private static final String DEFAULT_CERF_VER = "AAAAAAAAAA";
    private static final String UPDATED_CERF_VER = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final byte[] DEFAULT_PDF = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_PDF = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_PDF_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PDF_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_APPL_ID = "AAAAAAAAAA";
    private static final String UPDATED_APPL_ID = "BBBBBBBBBB";

    private static final String DEFAULT_FCTY_ID = "AAAAAAAAAA";
    private static final String UPDATED_FCTY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_MNFCTR_ID = "AAAAAAAAAA";
    private static final String UPDATED_MNFCTR_ID = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ISSU_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ISSU_DT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXP_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXP_DT = LocalDate.now(ZoneId.systemDefault());

    private static final String ENTITY_API_URL = "/api/cerfs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CerfRepository cerfRepository;

    @Mock
    private CerfRepository cerfRepositoryMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCerfMockMvc;

    private Cerf cerf;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cerf createEntity(EntityManager em) {
        Cerf cerf = new Cerf()
            .cerfNo(DEFAULT_CERF_NO)
            .cerfVer(DEFAULT_CERF_VER)
            .status(DEFAULT_STATUS)
            .pdf(DEFAULT_PDF)
            .pdfContentType(DEFAULT_PDF_CONTENT_TYPE)
            .applId(DEFAULT_APPL_ID)
            .fctyId(DEFAULT_FCTY_ID)
            .mnfctrId(DEFAULT_MNFCTR_ID)
            .issuDt(DEFAULT_ISSU_DT)
            .expDt(DEFAULT_EXP_DT);
        return cerf;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cerf createUpdatedEntity(EntityManager em) {
        Cerf cerf = new Cerf()
            .cerfNo(UPDATED_CERF_NO)
            .cerfVer(UPDATED_CERF_VER)
            .status(UPDATED_STATUS)
            .pdf(UPDATED_PDF)
            .pdfContentType(UPDATED_PDF_CONTENT_TYPE)
            .applId(UPDATED_APPL_ID)
            .fctyId(UPDATED_FCTY_ID)
            .mnfctrId(UPDATED_MNFCTR_ID)
            .issuDt(UPDATED_ISSU_DT)
            .expDt(UPDATED_EXP_DT);
        return cerf;
    }

    @BeforeEach
    public void initTest() {
        cerf = createEntity(em);
    }

    @Test
    @Transactional
    void createCerf() throws Exception {
        int databaseSizeBeforeCreate = cerfRepository.findAll().size();
        // Create the Cerf
        restCerfMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(cerf)))
            .andExpect(status().isCreated());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeCreate + 1);
        Cerf testCerf = cerfList.get(cerfList.size() - 1);
        assertThat(testCerf.getCerfNo()).isEqualTo(DEFAULT_CERF_NO);
        assertThat(testCerf.getCerfVer()).isEqualTo(DEFAULT_CERF_VER);
        assertThat(testCerf.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testCerf.getPdf()).isEqualTo(DEFAULT_PDF);
        assertThat(testCerf.getPdfContentType()).isEqualTo(DEFAULT_PDF_CONTENT_TYPE);
        assertThat(testCerf.getApplId()).isEqualTo(DEFAULT_APPL_ID);
        assertThat(testCerf.getFctyId()).isEqualTo(DEFAULT_FCTY_ID);
        assertThat(testCerf.getMnfctrId()).isEqualTo(DEFAULT_MNFCTR_ID);
        assertThat(testCerf.getIssuDt()).isEqualTo(DEFAULT_ISSU_DT);
        assertThat(testCerf.getExpDt()).isEqualTo(DEFAULT_EXP_DT);
    }

    @Test
    @Transactional
    void createCerfWithExistingId() throws Exception {
        // Create the Cerf with an existing ID
        cerf.setId(1L);

        int databaseSizeBeforeCreate = cerfRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCerfMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(cerf)))
            .andExpect(status().isBadRequest());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllCerfs() throws Exception {
        // Initialize the database
        cerfRepository.saveAndFlush(cerf);

        // Get all the cerfList
        restCerfMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cerf.getId().intValue())))
            .andExpect(jsonPath("$.[*].cerfNo").value(hasItem(DEFAULT_CERF_NO)))
            .andExpect(jsonPath("$.[*].cerfVer").value(hasItem(DEFAULT_CERF_VER)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].pdfContentType").value(hasItem(DEFAULT_PDF_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].pdf").value(hasItem(Base64Utils.encodeToString(DEFAULT_PDF))))
            .andExpect(jsonPath("$.[*].applId").value(hasItem(DEFAULT_APPL_ID)))
            .andExpect(jsonPath("$.[*].fctyId").value(hasItem(DEFAULT_FCTY_ID)))
            .andExpect(jsonPath("$.[*].mnfctrId").value(hasItem(DEFAULT_MNFCTR_ID)))
            .andExpect(jsonPath("$.[*].issuDt").value(hasItem(DEFAULT_ISSU_DT.toString())))
            .andExpect(jsonPath("$.[*].expDt").value(hasItem(DEFAULT_EXP_DT.toString())));
    }

    @SuppressWarnings({ "unchecked" })
    void getAllCerfsWithEagerRelationshipsIsEnabled() throws Exception {
        when(cerfRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restCerfMockMvc.perform(get(ENTITY_API_URL + "?eagerload=true")).andExpect(status().isOk());

        verify(cerfRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({ "unchecked" })
    void getAllCerfsWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(cerfRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restCerfMockMvc.perform(get(ENTITY_API_URL + "?eagerload=false")).andExpect(status().isOk());
        verify(cerfRepositoryMock, times(1)).findAll(any(Pageable.class));
    }

    @Test
    @Transactional
    void getCerf() throws Exception {
        // Initialize the database
        cerfRepository.saveAndFlush(cerf);

        // Get the cerf
        restCerfMockMvc
            .perform(get(ENTITY_API_URL_ID, cerf.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cerf.getId().intValue()))
            .andExpect(jsonPath("$.cerfNo").value(DEFAULT_CERF_NO))
            .andExpect(jsonPath("$.cerfVer").value(DEFAULT_CERF_VER))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.pdfContentType").value(DEFAULT_PDF_CONTENT_TYPE))
            .andExpect(jsonPath("$.pdf").value(Base64Utils.encodeToString(DEFAULT_PDF)))
            .andExpect(jsonPath("$.applId").value(DEFAULT_APPL_ID))
            .andExpect(jsonPath("$.fctyId").value(DEFAULT_FCTY_ID))
            .andExpect(jsonPath("$.mnfctrId").value(DEFAULT_MNFCTR_ID))
            .andExpect(jsonPath("$.issuDt").value(DEFAULT_ISSU_DT.toString()))
            .andExpect(jsonPath("$.expDt").value(DEFAULT_EXP_DT.toString()));
    }

    @Test
    @Transactional
    void getNonExistingCerf() throws Exception {
        // Get the cerf
        restCerfMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingCerf() throws Exception {
        // Initialize the database
        cerfRepository.saveAndFlush(cerf);

        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();

        // Update the cerf
        Cerf updatedCerf = cerfRepository.findById(cerf.getId()).get();
        // Disconnect from session so that the updates on updatedCerf are not directly saved in db
        em.detach(updatedCerf);
        updatedCerf
            .cerfNo(UPDATED_CERF_NO)
            .cerfVer(UPDATED_CERF_VER)
            .status(UPDATED_STATUS)
            .pdf(UPDATED_PDF)
            .pdfContentType(UPDATED_PDF_CONTENT_TYPE)
            .applId(UPDATED_APPL_ID)
            .fctyId(UPDATED_FCTY_ID)
            .mnfctrId(UPDATED_MNFCTR_ID)
            .issuDt(UPDATED_ISSU_DT)
            .expDt(UPDATED_EXP_DT);

        restCerfMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedCerf.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedCerf))
            )
            .andExpect(status().isOk());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
        Cerf testCerf = cerfList.get(cerfList.size() - 1);
        assertThat(testCerf.getCerfNo()).isEqualTo(UPDATED_CERF_NO);
        assertThat(testCerf.getCerfVer()).isEqualTo(UPDATED_CERF_VER);
        assertThat(testCerf.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testCerf.getPdf()).isEqualTo(UPDATED_PDF);
        assertThat(testCerf.getPdfContentType()).isEqualTo(UPDATED_PDF_CONTENT_TYPE);
        assertThat(testCerf.getApplId()).isEqualTo(UPDATED_APPL_ID);
        assertThat(testCerf.getFctyId()).isEqualTo(UPDATED_FCTY_ID);
        assertThat(testCerf.getMnfctrId()).isEqualTo(UPDATED_MNFCTR_ID);
        assertThat(testCerf.getIssuDt()).isEqualTo(UPDATED_ISSU_DT);
        assertThat(testCerf.getExpDt()).isEqualTo(UPDATED_EXP_DT);
    }

    @Test
    @Transactional
    void putNonExistingCerf() throws Exception {
        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();
        cerf.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCerfMockMvc
            .perform(
                put(ENTITY_API_URL_ID, cerf.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cerf))
            )
            .andExpect(status().isBadRequest());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCerf() throws Exception {
        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();
        cerf.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCerfMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cerf))
            )
            .andExpect(status().isBadRequest());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCerf() throws Exception {
        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();
        cerf.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCerfMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(cerf)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCerfWithPatch() throws Exception {
        // Initialize the database
        cerfRepository.saveAndFlush(cerf);

        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();

        // Update the cerf using partial update
        Cerf partialUpdatedCerf = new Cerf();
        partialUpdatedCerf.setId(cerf.getId());

        partialUpdatedCerf
            .cerfNo(UPDATED_CERF_NO)
            .status(UPDATED_STATUS)
            .pdf(UPDATED_PDF)
            .pdfContentType(UPDATED_PDF_CONTENT_TYPE)
            .applId(UPDATED_APPL_ID)
            .fctyId(UPDATED_FCTY_ID)
            .mnfctrId(UPDATED_MNFCTR_ID);

        restCerfMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCerf.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCerf))
            )
            .andExpect(status().isOk());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
        Cerf testCerf = cerfList.get(cerfList.size() - 1);
        assertThat(testCerf.getCerfNo()).isEqualTo(UPDATED_CERF_NO);
        assertThat(testCerf.getCerfVer()).isEqualTo(DEFAULT_CERF_VER);
        assertThat(testCerf.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testCerf.getPdf()).isEqualTo(UPDATED_PDF);
        assertThat(testCerf.getPdfContentType()).isEqualTo(UPDATED_PDF_CONTENT_TYPE);
        assertThat(testCerf.getApplId()).isEqualTo(UPDATED_APPL_ID);
        assertThat(testCerf.getFctyId()).isEqualTo(UPDATED_FCTY_ID);
        assertThat(testCerf.getMnfctrId()).isEqualTo(UPDATED_MNFCTR_ID);
        assertThat(testCerf.getIssuDt()).isEqualTo(DEFAULT_ISSU_DT);
        assertThat(testCerf.getExpDt()).isEqualTo(DEFAULT_EXP_DT);
    }

    @Test
    @Transactional
    void fullUpdateCerfWithPatch() throws Exception {
        // Initialize the database
        cerfRepository.saveAndFlush(cerf);

        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();

        // Update the cerf using partial update
        Cerf partialUpdatedCerf = new Cerf();
        partialUpdatedCerf.setId(cerf.getId());

        partialUpdatedCerf
            .cerfNo(UPDATED_CERF_NO)
            .cerfVer(UPDATED_CERF_VER)
            .status(UPDATED_STATUS)
            .pdf(UPDATED_PDF)
            .pdfContentType(UPDATED_PDF_CONTENT_TYPE)
            .applId(UPDATED_APPL_ID)
            .fctyId(UPDATED_FCTY_ID)
            .mnfctrId(UPDATED_MNFCTR_ID)
            .issuDt(UPDATED_ISSU_DT)
            .expDt(UPDATED_EXP_DT);

        restCerfMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCerf.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCerf))
            )
            .andExpect(status().isOk());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
        Cerf testCerf = cerfList.get(cerfList.size() - 1);
        assertThat(testCerf.getCerfNo()).isEqualTo(UPDATED_CERF_NO);
        assertThat(testCerf.getCerfVer()).isEqualTo(UPDATED_CERF_VER);
        assertThat(testCerf.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testCerf.getPdf()).isEqualTo(UPDATED_PDF);
        assertThat(testCerf.getPdfContentType()).isEqualTo(UPDATED_PDF_CONTENT_TYPE);
        assertThat(testCerf.getApplId()).isEqualTo(UPDATED_APPL_ID);
        assertThat(testCerf.getFctyId()).isEqualTo(UPDATED_FCTY_ID);
        assertThat(testCerf.getMnfctrId()).isEqualTo(UPDATED_MNFCTR_ID);
        assertThat(testCerf.getIssuDt()).isEqualTo(UPDATED_ISSU_DT);
        assertThat(testCerf.getExpDt()).isEqualTo(UPDATED_EXP_DT);
    }

    @Test
    @Transactional
    void patchNonExistingCerf() throws Exception {
        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();
        cerf.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCerfMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, cerf.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(cerf))
            )
            .andExpect(status().isBadRequest());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCerf() throws Exception {
        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();
        cerf.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCerfMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(cerf))
            )
            .andExpect(status().isBadRequest());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCerf() throws Exception {
        int databaseSizeBeforeUpdate = cerfRepository.findAll().size();
        cerf.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCerfMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(cerf)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Cerf in the database
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCerf() throws Exception {
        // Initialize the database
        cerfRepository.saveAndFlush(cerf);

        int databaseSizeBeforeDelete = cerfRepository.findAll().size();

        // Delete the cerf
        restCerfMockMvc
            .perform(delete(ENTITY_API_URL_ID, cerf.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Cerf> cerfList = cerfRepository.findAll();
        assertThat(cerfList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
