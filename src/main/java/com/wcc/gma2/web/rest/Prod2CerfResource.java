package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Prod2CerfRepository;
import com.wcc.gma2.service.Prod2CerfQueryService;
import com.wcc.gma2.service.Prod2CerfService;
import com.wcc.gma2.service.criteria.Prod2CerfCriteria;
import com.wcc.gma2.service.dto.Prod2CerfDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Prod2Cerf}.
 */
@RestController
@RequestMapping("/api")
public class Prod2CerfResource {

    private final Logger log = LoggerFactory.getLogger(Prod2CerfResource.class);

    private static final String ENTITY_NAME = "prod2Cerf";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Prod2CerfService prod2CerfService;

    private final Prod2CerfRepository prod2CerfRepository;

    private final Prod2CerfQueryService prod2CerfQueryService;

    public Prod2CerfResource(
        Prod2CerfService prod2CerfService,
        Prod2CerfRepository prod2CerfRepository,
        Prod2CerfQueryService prod2CerfQueryService
    ) {
        this.prod2CerfService = prod2CerfService;
        this.prod2CerfRepository = prod2CerfRepository;
        this.prod2CerfQueryService = prod2CerfQueryService;
    }

    /**
     * {@code POST  /prod-2-cerfs} : Create a new prod2Cerf.
     *
     * @param prod2CerfDTO the prod2CerfDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prod2CerfDTO, or with status {@code 400 (Bad Request)} if the prod2Cerf has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prod-2-cerfs")
    public ResponseEntity<Prod2CerfDTO> createProd2Cerf(@RequestBody Prod2CerfDTO prod2CerfDTO) throws URISyntaxException {
        log.debug("REST request to save Prod2Cerf : {}", prod2CerfDTO);
        if (prod2CerfDTO.getId() != null) {
            throw new BadRequestAlertException("A new prod2Cerf cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Prod2CerfDTO result = prod2CerfService.save(prod2CerfDTO);
        return ResponseEntity
            .created(new URI("/api/prod-2-cerfs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prod-2-cerfs/:id} : Updates an existing prod2Cerf.
     *
     * @param id the id of the prod2CerfDTO to save.
     * @param prod2CerfDTO the prod2CerfDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod2CerfDTO,
     * or with status {@code 400 (Bad Request)} if the prod2CerfDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prod2CerfDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prod-2-cerfs/{id}")
    public ResponseEntity<Prod2CerfDTO> updateProd2Cerf(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Prod2CerfDTO prod2CerfDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Prod2Cerf : {}, {}", id, prod2CerfDTO);
        if (prod2CerfDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod2CerfDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prod2CerfRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Prod2CerfDTO result = prod2CerfService.update(prod2CerfDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod2CerfDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prod-2-cerfs/:id} : Partial updates given fields of an existing prod2Cerf, field will ignore if it is null
     *
     * @param id the id of the prod2CerfDTO to save.
     * @param prod2CerfDTO the prod2CerfDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod2CerfDTO,
     * or with status {@code 400 (Bad Request)} if the prod2CerfDTO is not valid,
     * or with status {@code 404 (Not Found)} if the prod2CerfDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the prod2CerfDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prod-2-cerfs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Prod2CerfDTO> partialUpdateProd2Cerf(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Prod2CerfDTO prod2CerfDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Prod2Cerf partially : {}, {}", id, prod2CerfDTO);
        if (prod2CerfDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod2CerfDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prod2CerfRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Prod2CerfDTO> result = prod2CerfService.partialUpdate(prod2CerfDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod2CerfDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /prod-2-cerfs} : get all the prod2Cerfs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prod2Cerfs in body.
     */
    @GetMapping("/prod-2-cerfs")
    public ResponseEntity<List<Prod2CerfDTO>> getAllProd2Cerfs(
        Prod2CerfCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Prod2Cerfs by criteria: {}", criteria);
        Page<Prod2CerfDTO> page = prod2CerfQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /prod-2-cerfs/count} : count all the prod2Cerfs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/prod-2-cerfs/count")
    public ResponseEntity<Long> countProd2Cerfs(Prod2CerfCriteria criteria) {
        log.debug("REST request to count Prod2Cerfs by criteria: {}", criteria);
        return ResponseEntity.ok().body(prod2CerfQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /prod-2-cerfs/:id} : get the "id" prod2Cerf.
     *
     * @param id the id of the prod2CerfDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prod2CerfDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prod-2-cerfs/{id}")
    public ResponseEntity<Prod2CerfDTO> getProd2Cerf(@PathVariable Long id) {
        log.debug("REST request to get Prod2Cerf : {}", id);
        Optional<Prod2CerfDTO> prod2CerfDTO = prod2CerfService.findOne(id);
        return ResponseUtil.wrapOrNotFound(prod2CerfDTO);
    }

    /**
     * {@code DELETE  /prod-2-cerfs/:id} : delete the "id" prod2Cerf.
     *
     * @param id the id of the prod2CerfDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prod-2-cerfs/{id}")
    public ResponseEntity<Void> deleteProd2Cerf(@PathVariable Long id) {
        log.debug("REST request to delete Prod2Cerf : {}", id);
        prod2CerfService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
