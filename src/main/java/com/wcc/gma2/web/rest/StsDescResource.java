package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.StsDescRepository;
import com.wcc.gma2.service.StsDescQueryService;
import com.wcc.gma2.service.StsDescService;
import com.wcc.gma2.service.criteria.StsDescCriteria;
import com.wcc.gma2.service.dto.StsDescDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.StsDesc}.
 */
@RestController
@RequestMapping("/api")
public class StsDescResource {

    private final Logger log = LoggerFactory.getLogger(StsDescResource.class);

    private static final String ENTITY_NAME = "stsDesc";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StsDescService stsDescService;

    private final StsDescRepository stsDescRepository;

    private final StsDescQueryService stsDescQueryService;

    public StsDescResource(StsDescService stsDescService, StsDescRepository stsDescRepository, StsDescQueryService stsDescQueryService) {
        this.stsDescService = stsDescService;
        this.stsDescRepository = stsDescRepository;
        this.stsDescQueryService = stsDescQueryService;
    }

    /**
     * {@code POST  /sts-descs} : Create a new stsDesc.
     *
     * @param stsDescDTO the stsDescDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stsDescDTO, or with status {@code 400 (Bad Request)} if the stsDesc has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sts-descs")
    public ResponseEntity<StsDescDTO> createStsDesc(@RequestBody StsDescDTO stsDescDTO) throws URISyntaxException {
        log.debug("REST request to save StsDesc : {}", stsDescDTO);
        if (stsDescDTO.getId() != null) {
            throw new BadRequestAlertException("A new stsDesc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StsDescDTO result = stsDescService.save(stsDescDTO);
        return ResponseEntity
            .created(new URI("/api/sts-descs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sts-descs/:id} : Updates an existing stsDesc.
     *
     * @param id the id of the stsDescDTO to save.
     * @param stsDescDTO the stsDescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stsDescDTO,
     * or with status {@code 400 (Bad Request)} if the stsDescDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stsDescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sts-descs/{id}")
    public ResponseEntity<StsDescDTO> updateStsDesc(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StsDescDTO stsDescDTO
    ) throws URISyntaxException {
        log.debug("REST request to update StsDesc : {}, {}", id, stsDescDTO);
        if (stsDescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stsDescDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stsDescRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        StsDescDTO result = stsDescService.update(stsDescDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stsDescDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /sts-descs/:id} : Partial updates given fields of an existing stsDesc, field will ignore if it is null
     *
     * @param id the id of the stsDescDTO to save.
     * @param stsDescDTO the stsDescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stsDescDTO,
     * or with status {@code 400 (Bad Request)} if the stsDescDTO is not valid,
     * or with status {@code 404 (Not Found)} if the stsDescDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the stsDescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/sts-descs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<StsDescDTO> partialUpdateStsDesc(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StsDescDTO stsDescDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update StsDesc partially : {}, {}", id, stsDescDTO);
        if (stsDescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stsDescDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stsDescRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<StsDescDTO> result = stsDescService.partialUpdate(stsDescDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stsDescDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /sts-descs} : get all the stsDescs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stsDescs in body.
     */
    @GetMapping("/sts-descs")
    public ResponseEntity<List<StsDescDTO>> getAllStsDescs(
        StsDescCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get StsDescs by criteria: {}", criteria);
        Page<StsDescDTO> page = stsDescQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sts-descs/count} : count all the stsDescs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/sts-descs/count")
    public ResponseEntity<Long> countStsDescs(StsDescCriteria criteria) {
        log.debug("REST request to count StsDescs by criteria: {}", criteria);
        return ResponseEntity.ok().body(stsDescQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /sts-descs/:id} : get the "id" stsDesc.
     *
     * @param id the id of the stsDescDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stsDescDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sts-descs/{id}")
    public ResponseEntity<StsDescDTO> getStsDesc(@PathVariable Long id) {
        log.debug("REST request to get StsDesc : {}", id);
        Optional<StsDescDTO> stsDescDTO = stsDescService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stsDescDTO);
    }

    /**
     * {@code DELETE  /sts-descs/:id} : delete the "id" stsDesc.
     *
     * @param id the id of the stsDescDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sts-descs/{id}")
    public ResponseEntity<Void> deleteStsDesc(@PathVariable Long id) {
        log.debug("REST request to delete StsDesc : {}", id);
        stsDescService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
