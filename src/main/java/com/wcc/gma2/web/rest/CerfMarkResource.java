package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfMarkRepository;
import com.wcc.gma2.service.CerfMarkQueryService;
import com.wcc.gma2.service.CerfMarkService;
import com.wcc.gma2.service.criteria.CerfMarkCriteria;
import com.wcc.gma2.service.dto.CerfMarkDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.CerfMark}.
 */
@RestController
@RequestMapping("/api")
public class CerfMarkResource {

    private final Logger log = LoggerFactory.getLogger(CerfMarkResource.class);

    private static final String ENTITY_NAME = "cerfMark";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CerfMarkService cerfMarkService;

    private final CerfMarkRepository cerfMarkRepository;

    private final CerfMarkQueryService cerfMarkQueryService;

    public CerfMarkResource(
        CerfMarkService cerfMarkService,
        CerfMarkRepository cerfMarkRepository,
        CerfMarkQueryService cerfMarkQueryService
    ) {
        this.cerfMarkService = cerfMarkService;
        this.cerfMarkRepository = cerfMarkRepository;
        this.cerfMarkQueryService = cerfMarkQueryService;
    }

    /**
     * {@code POST  /cerf-marks} : Create a new cerfMark.
     *
     * @param cerfMarkDTO the cerfMarkDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cerfMarkDTO, or with status {@code 400 (Bad Request)} if the cerfMark has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cerf-marks")
    public ResponseEntity<CerfMarkDTO> createCerfMark(@Valid @RequestBody CerfMarkDTO cerfMarkDTO) throws URISyntaxException {
        log.debug("REST request to save CerfMark : {}", cerfMarkDTO);
        if (cerfMarkDTO.getId() != null) {
            throw new BadRequestAlertException("A new cerfMark cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CerfMarkDTO result = cerfMarkService.save(cerfMarkDTO);
        return ResponseEntity
            .created(new URI("/api/cerf-marks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cerf-marks/:id} : Updates an existing cerfMark.
     *
     * @param id the id of the cerfMarkDTO to save.
     * @param cerfMarkDTO the cerfMarkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfMarkDTO,
     * or with status {@code 400 (Bad Request)} if the cerfMarkDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cerfMarkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cerf-marks/{id}")
    public ResponseEntity<CerfMarkDTO> updateCerfMark(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CerfMarkDTO cerfMarkDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CerfMark : {}, {}", id, cerfMarkDTO);
        if (cerfMarkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfMarkDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfMarkRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CerfMarkDTO result = cerfMarkService.update(cerfMarkDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfMarkDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cerf-marks/:id} : Partial updates given fields of an existing cerfMark, field will ignore if it is null
     *
     * @param id the id of the cerfMarkDTO to save.
     * @param cerfMarkDTO the cerfMarkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfMarkDTO,
     * or with status {@code 400 (Bad Request)} if the cerfMarkDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cerfMarkDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cerfMarkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cerf-marks/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CerfMarkDTO> partialUpdateCerfMark(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CerfMarkDTO cerfMarkDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CerfMark partially : {}, {}", id, cerfMarkDTO);
        if (cerfMarkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfMarkDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfMarkRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CerfMarkDTO> result = cerfMarkService.partialUpdate(cerfMarkDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfMarkDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cerf-marks} : get all the cerfMarks.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfMarks in body.
     */
    @GetMapping("/cerf-marks")
    public ResponseEntity<List<CerfMarkDTO>> getAllCerfMarks(
        CerfMarkCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get CerfMarks by criteria: {}", criteria);
        Page<CerfMarkDTO> page = cerfMarkQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-marks/count} : count all the cerfMarks.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-marks/count")
    public ResponseEntity<Long> countCerfMarks(CerfMarkCriteria criteria) {
        log.debug("REST request to count CerfMarks by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfMarkQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-marks/:id} : get the "id" cerfMark.
     *
     * @param id the id of the cerfMarkDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfMarkDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-marks/{id}")
    public ResponseEntity<CerfMarkDTO> getCerfMark(@PathVariable Long id) {
        log.debug("REST request to get CerfMark : {}", id);
        Optional<CerfMarkDTO> cerfMarkDTO = cerfMarkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfMarkDTO);
    }

    /**
     * {@code DELETE  /cerf-marks/:id} : delete the "id" cerfMark.
     *
     * @param id the id of the cerfMarkDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cerf-marks/{id}")
    public ResponseEntity<Void> deleteCerfMark(@PathVariable Long id) {
        log.debug("REST request to delete CerfMark : {}", id);
        cerfMarkService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
