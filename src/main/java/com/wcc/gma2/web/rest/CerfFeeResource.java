package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfFeeRepository;
import com.wcc.gma2.service.CerfFeeQueryService;
import com.wcc.gma2.service.CerfFeeService;
import com.wcc.gma2.service.criteria.CerfFeeCriteria;
import com.wcc.gma2.service.dto.CerfFeeDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.CerfFee}.
 */
@RestController
@RequestMapping("/api")
public class CerfFeeResource {

    private final Logger log = LoggerFactory.getLogger(CerfFeeResource.class);

    private static final String ENTITY_NAME = "cerfFee";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CerfFeeService cerfFeeService;

    private final CerfFeeRepository cerfFeeRepository;

    private final CerfFeeQueryService cerfFeeQueryService;

    public CerfFeeResource(CerfFeeService cerfFeeService, CerfFeeRepository cerfFeeRepository, CerfFeeQueryService cerfFeeQueryService) {
        this.cerfFeeService = cerfFeeService;
        this.cerfFeeRepository = cerfFeeRepository;
        this.cerfFeeQueryService = cerfFeeQueryService;
    }

    /**
     * {@code POST  /cerf-fees} : Create a new cerfFee.
     *
     * @param cerfFeeDTO the cerfFeeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cerfFeeDTO, or with status {@code 400 (Bad Request)} if the cerfFee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cerf-fees")
    public ResponseEntity<CerfFeeDTO> createCerfFee(@RequestBody CerfFeeDTO cerfFeeDTO) throws URISyntaxException {
        log.debug("REST request to save CerfFee : {}", cerfFeeDTO);
        if (cerfFeeDTO.getId() != null) {
            throw new BadRequestAlertException("A new cerfFee cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CerfFeeDTO result = cerfFeeService.save(cerfFeeDTO);
        return ResponseEntity
            .created(new URI("/api/cerf-fees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cerf-fees/:id} : Updates an existing cerfFee.
     *
     * @param id the id of the cerfFeeDTO to save.
     * @param cerfFeeDTO the cerfFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfFeeDTO,
     * or with status {@code 400 (Bad Request)} if the cerfFeeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cerfFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cerf-fees/{id}")
    public ResponseEntity<CerfFeeDTO> updateCerfFee(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CerfFeeDTO cerfFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CerfFee : {}, {}", id, cerfFeeDTO);
        if (cerfFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CerfFeeDTO result = cerfFeeService.update(cerfFeeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfFeeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cerf-fees/:id} : Partial updates given fields of an existing cerfFee, field will ignore if it is null
     *
     * @param id the id of the cerfFeeDTO to save.
     * @param cerfFeeDTO the cerfFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfFeeDTO,
     * or with status {@code 400 (Bad Request)} if the cerfFeeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cerfFeeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cerfFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cerf-fees/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CerfFeeDTO> partialUpdateCerfFee(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CerfFeeDTO cerfFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CerfFee partially : {}, {}", id, cerfFeeDTO);
        if (cerfFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CerfFeeDTO> result = cerfFeeService.partialUpdate(cerfFeeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfFeeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cerf-fees} : get all the cerfFees.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfFees in body.
     */
    @GetMapping("/cerf-fees")
    public ResponseEntity<List<CerfFeeDTO>> getAllCerfFees(
        CerfFeeCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get CerfFees by criteria: {}", criteria);
        Page<CerfFeeDTO> page = cerfFeeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-fees/count} : count all the cerfFees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-fees/count")
    public ResponseEntity<Long> countCerfFees(CerfFeeCriteria criteria) {
        log.debug("REST request to count CerfFees by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfFeeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-fees/:id} : get the "id" cerfFee.
     *
     * @param id the id of the cerfFeeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfFeeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-fees/{id}")
    public ResponseEntity<CerfFeeDTO> getCerfFee(@PathVariable Long id) {
        log.debug("REST request to get CerfFee : {}", id);
        Optional<CerfFeeDTO> cerfFeeDTO = cerfFeeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfFeeDTO);
    }

    /**
     * {@code DELETE  /cerf-fees/:id} : delete the "id" cerfFee.
     *
     * @param id the id of the cerfFeeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cerf-fees/{id}")
    public ResponseEntity<Void> deleteCerfFee(@PathVariable Long id) {
        log.debug("REST request to delete CerfFee : {}", id);
        cerfFeeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
