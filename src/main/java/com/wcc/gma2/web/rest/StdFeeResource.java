package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.StdFeeRepository;
import com.wcc.gma2.service.StdFeeQueryService;
import com.wcc.gma2.service.StdFeeService;
import com.wcc.gma2.service.criteria.StdFeeCriteria;
import com.wcc.gma2.service.dto.StdFeeDTO;
import com.wcc.gma2.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
 * REST controller for managing {@link com.wcc.gma2.domain.StdFee}.
 */
@RestController
@RequestMapping("/api")
public class StdFeeResource {

    private final Logger log = LoggerFactory.getLogger(StdFeeResource.class);

    private static final String ENTITY_NAME = "stdFee";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StdFeeService stdFeeService;

    private final StdFeeRepository stdFeeRepository;

    private final StdFeeQueryService stdFeeQueryService;

    public StdFeeResource(StdFeeService stdFeeService, StdFeeRepository stdFeeRepository, StdFeeQueryService stdFeeQueryService) {
        this.stdFeeService = stdFeeService;
        this.stdFeeRepository = stdFeeRepository;
        this.stdFeeQueryService = stdFeeQueryService;
    }

    /**
     * {@code POST  /std-fees} : Create a new stdFee.
     *
     * @param stdFeeDTO the stdFeeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stdFeeDTO, or with status {@code 400 (Bad Request)} if the stdFee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/std-fees")
    public ResponseEntity<StdFeeDTO> createStdFee(@RequestBody StdFeeDTO stdFeeDTO) throws URISyntaxException {
        log.debug("REST request to save StdFee : {}", stdFeeDTO);
        if (stdFeeDTO.getId() != null) {
            throw new BadRequestAlertException("A new stdFee cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StdFeeDTO result = stdFeeService.save(stdFeeDTO);
        return ResponseEntity
            .created(new URI("/api/std-fees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /std-fees/:id} : Updates an existing stdFee.
     *
     * @param id the id of the stdFeeDTO to save.
     * @param stdFeeDTO the stdFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stdFeeDTO,
     * or with status {@code 400 (Bad Request)} if the stdFeeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stdFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/std-fees/{id}")
    public ResponseEntity<StdFeeDTO> updateStdFee(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StdFeeDTO stdFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update StdFee : {}, {}", id, stdFeeDTO);
        if (stdFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stdFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stdFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        StdFeeDTO result = stdFeeService.update(stdFeeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stdFeeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /std-fees/:id} : Partial updates given fields of an existing stdFee, field will ignore if it is null
     *
     * @param id the id of the stdFeeDTO to save.
     * @param stdFeeDTO the stdFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stdFeeDTO,
     * or with status {@code 400 (Bad Request)} if the stdFeeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the stdFeeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the stdFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/std-fees/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<StdFeeDTO> partialUpdateStdFee(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StdFeeDTO stdFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update StdFee partially : {}, {}", id, stdFeeDTO);
        if (stdFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stdFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stdFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<StdFeeDTO> result = stdFeeService.partialUpdate(stdFeeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stdFeeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /std-fees} : get all the stdFees.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stdFees in body.
     */
    @GetMapping("/std-fees")
    public ResponseEntity<List<StdFeeDTO>> getAllStdFees(
        StdFeeCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get StdFees by criteria: {}", criteria);
        Page<StdFeeDTO> page = stdFeeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /std-fees/count} : count all the stdFees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/std-fees/count")
    public ResponseEntity<Long> countStdFees(StdFeeCriteria criteria) {
        log.debug("REST request to count StdFees by criteria: {}", criteria);
        return ResponseEntity.ok().body(stdFeeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /std-fees/:id} : get the "id" stdFee.
     *
     * @param id the id of the stdFeeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stdFeeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/std-fees/{id}")
    public ResponseEntity<StdFeeDTO> getStdFee(@PathVariable Long id) {
        log.debug("REST request to get StdFee : {}", id);
        Optional<StdFeeDTO> stdFeeDTO = stdFeeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stdFeeDTO);
    }

    /**
     * {@code DELETE  /std-fees/:id} : delete the "id" stdFee.
     *
     * @param id the id of the stdFeeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/std-fees/{id}")
    public ResponseEntity<Void> deleteStdFee(@PathVariable Long id) {
        log.debug("REST request to delete StdFee : {}", id);
        stdFeeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
