package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.FeeDescRepository;
import com.wcc.gma2.service.FeeDescQueryService;
import com.wcc.gma2.service.FeeDescService;
import com.wcc.gma2.service.criteria.FeeDescCriteria;
import com.wcc.gma2.service.dto.FeeDescDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.FeeDesc}.
 */
@RestController
@RequestMapping("/api")
public class FeeDescResource {

    private final Logger log = LoggerFactory.getLogger(FeeDescResource.class);

    private static final String ENTITY_NAME = "feeDesc";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FeeDescService feeDescService;

    private final FeeDescRepository feeDescRepository;

    private final FeeDescQueryService feeDescQueryService;

    public FeeDescResource(FeeDescService feeDescService, FeeDescRepository feeDescRepository, FeeDescQueryService feeDescQueryService) {
        this.feeDescService = feeDescService;
        this.feeDescRepository = feeDescRepository;
        this.feeDescQueryService = feeDescQueryService;
    }

    /**
     * {@code POST  /fee-descs} : Create a new feeDesc.
     *
     * @param feeDescDTO the feeDescDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new feeDescDTO, or with status {@code 400 (Bad Request)} if the feeDesc has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/fee-descs")
    public ResponseEntity<FeeDescDTO> createFeeDesc(@RequestBody FeeDescDTO feeDescDTO) throws URISyntaxException {
        log.debug("REST request to save FeeDesc : {}", feeDescDTO);
        if (feeDescDTO.getId() != null) {
            throw new BadRequestAlertException("A new feeDesc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FeeDescDTO result = feeDescService.save(feeDescDTO);
        return ResponseEntity
            .created(new URI("/api/fee-descs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /fee-descs/:id} : Updates an existing feeDesc.
     *
     * @param id the id of the feeDescDTO to save.
     * @param feeDescDTO the feeDescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated feeDescDTO,
     * or with status {@code 400 (Bad Request)} if the feeDescDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the feeDescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/fee-descs/{id}")
    public ResponseEntity<FeeDescDTO> updateFeeDesc(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FeeDescDTO feeDescDTO
    ) throws URISyntaxException {
        log.debug("REST request to update FeeDesc : {}, {}", id, feeDescDTO);
        if (feeDescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, feeDescDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!feeDescRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        FeeDescDTO result = feeDescService.update(feeDescDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, feeDescDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /fee-descs/:id} : Partial updates given fields of an existing feeDesc, field will ignore if it is null
     *
     * @param id the id of the feeDescDTO to save.
     * @param feeDescDTO the feeDescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated feeDescDTO,
     * or with status {@code 400 (Bad Request)} if the feeDescDTO is not valid,
     * or with status {@code 404 (Not Found)} if the feeDescDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the feeDescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/fee-descs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FeeDescDTO> partialUpdateFeeDesc(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FeeDescDTO feeDescDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update FeeDesc partially : {}, {}", id, feeDescDTO);
        if (feeDescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, feeDescDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!feeDescRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FeeDescDTO> result = feeDescService.partialUpdate(feeDescDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, feeDescDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /fee-descs} : get all the feeDescs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of feeDescs in body.
     */
    @GetMapping("/fee-descs")
    public ResponseEntity<List<FeeDescDTO>> getAllFeeDescs(
        FeeDescCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get FeeDescs by criteria: {}", criteria);
        Page<FeeDescDTO> page = feeDescQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /fee-descs/count} : count all the feeDescs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/fee-descs/count")
    public ResponseEntity<Long> countFeeDescs(FeeDescCriteria criteria) {
        log.debug("REST request to count FeeDescs by criteria: {}", criteria);
        return ResponseEntity.ok().body(feeDescQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /fee-descs/:id} : get the "id" feeDesc.
     *
     * @param id the id of the feeDescDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the feeDescDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/fee-descs/{id}")
    public ResponseEntity<FeeDescDTO> getFeeDesc(@PathVariable Long id) {
        log.debug("REST request to get FeeDesc : {}", id);
        Optional<FeeDescDTO> feeDescDTO = feeDescService.findOne(id);
        return ResponseUtil.wrapOrNotFound(feeDescDTO);
    }

    /**
     * {@code DELETE  /fee-descs/:id} : delete the "id" feeDesc.
     *
     * @param id the id of the feeDescDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/fee-descs/{id}")
    public ResponseEntity<Void> deleteFeeDesc(@PathVariable Long id) {
        log.debug("REST request to delete FeeDesc : {}", id);
        feeDescService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
