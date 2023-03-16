package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.MnfctrRepository;
import com.wcc.gma2.service.MnfctrQueryService;
import com.wcc.gma2.service.MnfctrService;
import com.wcc.gma2.service.criteria.MnfctrCriteria;
import com.wcc.gma2.service.dto.MnfctrDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Mnfctr}.
 */
@RestController
@RequestMapping("/api")
public class MnfctrResource {

    private final Logger log = LoggerFactory.getLogger(MnfctrResource.class);

    private static final String ENTITY_NAME = "mnfctr";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MnfctrService mnfctrService;

    private final MnfctrRepository mnfctrRepository;

    private final MnfctrQueryService mnfctrQueryService;

    public MnfctrResource(MnfctrService mnfctrService, MnfctrRepository mnfctrRepository, MnfctrQueryService mnfctrQueryService) {
        this.mnfctrService = mnfctrService;
        this.mnfctrRepository = mnfctrRepository;
        this.mnfctrQueryService = mnfctrQueryService;
    }

    /**
     * {@code POST  /mnfctrs} : Create a new mnfctr.
     *
     * @param mnfctrDTO the mnfctrDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mnfctrDTO, or with status {@code 400 (Bad Request)} if the mnfctr has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mnfctrs")
    public ResponseEntity<MnfctrDTO> createMnfctr(@RequestBody MnfctrDTO mnfctrDTO) throws URISyntaxException {
        log.debug("REST request to save Mnfctr : {}", mnfctrDTO);
        if (mnfctrDTO.getId() != null) {
            throw new BadRequestAlertException("A new mnfctr cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MnfctrDTO result = mnfctrService.save(mnfctrDTO);
        return ResponseEntity
            .created(new URI("/api/mnfctrs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mnfctrs/:id} : Updates an existing mnfctr.
     *
     * @param id the id of the mnfctrDTO to save.
     * @param mnfctrDTO the mnfctrDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mnfctrDTO,
     * or with status {@code 400 (Bad Request)} if the mnfctrDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mnfctrDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mnfctrs/{id}")
    public ResponseEntity<MnfctrDTO> updateMnfctr(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MnfctrDTO mnfctrDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Mnfctr : {}, {}", id, mnfctrDTO);
        if (mnfctrDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, mnfctrDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!mnfctrRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        MnfctrDTO result = mnfctrService.update(mnfctrDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mnfctrDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /mnfctrs/:id} : Partial updates given fields of an existing mnfctr, field will ignore if it is null
     *
     * @param id the id of the mnfctrDTO to save.
     * @param mnfctrDTO the mnfctrDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mnfctrDTO,
     * or with status {@code 400 (Bad Request)} if the mnfctrDTO is not valid,
     * or with status {@code 404 (Not Found)} if the mnfctrDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the mnfctrDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/mnfctrs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MnfctrDTO> partialUpdateMnfctr(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MnfctrDTO mnfctrDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Mnfctr partially : {}, {}", id, mnfctrDTO);
        if (mnfctrDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, mnfctrDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!mnfctrRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<MnfctrDTO> result = mnfctrService.partialUpdate(mnfctrDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mnfctrDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /mnfctrs} : get all the mnfctrs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mnfctrs in body.
     */
    @GetMapping("/mnfctrs")
    public ResponseEntity<List<MnfctrDTO>> getAllMnfctrs(
        MnfctrCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Mnfctrs by criteria: {}", criteria);
        Page<MnfctrDTO> page = mnfctrQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /mnfctrs/count} : count all the mnfctrs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/mnfctrs/count")
    public ResponseEntity<Long> countMnfctrs(MnfctrCriteria criteria) {
        log.debug("REST request to count Mnfctrs by criteria: {}", criteria);
        return ResponseEntity.ok().body(mnfctrQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /mnfctrs/:id} : get the "id" mnfctr.
     *
     * @param id the id of the mnfctrDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mnfctrDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mnfctrs/{id}")
    public ResponseEntity<MnfctrDTO> getMnfctr(@PathVariable Long id) {
        log.debug("REST request to get Mnfctr : {}", id);
        Optional<MnfctrDTO> mnfctrDTO = mnfctrService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mnfctrDTO);
    }

    /**
     * {@code DELETE  /mnfctrs/:id} : delete the "id" mnfctr.
     *
     * @param id the id of the mnfctrDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mnfctrs/{id}")
    public ResponseEntity<Void> deleteMnfctr(@PathVariable Long id) {
        log.debug("REST request to delete Mnfctr : {}", id);
        mnfctrService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
