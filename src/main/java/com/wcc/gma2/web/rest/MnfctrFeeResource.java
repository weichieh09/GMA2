package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.MnfctrFeeRepository;
import com.wcc.gma2.service.MnfctrFeeQueryService;
import com.wcc.gma2.service.MnfctrFeeService;
import com.wcc.gma2.service.criteria.MnfctrFeeCriteria;
import com.wcc.gma2.service.dto.MnfctrFeeDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.MnfctrFee}.
 */
@RestController
@RequestMapping("/api")
public class MnfctrFeeResource {

    private final Logger log = LoggerFactory.getLogger(MnfctrFeeResource.class);

    private static final String ENTITY_NAME = "mnfctrFee";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MnfctrFeeService mnfctrFeeService;

    private final MnfctrFeeRepository mnfctrFeeRepository;

    private final MnfctrFeeQueryService mnfctrFeeQueryService;

    public MnfctrFeeResource(
        MnfctrFeeService mnfctrFeeService,
        MnfctrFeeRepository mnfctrFeeRepository,
        MnfctrFeeQueryService mnfctrFeeQueryService
    ) {
        this.mnfctrFeeService = mnfctrFeeService;
        this.mnfctrFeeRepository = mnfctrFeeRepository;
        this.mnfctrFeeQueryService = mnfctrFeeQueryService;
    }

    /**
     * {@code POST  /mnfctr-fees} : Create a new mnfctrFee.
     *
     * @param mnfctrFeeDTO the mnfctrFeeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mnfctrFeeDTO, or with status {@code 400 (Bad Request)} if the mnfctrFee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mnfctr-fees")
    public ResponseEntity<MnfctrFeeDTO> createMnfctrFee(@RequestBody MnfctrFeeDTO mnfctrFeeDTO) throws URISyntaxException {
        log.debug("REST request to save MnfctrFee : {}", mnfctrFeeDTO);
        if (mnfctrFeeDTO.getId() != null) {
            throw new BadRequestAlertException("A new mnfctrFee cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MnfctrFeeDTO result = mnfctrFeeService.save(mnfctrFeeDTO);
        return ResponseEntity
            .created(new URI("/api/mnfctr-fees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mnfctr-fees/:id} : Updates an existing mnfctrFee.
     *
     * @param id the id of the mnfctrFeeDTO to save.
     * @param mnfctrFeeDTO the mnfctrFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mnfctrFeeDTO,
     * or with status {@code 400 (Bad Request)} if the mnfctrFeeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mnfctrFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mnfctr-fees/{id}")
    public ResponseEntity<MnfctrFeeDTO> updateMnfctrFee(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MnfctrFeeDTO mnfctrFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update MnfctrFee : {}, {}", id, mnfctrFeeDTO);
        if (mnfctrFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, mnfctrFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!mnfctrFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        MnfctrFeeDTO result = mnfctrFeeService.update(mnfctrFeeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mnfctrFeeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /mnfctr-fees/:id} : Partial updates given fields of an existing mnfctrFee, field will ignore if it is null
     *
     * @param id the id of the mnfctrFeeDTO to save.
     * @param mnfctrFeeDTO the mnfctrFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mnfctrFeeDTO,
     * or with status {@code 400 (Bad Request)} if the mnfctrFeeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the mnfctrFeeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the mnfctrFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/mnfctr-fees/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MnfctrFeeDTO> partialUpdateMnfctrFee(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MnfctrFeeDTO mnfctrFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update MnfctrFee partially : {}, {}", id, mnfctrFeeDTO);
        if (mnfctrFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, mnfctrFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!mnfctrFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<MnfctrFeeDTO> result = mnfctrFeeService.partialUpdate(mnfctrFeeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mnfctrFeeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /mnfctr-fees} : get all the mnfctrFees.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mnfctrFees in body.
     */
    @GetMapping("/mnfctr-fees")
    public ResponseEntity<List<MnfctrFeeDTO>> getAllMnfctrFees(
        MnfctrFeeCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get MnfctrFees by criteria: {}", criteria);
        Page<MnfctrFeeDTO> page = mnfctrFeeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /mnfctr-fees/count} : count all the mnfctrFees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/mnfctr-fees/count")
    public ResponseEntity<Long> countMnfctrFees(MnfctrFeeCriteria criteria) {
        log.debug("REST request to count MnfctrFees by criteria: {}", criteria);
        return ResponseEntity.ok().body(mnfctrFeeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /mnfctr-fees/:id} : get the "id" mnfctrFee.
     *
     * @param id the id of the mnfctrFeeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mnfctrFeeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mnfctr-fees/{id}")
    public ResponseEntity<MnfctrFeeDTO> getMnfctrFee(@PathVariable Long id) {
        log.debug("REST request to get MnfctrFee : {}", id);
        Optional<MnfctrFeeDTO> mnfctrFeeDTO = mnfctrFeeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mnfctrFeeDTO);
    }

    /**
     * {@code DELETE  /mnfctr-fees/:id} : delete the "id" mnfctrFee.
     *
     * @param id the id of the mnfctrFeeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mnfctr-fees/{id}")
    public ResponseEntity<Void> deleteMnfctrFee(@PathVariable Long id) {
        log.debug("REST request to delete MnfctrFee : {}", id);
        mnfctrFeeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
