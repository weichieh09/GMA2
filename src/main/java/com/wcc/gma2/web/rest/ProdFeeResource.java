package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.ProdFeeRepository;
import com.wcc.gma2.service.ProdFeeQueryService;
import com.wcc.gma2.service.ProdFeeService;
import com.wcc.gma2.service.criteria.ProdFeeCriteria;
import com.wcc.gma2.service.dto.ProdFeeDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.ProdFee}.
 */
@RestController
@RequestMapping("/api")
public class ProdFeeResource {

    private final Logger log = LoggerFactory.getLogger(ProdFeeResource.class);

    private static final String ENTITY_NAME = "prodFee";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProdFeeService prodFeeService;

    private final ProdFeeRepository prodFeeRepository;

    private final ProdFeeQueryService prodFeeQueryService;

    public ProdFeeResource(ProdFeeService prodFeeService, ProdFeeRepository prodFeeRepository, ProdFeeQueryService prodFeeQueryService) {
        this.prodFeeService = prodFeeService;
        this.prodFeeRepository = prodFeeRepository;
        this.prodFeeQueryService = prodFeeQueryService;
    }

    /**
     * {@code POST  /prod-fees} : Create a new prodFee.
     *
     * @param prodFeeDTO the prodFeeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prodFeeDTO, or with status {@code 400 (Bad Request)} if the prodFee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prod-fees")
    public ResponseEntity<ProdFeeDTO> createProdFee(@Valid @RequestBody ProdFeeDTO prodFeeDTO) throws URISyntaxException {
        log.debug("REST request to save ProdFee : {}", prodFeeDTO);
        if (prodFeeDTO.getId() != null) {
            throw new BadRequestAlertException("A new prodFee cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProdFeeDTO result = prodFeeService.save(prodFeeDTO);
        return ResponseEntity
            .created(new URI("/api/prod-fees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prod-fees/:id} : Updates an existing prodFee.
     *
     * @param id the id of the prodFeeDTO to save.
     * @param prodFeeDTO the prodFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prodFeeDTO,
     * or with status {@code 400 (Bad Request)} if the prodFeeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prodFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prod-fees/{id}")
    public ResponseEntity<ProdFeeDTO> updateProdFee(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ProdFeeDTO prodFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProdFee : {}, {}", id, prodFeeDTO);
        if (prodFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prodFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ProdFeeDTO result = prodFeeService.update(prodFeeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prodFeeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prod-fees/:id} : Partial updates given fields of an existing prodFee, field will ignore if it is null
     *
     * @param id the id of the prodFeeDTO to save.
     * @param prodFeeDTO the prodFeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prodFeeDTO,
     * or with status {@code 400 (Bad Request)} if the prodFeeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the prodFeeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the prodFeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prod-fees/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ProdFeeDTO> partialUpdateProdFee(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ProdFeeDTO prodFeeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProdFee partially : {}, {}", id, prodFeeDTO);
        if (prodFeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prodFeeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodFeeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ProdFeeDTO> result = prodFeeService.partialUpdate(prodFeeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prodFeeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /prod-fees} : get all the prodFees.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prodFees in body.
     */
    @GetMapping("/prod-fees")
    public ResponseEntity<List<ProdFeeDTO>> getAllProdFees(
        ProdFeeCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get ProdFees by criteria: {}", criteria);
        Page<ProdFeeDTO> page = prodFeeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /prod-fees/count} : count all the prodFees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/prod-fees/count")
    public ResponseEntity<Long> countProdFees(ProdFeeCriteria criteria) {
        log.debug("REST request to count ProdFees by criteria: {}", criteria);
        return ResponseEntity.ok().body(prodFeeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /prod-fees/:id} : get the "id" prodFee.
     *
     * @param id the id of the prodFeeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prodFeeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prod-fees/{id}")
    public ResponseEntity<ProdFeeDTO> getProdFee(@PathVariable Long id) {
        log.debug("REST request to get ProdFee : {}", id);
        Optional<ProdFeeDTO> prodFeeDTO = prodFeeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(prodFeeDTO);
    }

    /**
     * {@code DELETE  /prod-fees/:id} : delete the "id" prodFee.
     *
     * @param id the id of the prodFeeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prod-fees/{id}")
    public ResponseEntity<Void> deleteProdFee(@PathVariable Long id) {
        log.debug("REST request to delete ProdFee : {}", id);
        prodFeeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
