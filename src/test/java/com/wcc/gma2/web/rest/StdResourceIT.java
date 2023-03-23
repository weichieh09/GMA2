package com.wcc.gma2.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wcc.gma2.IntegrationTest;
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.repository.StdRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link StdResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class StdResourceIT {

    private static final String DEFAULT_STD_NO = "AAAAAAAAAA";
    private static final String UPDATED_STD_NO = "BBBBBBBBBB";

    private static final String DEFAULT_STD_VER = "AAAAAAAAAA";
    private static final String UPDATED_STD_VER = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Long DEFAULT_FEE = 1L;
    private static final Long UPDATED_FEE = 2L;

    private static final LocalDate DEFAULT_ISSU_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ISSU_DT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXP_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXP_DT = LocalDate.now(ZoneId.systemDefault());

    private static final String ENTITY_API_URL = "/api/stds";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private StdRepository stdRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restStdMockMvc;

    private Std std;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Std createEntity(EntityManager em) {
        Std std = new Std()
            .stdNo(DEFAULT_STD_NO)
            .stdVer(DEFAULT_STD_VER)
            .name(DEFAULT_NAME)
            .status(DEFAULT_STATUS)
            .fee(DEFAULT_FEE)
            .issuDt(DEFAULT_ISSU_DT)
            .expDt(DEFAULT_EXP_DT);
        return std;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Std createUpdatedEntity(EntityManager em) {
        Std std = new Std()
            .stdNo(UPDATED_STD_NO)
            .stdVer(UPDATED_STD_VER)
            .name(UPDATED_NAME)
            .status(UPDATED_STATUS)
            .fee(UPDATED_FEE)
            .issuDt(UPDATED_ISSU_DT)
            .expDt(UPDATED_EXP_DT);
        return std;
    }

    @BeforeEach
    public void initTest() {
        std = createEntity(em);
    }

    @Test
    @Transactional
    void createStd() throws Exception {
        int databaseSizeBeforeCreate = stdRepository.findAll().size();
        // Create the Std
        restStdMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(std)))
            .andExpect(status().isCreated());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeCreate + 1);
        Std testStd = stdList.get(stdList.size() - 1);
        assertThat(testStd.getStdNo()).isEqualTo(DEFAULT_STD_NO);
        assertThat(testStd.getStdVer()).isEqualTo(DEFAULT_STD_VER);
        assertThat(testStd.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testStd.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testStd.getFee()).isEqualTo(DEFAULT_FEE);
        assertThat(testStd.getIssuDt()).isEqualTo(DEFAULT_ISSU_DT);
        assertThat(testStd.getExpDt()).isEqualTo(DEFAULT_EXP_DT);
    }

    @Test
    @Transactional
    void createStdWithExistingId() throws Exception {
        // Create the Std with an existing ID
        std.setId(1L);

        int databaseSizeBeforeCreate = stdRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restStdMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(std)))
            .andExpect(status().isBadRequest());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllStds() throws Exception {
        // Initialize the database
        stdRepository.saveAndFlush(std);

        // Get all the stdList
        restStdMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(std.getId().intValue())))
            .andExpect(jsonPath("$.[*].stdNo").value(hasItem(DEFAULT_STD_NO)))
            .andExpect(jsonPath("$.[*].stdVer").value(hasItem(DEFAULT_STD_VER)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].fee").value(hasItem(DEFAULT_FEE.intValue())))
            .andExpect(jsonPath("$.[*].issuDt").value(hasItem(DEFAULT_ISSU_DT.toString())))
            .andExpect(jsonPath("$.[*].expDt").value(hasItem(DEFAULT_EXP_DT.toString())));
    }

    @Test
    @Transactional
    void getStd() throws Exception {
        // Initialize the database
        stdRepository.saveAndFlush(std);

        // Get the std
        restStdMockMvc
            .perform(get(ENTITY_API_URL_ID, std.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(std.getId().intValue()))
            .andExpect(jsonPath("$.stdNo").value(DEFAULT_STD_NO))
            .andExpect(jsonPath("$.stdVer").value(DEFAULT_STD_VER))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.fee").value(DEFAULT_FEE.intValue()))
            .andExpect(jsonPath("$.issuDt").value(DEFAULT_ISSU_DT.toString()))
            .andExpect(jsonPath("$.expDt").value(DEFAULT_EXP_DT.toString()));
    }

    @Test
    @Transactional
    void getNonExistingStd() throws Exception {
        // Get the std
        restStdMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingStd() throws Exception {
        // Initialize the database
        stdRepository.saveAndFlush(std);

        int databaseSizeBeforeUpdate = stdRepository.findAll().size();

        // Update the std
        Std updatedStd = stdRepository.findById(std.getId()).get();
        // Disconnect from session so that the updates on updatedStd are not directly saved in db
        em.detach(updatedStd);
        updatedStd
            .stdNo(UPDATED_STD_NO)
            .stdVer(UPDATED_STD_VER)
            .name(UPDATED_NAME)
            .status(UPDATED_STATUS)
            .fee(UPDATED_FEE)
            .issuDt(UPDATED_ISSU_DT)
            .expDt(UPDATED_EXP_DT);

        restStdMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedStd.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedStd))
            )
            .andExpect(status().isOk());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
        Std testStd = stdList.get(stdList.size() - 1);
        assertThat(testStd.getStdNo()).isEqualTo(UPDATED_STD_NO);
        assertThat(testStd.getStdVer()).isEqualTo(UPDATED_STD_VER);
        assertThat(testStd.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testStd.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testStd.getFee()).isEqualTo(UPDATED_FEE);
        assertThat(testStd.getIssuDt()).isEqualTo(UPDATED_ISSU_DT);
        assertThat(testStd.getExpDt()).isEqualTo(UPDATED_EXP_DT);
    }

    @Test
    @Transactional
    void putNonExistingStd() throws Exception {
        int databaseSizeBeforeUpdate = stdRepository.findAll().size();
        std.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStdMockMvc
            .perform(
                put(ENTITY_API_URL_ID, std.getId()).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(std))
            )
            .andExpect(status().isBadRequest());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchStd() throws Exception {
        int databaseSizeBeforeUpdate = stdRepository.findAll().size();
        std.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStdMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(std))
            )
            .andExpect(status().isBadRequest());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamStd() throws Exception {
        int databaseSizeBeforeUpdate = stdRepository.findAll().size();
        std.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStdMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(std)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateStdWithPatch() throws Exception {
        // Initialize the database
        stdRepository.saveAndFlush(std);

        int databaseSizeBeforeUpdate = stdRepository.findAll().size();

        // Update the std using partial update
        Std partialUpdatedStd = new Std();
        partialUpdatedStd.setId(std.getId());

        partialUpdatedStd.stdVer(UPDATED_STD_VER).name(UPDATED_NAME).issuDt(UPDATED_ISSU_DT);

        restStdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedStd.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedStd))
            )
            .andExpect(status().isOk());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
        Std testStd = stdList.get(stdList.size() - 1);
        assertThat(testStd.getStdNo()).isEqualTo(DEFAULT_STD_NO);
        assertThat(testStd.getStdVer()).isEqualTo(UPDATED_STD_VER);
        assertThat(testStd.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testStd.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testStd.getFee()).isEqualTo(DEFAULT_FEE);
        assertThat(testStd.getIssuDt()).isEqualTo(UPDATED_ISSU_DT);
        assertThat(testStd.getExpDt()).isEqualTo(DEFAULT_EXP_DT);
    }

    @Test
    @Transactional
    void fullUpdateStdWithPatch() throws Exception {
        // Initialize the database
        stdRepository.saveAndFlush(std);

        int databaseSizeBeforeUpdate = stdRepository.findAll().size();

        // Update the std using partial update
        Std partialUpdatedStd = new Std();
        partialUpdatedStd.setId(std.getId());

        partialUpdatedStd
            .stdNo(UPDATED_STD_NO)
            .stdVer(UPDATED_STD_VER)
            .name(UPDATED_NAME)
            .status(UPDATED_STATUS)
            .fee(UPDATED_FEE)
            .issuDt(UPDATED_ISSU_DT)
            .expDt(UPDATED_EXP_DT);

        restStdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedStd.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedStd))
            )
            .andExpect(status().isOk());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
        Std testStd = stdList.get(stdList.size() - 1);
        assertThat(testStd.getStdNo()).isEqualTo(UPDATED_STD_NO);
        assertThat(testStd.getStdVer()).isEqualTo(UPDATED_STD_VER);
        assertThat(testStd.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testStd.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testStd.getFee()).isEqualTo(UPDATED_FEE);
        assertThat(testStd.getIssuDt()).isEqualTo(UPDATED_ISSU_DT);
        assertThat(testStd.getExpDt()).isEqualTo(UPDATED_EXP_DT);
    }

    @Test
    @Transactional
    void patchNonExistingStd() throws Exception {
        int databaseSizeBeforeUpdate = stdRepository.findAll().size();
        std.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, std.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(std))
            )
            .andExpect(status().isBadRequest());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchStd() throws Exception {
        int databaseSizeBeforeUpdate = stdRepository.findAll().size();
        std.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStdMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(std))
            )
            .andExpect(status().isBadRequest());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamStd() throws Exception {
        int databaseSizeBeforeUpdate = stdRepository.findAll().size();
        std.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStdMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(std)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Std in the database
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteStd() throws Exception {
        // Initialize the database
        stdRepository.saveAndFlush(std);

        int databaseSizeBeforeDelete = stdRepository.findAll().size();

        // Delete the std
        restStdMockMvc.perform(delete(ENTITY_API_URL_ID, std.getId()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Std> stdList = stdRepository.findAll();
        assertThat(stdList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
