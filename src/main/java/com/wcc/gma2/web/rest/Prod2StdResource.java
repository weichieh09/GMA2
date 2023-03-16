package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Prod2StdRepository;
import com.wcc.gma2.service.Prod2StdQueryService;
import com.wcc.gma2.service.Prod2StdService;
import com.wcc.gma2.service.criteria.Prod2StdCriteria;
import com.wcc.gma2.service.dto.Prod2StdDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Prod2Std}.
 */
@RestController
@RequestMapping("/api")
public class Prod2StdResource {

    private final Logger log = LoggerFactory.getLogger(Prod2StdResource.class);

    private static final String ENTITY_NAME = "prod2Std";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Prod2StdService prod2StdService;

    private final Prod2StdRepository prod2StdRepository;

    private final Prod2StdQueryService prod2StdQueryService;

    public Prod2StdResource(
        Prod2StdService prod2StdService,
        Prod2StdRepository prod2StdRepository,
        Prod2StdQueryService prod2StdQueryService
    ) {
        this.prod2StdService = prod2StdService;
        this.prod2StdRepository = prod2StdRepository;
        this.prod2StdQueryService = prod2StdQueryService;
    }

    /**
     * {@code POST  /prod-2-stds} : Create a new prod2Std.
     *
     * @param prod2StdDTO the prod2StdDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prod2StdDTO, or with status {@code 400 (Bad Request)} if the prod2Std has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prod-2-stds")
    public ResponseEntity<Prod2StdDTO> createProd2Std(@RequestBody Prod2StdDTO prod2StdDTO) throws URISyntaxException {
        log.debug("REST request to save Prod2Std : {}", prod2StdDTO);
        if (prod2StdDTO.getId() != null) {
            throw new BadRequestAlertException("A new prod2Std cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Prod2StdDTO result = prod2StdService.save(prod2StdDTO);
        return ResponseEntity
            .created(new URI("/api/prod-2-stds/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prod-2-stds/:id} : Updates an existing prod2Std.
     *
     * @param id the id of the prod2StdDTO to save.
     * @param prod2StdDTO the prod2StdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod2StdDTO,
     * or with status {@code 400 (Bad Request)} if the prod2StdDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prod2StdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prod-2-stds/{id}")
    public ResponseEntity<Prod2StdDTO> updateProd2Std(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Prod2StdDTO prod2StdDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Prod2Std : {}, {}", id, prod2StdDTO);
        if (prod2StdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod2StdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prod2StdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Prod2StdDTO result = prod2StdService.update(prod2StdDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod2StdDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prod-2-stds/:id} : Partial updates given fields of an existing prod2Std, field will ignore if it is null
     *
     * @param id the id of the prod2StdDTO to save.
     * @param prod2StdDTO the prod2StdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod2StdDTO,
     * or with status {@code 400 (Bad Request)} if the prod2StdDTO is not valid,
     * or with status {@code 404 (Not Found)} if the prod2StdDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the prod2StdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prod-2-stds/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Prod2StdDTO> partialUpdateProd2Std(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Prod2StdDTO prod2StdDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Prod2Std partially : {}, {}", id, prod2StdDTO);
        if (prod2StdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod2StdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prod2StdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Prod2StdDTO> result = prod2StdService.partialUpdate(prod2StdDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod2StdDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /prod-2-stds} : get all the prod2Stds.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prod2Stds in body.
     */
    @GetMapping("/prod-2-stds")
    public ResponseEntity<List<Prod2StdDTO>> getAllProd2Stds(
        Prod2StdCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Prod2Stds by criteria: {}", criteria);
        Page<Prod2StdDTO> page = prod2StdQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /prod-2-stds/count} : count all the prod2Stds.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/prod-2-stds/count")
    public ResponseEntity<Long> countProd2Stds(Prod2StdCriteria criteria) {
        log.debug("REST request to count Prod2Stds by criteria: {}", criteria);
        return ResponseEntity.ok().body(prod2StdQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /prod-2-stds/:id} : get the "id" prod2Std.
     *
     * @param id the id of the prod2StdDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prod2StdDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prod-2-stds/{id}")
    public ResponseEntity<Prod2StdDTO> getProd2Std(@PathVariable Long id) {
        log.debug("REST request to get Prod2Std : {}", id);
        Optional<Prod2StdDTO> prod2StdDTO = prod2StdService.findOne(id);
        return ResponseUtil.wrapOrNotFound(prod2StdDTO);
    }

    /**
     * {@code DELETE  /prod-2-stds/:id} : delete the "id" prod2Std.
     *
     * @param id the id of the prod2StdDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prod-2-stds/{id}")
    public ResponseEntity<Void> deleteProd2Std(@PathVariable Long id) {
        log.debug("REST request to delete Prod2Std : {}", id);
        prod2StdService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
