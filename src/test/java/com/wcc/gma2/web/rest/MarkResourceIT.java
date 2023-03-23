package com.wcc.gma2.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wcc.gma2.IntegrationTest;
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.repository.MarkRepository;
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
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link MarkResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class MarkResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMG = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMG = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMG_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMG_CONTENT_TYPE = "image/png";

    private static final String ENTITY_API_URL = "/api/marks";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMarkMockMvc;

    private Mark mark;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Mark createEntity(EntityManager em) {
        Mark mark = new Mark().name(DEFAULT_NAME).img(DEFAULT_IMG).imgContentType(DEFAULT_IMG_CONTENT_TYPE);
        return mark;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Mark createUpdatedEntity(EntityManager em) {
        Mark mark = new Mark().name(UPDATED_NAME).img(UPDATED_IMG).imgContentType(UPDATED_IMG_CONTENT_TYPE);
        return mark;
    }

    @BeforeEach
    public void initTest() {
        mark = createEntity(em);
    }

    @Test
    @Transactional
    void createMark() throws Exception {
        int databaseSizeBeforeCreate = markRepository.findAll().size();
        // Create the Mark
        restMarkMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(mark)))
            .andExpect(status().isCreated());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeCreate + 1);
        Mark testMark = markList.get(markList.size() - 1);
        assertThat(testMark.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testMark.getImg()).isEqualTo(DEFAULT_IMG);
        assertThat(testMark.getImgContentType()).isEqualTo(DEFAULT_IMG_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void createMarkWithExistingId() throws Exception {
        // Create the Mark with an existing ID
        mark.setId(1L);

        int databaseSizeBeforeCreate = markRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restMarkMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(mark)))
            .andExpect(status().isBadRequest());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllMarks() throws Exception {
        // Initialize the database
        markRepository.saveAndFlush(mark);

        // Get all the markList
        restMarkMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mark.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].imgContentType").value(hasItem(DEFAULT_IMG_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].img").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMG))));
    }

    @Test
    @Transactional
    void getMark() throws Exception {
        // Initialize the database
        markRepository.saveAndFlush(mark);

        // Get the mark
        restMarkMockMvc
            .perform(get(ENTITY_API_URL_ID, mark.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mark.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.imgContentType").value(DEFAULT_IMG_CONTENT_TYPE))
            .andExpect(jsonPath("$.img").value(Base64Utils.encodeToString(DEFAULT_IMG)));
    }

    @Test
    @Transactional
    void getNonExistingMark() throws Exception {
        // Get the mark
        restMarkMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingMark() throws Exception {
        // Initialize the database
        markRepository.saveAndFlush(mark);

        int databaseSizeBeforeUpdate = markRepository.findAll().size();

        // Update the mark
        Mark updatedMark = markRepository.findById(mark.getId()).get();
        // Disconnect from session so that the updates on updatedMark are not directly saved in db
        em.detach(updatedMark);
        updatedMark.name(UPDATED_NAME).img(UPDATED_IMG).imgContentType(UPDATED_IMG_CONTENT_TYPE);

        restMarkMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedMark.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedMark))
            )
            .andExpect(status().isOk());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
        Mark testMark = markList.get(markList.size() - 1);
        assertThat(testMark.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMark.getImg()).isEqualTo(UPDATED_IMG);
        assertThat(testMark.getImgContentType()).isEqualTo(UPDATED_IMG_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void putNonExistingMark() throws Exception {
        int databaseSizeBeforeUpdate = markRepository.findAll().size();
        mark.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMarkMockMvc
            .perform(
                put(ENTITY_API_URL_ID, mark.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(mark))
            )
            .andExpect(status().isBadRequest());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchMark() throws Exception {
        int databaseSizeBeforeUpdate = markRepository.findAll().size();
        mark.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMarkMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(mark))
            )
            .andExpect(status().isBadRequest());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamMark() throws Exception {
        int databaseSizeBeforeUpdate = markRepository.findAll().size();
        mark.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMarkMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(mark)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateMarkWithPatch() throws Exception {
        // Initialize the database
        markRepository.saveAndFlush(mark);

        int databaseSizeBeforeUpdate = markRepository.findAll().size();

        // Update the mark using partial update
        Mark partialUpdatedMark = new Mark();
        partialUpdatedMark.setId(mark.getId());

        partialUpdatedMark.name(UPDATED_NAME);

        restMarkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedMark.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedMark))
            )
            .andExpect(status().isOk());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
        Mark testMark = markList.get(markList.size() - 1);
        assertThat(testMark.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMark.getImg()).isEqualTo(DEFAULT_IMG);
        assertThat(testMark.getImgContentType()).isEqualTo(DEFAULT_IMG_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void fullUpdateMarkWithPatch() throws Exception {
        // Initialize the database
        markRepository.saveAndFlush(mark);

        int databaseSizeBeforeUpdate = markRepository.findAll().size();

        // Update the mark using partial update
        Mark partialUpdatedMark = new Mark();
        partialUpdatedMark.setId(mark.getId());

        partialUpdatedMark.name(UPDATED_NAME).img(UPDATED_IMG).imgContentType(UPDATED_IMG_CONTENT_TYPE);

        restMarkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedMark.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedMark))
            )
            .andExpect(status().isOk());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
        Mark testMark = markList.get(markList.size() - 1);
        assertThat(testMark.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMark.getImg()).isEqualTo(UPDATED_IMG);
        assertThat(testMark.getImgContentType()).isEqualTo(UPDATED_IMG_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void patchNonExistingMark() throws Exception {
        int databaseSizeBeforeUpdate = markRepository.findAll().size();
        mark.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMarkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, mark.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(mark))
            )
            .andExpect(status().isBadRequest());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchMark() throws Exception {
        int databaseSizeBeforeUpdate = markRepository.findAll().size();
        mark.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMarkMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(mark))
            )
            .andExpect(status().isBadRequest());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamMark() throws Exception {
        int databaseSizeBeforeUpdate = markRepository.findAll().size();
        mark.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMarkMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(mark)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Mark in the database
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteMark() throws Exception {
        // Initialize the database
        markRepository.saveAndFlush(mark);

        int databaseSizeBeforeDelete = markRepository.findAll().size();

        // Delete the mark
        restMarkMockMvc
            .perform(delete(ENTITY_API_URL_ID, mark.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Mark> markList = markRepository.findAll();
        assertThat(markList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
