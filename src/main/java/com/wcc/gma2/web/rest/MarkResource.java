package com.wcc.gma2.web.rest;

import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.repository.MarkRepository;
import com.wcc.gma2.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.wcc.gma2.domain.Mark}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MarkResource {

    private final Logger log = LoggerFactory.getLogger(MarkResource.class);

    private static final String ENTITY_NAME = "mark";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MarkRepository markRepository;

    public MarkResource(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    /**
     * {@code POST  /marks} : Create a new mark.
     *
     * @param mark the mark to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mark, or with status {@code 400 (Bad Request)} if the mark has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/marks")
    public ResponseEntity<Mark> createMark(@RequestBody Mark mark) throws URISyntaxException {
        log.debug("REST request to save Mark : {}", mark);
        if (mark.getId() != null) {
            throw new BadRequestAlertException("A new mark cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Mark result = markRepository.save(mark);
        return ResponseEntity
            .created(new URI("/api/marks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /marks/:id} : Updates an existing mark.
     *
     * @param id the id of the mark to save.
     * @param mark the mark to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mark,
     * or with status {@code 400 (Bad Request)} if the mark is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mark couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/marks/{id}")
    public ResponseEntity<Mark> updateMark(@PathVariable(value = "id", required = false) final Long id, @RequestBody Mark mark)
        throws URISyntaxException {
        log.debug("REST request to update Mark : {}, {}", id, mark);
        if (mark.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, mark.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!markRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Mark result = markRepository.save(mark);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mark.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /marks/:id} : Partial updates given fields of an existing mark, field will ignore if it is null
     *
     * @param id the id of the mark to save.
     * @param mark the mark to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mark,
     * or with status {@code 400 (Bad Request)} if the mark is not valid,
     * or with status {@code 404 (Not Found)} if the mark is not found,
     * or with status {@code 500 (Internal Server Error)} if the mark couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/marks/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Mark> partialUpdateMark(@PathVariable(value = "id", required = false) final Long id, @RequestBody Mark mark)
        throws URISyntaxException {
        log.debug("REST request to partial update Mark partially : {}, {}", id, mark);
        if (mark.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, mark.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!markRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Mark> result = markRepository
            .findById(mark.getId())
            .map(existingMark -> {
                if (mark.getName() != null) {
                    existingMark.setName(mark.getName());
                }
                if (mark.getImg() != null) {
                    existingMark.setImg(mark.getImg());
                }
                if (mark.getImgContentType() != null) {
                    existingMark.setImgContentType(mark.getImgContentType());
                }

                return existingMark;
            })
            .map(markRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mark.getId().toString())
        );
    }

    /**
     * {@code GET  /marks} : get all the marks.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of marks in body.
     */
    @GetMapping("/marks")
    public List<Mark> getAllMarks() {
        log.debug("REST request to get all Marks");
        return markRepository.findAll();
    }

    /**
     * {@code GET  /marks/:id} : get the "id" mark.
     *
     * @param id the id of the mark to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mark, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/marks/{id}")
    public ResponseEntity<Mark> getMark(@PathVariable Long id) {
        log.debug("REST request to get Mark : {}", id);
        Optional<Mark> mark = markRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mark);
    }

    /**
     * {@code DELETE  /marks/:id} : delete the "id" mark.
     *
     * @param id the id of the mark to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/marks/{id}")
    public ResponseEntity<Void> deleteMark(@PathVariable Long id) {
        log.debug("REST request to delete Mark : {}", id);
        markRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
