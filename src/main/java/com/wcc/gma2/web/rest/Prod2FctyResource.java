package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Prod2FctyRepository;
import com.wcc.gma2.service.Prod2FctyQueryService;
import com.wcc.gma2.service.Prod2FctyService;
import com.wcc.gma2.service.criteria.Prod2FctyCriteria;
import com.wcc.gma2.service.dto.Prod2FctyDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Prod2Fcty}.
 */
@RestController
@RequestMapping("/api")
public class Prod2FctyResource {

    private final Logger log = LoggerFactory.getLogger(Prod2FctyResource.class);

    private static final String ENTITY_NAME = "prod2Fcty";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Prod2FctyService prod2FctyService;

    private final Prod2FctyRepository prod2FctyRepository;

    private final Prod2FctyQueryService prod2FctyQueryService;

    public Prod2FctyResource(
        Prod2FctyService prod2FctyService,
        Prod2FctyRepository prod2FctyRepository,
        Prod2FctyQueryService prod2FctyQueryService
    ) {
        this.prod2FctyService = prod2FctyService;
        this.prod2FctyRepository = prod2FctyRepository;
        this.prod2FctyQueryService = prod2FctyQueryService;
    }

    /**
     * {@code POST  /prod-2-fcties} : Create a new prod2Fcty.
     *
     * @param prod2FctyDTO the prod2FctyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prod2FctyDTO, or with status {@code 400 (Bad Request)} if the prod2Fcty has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prod-2-fcties")
    public ResponseEntity<Prod2FctyDTO> createProd2Fcty(@RequestBody Prod2FctyDTO prod2FctyDTO) throws URISyntaxException {
        log.debug("REST request to save Prod2Fcty : {}", prod2FctyDTO);
        if (prod2FctyDTO.getId() != null) {
            throw new BadRequestAlertException("A new prod2Fcty cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Prod2FctyDTO result = prod2FctyService.save(prod2FctyDTO);
        return ResponseEntity
            .created(new URI("/api/prod-2-fcties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prod-2-fcties/:id} : Updates an existing prod2Fcty.
     *
     * @param id the id of the prod2FctyDTO to save.
     * @param prod2FctyDTO the prod2FctyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod2FctyDTO,
     * or with status {@code 400 (Bad Request)} if the prod2FctyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prod2FctyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prod-2-fcties/{id}")
    public ResponseEntity<Prod2FctyDTO> updateProd2Fcty(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Prod2FctyDTO prod2FctyDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Prod2Fcty : {}, {}", id, prod2FctyDTO);
        if (prod2FctyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod2FctyDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prod2FctyRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Prod2FctyDTO result = prod2FctyService.update(prod2FctyDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod2FctyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prod-2-fcties/:id} : Partial updates given fields of an existing prod2Fcty, field will ignore if it is null
     *
     * @param id the id of the prod2FctyDTO to save.
     * @param prod2FctyDTO the prod2FctyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod2FctyDTO,
     * or with status {@code 400 (Bad Request)} if the prod2FctyDTO is not valid,
     * or with status {@code 404 (Not Found)} if the prod2FctyDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the prod2FctyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prod-2-fcties/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Prod2FctyDTO> partialUpdateProd2Fcty(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Prod2FctyDTO prod2FctyDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Prod2Fcty partially : {}, {}", id, prod2FctyDTO);
        if (prod2FctyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod2FctyDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prod2FctyRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Prod2FctyDTO> result = prod2FctyService.partialUpdate(prod2FctyDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod2FctyDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /prod-2-fcties} : get all the prod2Fcties.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prod2Fcties in body.
     */
    @GetMapping("/prod-2-fcties")
    public ResponseEntity<List<Prod2FctyDTO>> getAllProd2Fcties(
        Prod2FctyCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Prod2Fcties by criteria: {}", criteria);
        Page<Prod2FctyDTO> page = prod2FctyQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /prod-2-fcties/count} : count all the prod2Fcties.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/prod-2-fcties/count")
    public ResponseEntity<Long> countProd2Fcties(Prod2FctyCriteria criteria) {
        log.debug("REST request to count Prod2Fcties by criteria: {}", criteria);
        return ResponseEntity.ok().body(prod2FctyQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /prod-2-fcties/:id} : get the "id" prod2Fcty.
     *
     * @param id the id of the prod2FctyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prod2FctyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prod-2-fcties/{id}")
    public ResponseEntity<Prod2FctyDTO> getProd2Fcty(@PathVariable Long id) {
        log.debug("REST request to get Prod2Fcty : {}", id);
        Optional<Prod2FctyDTO> prod2FctyDTO = prod2FctyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(prod2FctyDTO);
    }

    /**
     * {@code DELETE  /prod-2-fcties/:id} : delete the "id" prod2Fcty.
     *
     * @param id the id of the prod2FctyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prod-2-fcties/{id}")
    public ResponseEntity<Void> deleteProd2Fcty(@PathVariable Long id) {
        log.debug("REST request to delete Prod2Fcty : {}", id);
        prod2FctyService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
