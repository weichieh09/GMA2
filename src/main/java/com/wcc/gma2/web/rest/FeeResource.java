package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.FeeRepository;
import com.wcc.gma2.service.FeeQueryService;
import com.wcc.gma2.service.FeeService;
import com.wcc.gma2.service.criteria.FeeCriteria;
import com.wcc.gma2.service.dto.FeeDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Fee}.
 */
@RestController
@RequestMapping("/api")
public class FeeResource {

    private final Logger log = LoggerFactory.getLogger(FeeResource.class);

    private static final String ENTITY_NAME = "fee";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FeeService feeService;

    private final FeeRepository feeRepository;

    private final FeeQueryService feeQueryService;

    public FeeResource(FeeService feeService, FeeRepository feeRepository, FeeQueryService feeQueryService) {
        this.feeService = feeService;
        this.feeRepository = feeRepository;
        this.feeQueryService = feeQueryService;
    }

    /**
     * {@code POST  /fees} : Create a new fee.
     *
     * @param feeDTO the feeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new feeDTO, or with status {@code 400 (Bad Request)} if the fee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/fees")
    public ResponseEntity<FeeDTO> createFee(@Valid @RequestBody FeeDTO feeDTO) throws URISyntaxException {
        log.debug("REST request to save Fee : {}", feeDTO);
        if (feeDTO.getId() != null) {
            throw new BadRequestAlertException("A new fee cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FeeDTO result = feeService.save(feeDTO);
        return ResponseEntity
            .created(new URI("/api/fees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /fees/:id} : Updates an existing fee.
     *
     * @param id the id of the feeDTO to save.
     * @param feeDTO the feeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated feeDTO,
     * or with status {@code 400 (Bad Request)} if the feeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the feeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/fees/{id}")
    public ResponseEntity<FeeDTO> updateFee(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody FeeDTO feeDTO)
        throws URISyntaxException {
        log.debug("REST request to update Fee : {}, {}", id, feeDTO);
        if (feeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, feeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!feeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        FeeDTO result = feeService.update(feeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, feeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /fees/:id} : Partial updates given fields of an existing fee, field will ignore if it is null
     *
     * @param id the id of the feeDTO to save.
     * @param feeDTO the feeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated feeDTO,
     * or with status {@code 400 (Bad Request)} if the feeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the feeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the feeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/fees/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FeeDTO> partialUpdateFee(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody FeeDTO feeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Fee partially : {}, {}", id, feeDTO);
        if (feeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, feeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!feeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FeeDTO> result = feeService.partialUpdate(feeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, feeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /fees} : get all the fees.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fees in body.
     */
    @GetMapping("/fees")
    public ResponseEntity<List<FeeDTO>> getAllFees(FeeCriteria criteria, @org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get Fees by criteria: {}", criteria);
        Page<FeeDTO> page = feeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /fees/count} : count all the fees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/fees/count")
    public ResponseEntity<Long> countFees(FeeCriteria criteria) {
        log.debug("REST request to count Fees by criteria: {}", criteria);
        return ResponseEntity.ok().body(feeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /fees/:id} : get the "id" fee.
     *
     * @param id the id of the feeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the feeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/fees/{id}")
    public ResponseEntity<FeeDTO> getFee(@PathVariable Long id) {
        log.debug("REST request to get Fee : {}", id);
        Optional<FeeDTO> feeDTO = feeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(feeDTO);
    }

    /**
     * {@code DELETE  /fees/:id} : delete the "id" fee.
     *
     * @param id the id of the feeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/fees/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable Long id) {
        log.debug("REST request to delete Fee : {}", id);
        feeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
