package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Cref2StdRepository;
import com.wcc.gma2.service.Cref2StdQueryService;
import com.wcc.gma2.service.Cref2StdService;
import com.wcc.gma2.service.criteria.Cref2StdCriteria;
import com.wcc.gma2.service.dto.Cref2StdDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Cref2Std}.
 */
@RestController
@RequestMapping("/api")
public class Cref2StdResource {

    private final Logger log = LoggerFactory.getLogger(Cref2StdResource.class);

    private static final String ENTITY_NAME = "cref2Std";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Cref2StdService cref2StdService;

    private final Cref2StdRepository cref2StdRepository;

    private final Cref2StdQueryService cref2StdQueryService;

    public Cref2StdResource(
        Cref2StdService cref2StdService,
        Cref2StdRepository cref2StdRepository,
        Cref2StdQueryService cref2StdQueryService
    ) {
        this.cref2StdService = cref2StdService;
        this.cref2StdRepository = cref2StdRepository;
        this.cref2StdQueryService = cref2StdQueryService;
    }

    /**
     * {@code POST  /cref-2-stds} : Create a new cref2Std.
     *
     * @param cref2StdDTO the cref2StdDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cref2StdDTO, or with status {@code 400 (Bad Request)} if the cref2Std has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cref-2-stds")
    public ResponseEntity<Cref2StdDTO> createCref2Std(@RequestBody Cref2StdDTO cref2StdDTO) throws URISyntaxException {
        log.debug("REST request to save Cref2Std : {}", cref2StdDTO);
        if (cref2StdDTO.getId() != null) {
            throw new BadRequestAlertException("A new cref2Std cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cref2StdDTO result = cref2StdService.save(cref2StdDTO);
        return ResponseEntity
            .created(new URI("/api/cref-2-stds/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cref-2-stds/:id} : Updates an existing cref2Std.
     *
     * @param id the id of the cref2StdDTO to save.
     * @param cref2StdDTO the cref2StdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cref2StdDTO,
     * or with status {@code 400 (Bad Request)} if the cref2StdDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cref2StdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cref-2-stds/{id}")
    public ResponseEntity<Cref2StdDTO> updateCref2Std(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Cref2StdDTO cref2StdDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Cref2Std : {}, {}", id, cref2StdDTO);
        if (cref2StdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cref2StdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cref2StdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Cref2StdDTO result = cref2StdService.update(cref2StdDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cref2StdDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cref-2-stds/:id} : Partial updates given fields of an existing cref2Std, field will ignore if it is null
     *
     * @param id the id of the cref2StdDTO to save.
     * @param cref2StdDTO the cref2StdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cref2StdDTO,
     * or with status {@code 400 (Bad Request)} if the cref2StdDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cref2StdDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cref2StdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cref-2-stds/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Cref2StdDTO> partialUpdateCref2Std(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Cref2StdDTO cref2StdDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Cref2Std partially : {}, {}", id, cref2StdDTO);
        if (cref2StdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cref2StdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cref2StdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Cref2StdDTO> result = cref2StdService.partialUpdate(cref2StdDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cref2StdDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cref-2-stds} : get all the cref2Stds.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cref2Stds in body.
     */
    @GetMapping("/cref-2-stds")
    public ResponseEntity<List<Cref2StdDTO>> getAllCref2Stds(
        Cref2StdCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Cref2Stds by criteria: {}", criteria);
        Page<Cref2StdDTO> page = cref2StdQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cref-2-stds/count} : count all the cref2Stds.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cref-2-stds/count")
    public ResponseEntity<Long> countCref2Stds(Cref2StdCriteria criteria) {
        log.debug("REST request to count Cref2Stds by criteria: {}", criteria);
        return ResponseEntity.ok().body(cref2StdQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cref-2-stds/:id} : get the "id" cref2Std.
     *
     * @param id the id of the cref2StdDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cref2StdDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cref-2-stds/{id}")
    public ResponseEntity<Cref2StdDTO> getCref2Std(@PathVariable Long id) {
        log.debug("REST request to get Cref2Std : {}", id);
        Optional<Cref2StdDTO> cref2StdDTO = cref2StdService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cref2StdDTO);
    }

    /**
     * {@code DELETE  /cref-2-stds/:id} : delete the "id" cref2Std.
     *
     * @param id the id of the cref2StdDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cref-2-stds/{id}")
    public ResponseEntity<Void> deleteCref2Std(@PathVariable Long id) {
        log.debug("REST request to delete Cref2Std : {}", id);
        cref2StdService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
