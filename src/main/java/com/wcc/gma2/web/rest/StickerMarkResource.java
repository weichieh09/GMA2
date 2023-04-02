package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.StickerMarkRepository;
import com.wcc.gma2.service.StickerMarkQueryService;
import com.wcc.gma2.service.StickerMarkService;
import com.wcc.gma2.service.criteria.StickerMarkCriteria;
import com.wcc.gma2.service.dto.StickerMarkDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.StickerMark}.
 */
@RestController
@RequestMapping("/api")
public class StickerMarkResource {

    private final Logger log = LoggerFactory.getLogger(StickerMarkResource.class);

    private static final String ENTITY_NAME = "stickerMark";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StickerMarkService stickerMarkService;

    private final StickerMarkRepository stickerMarkRepository;

    private final StickerMarkQueryService stickerMarkQueryService;

    public StickerMarkResource(
        StickerMarkService stickerMarkService,
        StickerMarkRepository stickerMarkRepository,
        StickerMarkQueryService stickerMarkQueryService
    ) {
        this.stickerMarkService = stickerMarkService;
        this.stickerMarkRepository = stickerMarkRepository;
        this.stickerMarkQueryService = stickerMarkQueryService;
    }

    /**
     * {@code POST  /sticker-marks} : Create a new stickerMark.
     *
     * @param stickerMarkDTO the stickerMarkDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stickerMarkDTO, or with status {@code 400 (Bad Request)} if the stickerMark has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sticker-marks")
    public ResponseEntity<StickerMarkDTO> createStickerMark(@Valid @RequestBody StickerMarkDTO stickerMarkDTO) throws URISyntaxException {
        log.debug("REST request to save StickerMark : {}", stickerMarkDTO);
        if (stickerMarkDTO.getId() != null) {
            throw new BadRequestAlertException("A new stickerMark cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StickerMarkDTO result = stickerMarkService.save(stickerMarkDTO);
        return ResponseEntity
            .created(new URI("/api/sticker-marks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sticker-marks/:id} : Updates an existing stickerMark.
     *
     * @param id the id of the stickerMarkDTO to save.
     * @param stickerMarkDTO the stickerMarkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stickerMarkDTO,
     * or with status {@code 400 (Bad Request)} if the stickerMarkDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stickerMarkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sticker-marks/{id}")
    public ResponseEntity<StickerMarkDTO> updateStickerMark(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody StickerMarkDTO stickerMarkDTO
    ) throws URISyntaxException {
        log.debug("REST request to update StickerMark : {}, {}", id, stickerMarkDTO);
        if (stickerMarkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stickerMarkDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stickerMarkRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        StickerMarkDTO result = stickerMarkService.update(stickerMarkDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stickerMarkDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /sticker-marks/:id} : Partial updates given fields of an existing stickerMark, field will ignore if it is null
     *
     * @param id the id of the stickerMarkDTO to save.
     * @param stickerMarkDTO the stickerMarkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stickerMarkDTO,
     * or with status {@code 400 (Bad Request)} if the stickerMarkDTO is not valid,
     * or with status {@code 404 (Not Found)} if the stickerMarkDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the stickerMarkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/sticker-marks/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<StickerMarkDTO> partialUpdateStickerMark(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody StickerMarkDTO stickerMarkDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update StickerMark partially : {}, {}", id, stickerMarkDTO);
        if (stickerMarkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stickerMarkDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stickerMarkRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<StickerMarkDTO> result = stickerMarkService.partialUpdate(stickerMarkDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stickerMarkDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /sticker-marks} : get all the stickerMarks.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stickerMarks in body.
     */
    @GetMapping("/sticker-marks")
    public ResponseEntity<List<StickerMarkDTO>> getAllStickerMarks(
        StickerMarkCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get StickerMarks by criteria: {}", criteria);
        Page<StickerMarkDTO> page = stickerMarkQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sticker-marks/count} : count all the stickerMarks.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/sticker-marks/count")
    public ResponseEntity<Long> countStickerMarks(StickerMarkCriteria criteria) {
        log.debug("REST request to count StickerMarks by criteria: {}", criteria);
        return ResponseEntity.ok().body(stickerMarkQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /sticker-marks/:id} : get the "id" stickerMark.
     *
     * @param id the id of the stickerMarkDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stickerMarkDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sticker-marks/{id}")
    public ResponseEntity<StickerMarkDTO> getStickerMark(@PathVariable Long id) {
        log.debug("REST request to get StickerMark : {}", id);
        Optional<StickerMarkDTO> stickerMarkDTO = stickerMarkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stickerMarkDTO);
    }

    /**
     * {@code DELETE  /sticker-marks/:id} : delete the "id" stickerMark.
     *
     * @param id the id of the stickerMarkDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sticker-marks/{id}")
    public ResponseEntity<Void> deleteStickerMark(@PathVariable Long id) {
        log.debug("REST request to delete StickerMark : {}", id);
        stickerMarkService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
