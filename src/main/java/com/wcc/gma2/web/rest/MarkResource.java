package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.MarkRepository;
import com.wcc.gma2.service.MarkQueryService;
import com.wcc.gma2.service.MarkService;
import com.wcc.gma2.service.criteria.MarkCriteria;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.wcc.gma2.domain.Mark}.
 */
@RestController
@RequestMapping("/api")
public class MarkResource {

    private final Logger log = LoggerFactory.getLogger(MarkResource.class);

    private static final String ENTITY_NAME = "mark";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MarkService markService;

    private final MarkRepository markRepository;

    private final MarkQueryService markQueryService;

    public MarkResource(MarkService markService, MarkRepository markRepository, MarkQueryService markQueryService) {
        this.markService = markService;
        this.markRepository = markRepository;
        this.markQueryService = markQueryService;
    }

    /**
     * {@code POST  /marks} : Create a new mark.
     *
     * @param markDTO the markDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new markDTO, or with status {@code 400 (Bad Request)} if the mark has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/marks")
    public ResponseEntity<MarkDTO> createMark(@Valid @RequestBody MarkDTO markDTO) throws URISyntaxException {
        log.debug("REST request to save Mark : {}", markDTO);
        if (markDTO.getId() != null) {
            throw new BadRequestAlertException("A new mark cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MarkDTO result = markService.save(markDTO);
        return ResponseEntity
            .created(new URI("/api/marks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /marks/:id} : Updates an existing mark.
     *
     * @param id the id of the markDTO to save.
     * @param markDTO the markDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated markDTO,
     * or with status {@code 400 (Bad Request)} if the markDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the markDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/marks/{id}")
    public ResponseEntity<MarkDTO> updateMark(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody MarkDTO markDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Mark : {}, {}", id, markDTO);
        if (markDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, markDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!markRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        MarkDTO result = markService.update(markDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, markDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /marks/:id} : Partial updates given fields of an existing mark, field will ignore if it is null
     *
     * @param id the id of the markDTO to save.
     * @param markDTO the markDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated markDTO,
     * or with status {@code 400 (Bad Request)} if the markDTO is not valid,
     * or with status {@code 404 (Not Found)} if the markDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the markDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/marks/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MarkDTO> partialUpdateMark(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody MarkDTO markDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Mark partially : {}, {}", id, markDTO);
        if (markDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, markDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!markRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<MarkDTO> result = markService.partialUpdate(markDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, markDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /marks} : get all the marks.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of marks in body.
     */
    @GetMapping("/marks")
    public ResponseEntity<List<MarkDTO>> getAllMarks(
        MarkCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Marks by criteria: {}", criteria);
        Page<MarkDTO> page = markQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /marks/count} : count all the marks.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/marks/count")
    public ResponseEntity<Long> countMarks(MarkCriteria criteria) {
        log.debug("REST request to count Marks by criteria: {}", criteria);
        return ResponseEntity.ok().body(markQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /marks/:id} : get the "id" mark.
     *
     * @param id the id of the markDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the markDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/marks/{id}")
    public ResponseEntity<MarkDTO> getMark(@PathVariable Long id) {
        log.debug("REST request to get Mark : {}", id);
        Optional<MarkDTO> markDTO = markService.findOne(id);
        return ResponseUtil.wrapOrNotFound(markDTO);
    }

    /**
     * {@code DELETE  /marks/:id} : delete the "id" mark.
     *
     * @param id the id of the markDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/marks/{id}")
    public ResponseEntity<Void> deleteMark(@PathVariable Long id) {
        log.debug("REST request to delete Mark : {}", id);
        markService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
