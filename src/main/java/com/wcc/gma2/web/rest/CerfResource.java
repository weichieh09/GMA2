package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfRepository;
import com.wcc.gma2.service.CerfQueryService;
import com.wcc.gma2.service.CerfService;
import com.wcc.gma2.service.criteria.CerfCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf}.
 */
@RestController
@RequestMapping("/api")
public class CerfResource {

    private final Logger log = LoggerFactory.getLogger(CerfResource.class);

    private static final String ENTITY_NAME = "cerf";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CerfService cerfService;

    private final CerfRepository cerfRepository;

    private final CerfQueryService cerfQueryService;

    public CerfResource(CerfService cerfService, CerfRepository cerfRepository, CerfQueryService cerfQueryService) {
        this.cerfService = cerfService;
        this.cerfRepository = cerfRepository;
        this.cerfQueryService = cerfQueryService;
    }

    /**
     * {@code POST  /cerfs} : Create a new cerf.
     *
     * @param cerfDTO the cerfDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cerfDTO, or with status {@code 400 (Bad Request)} if the cerf has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cerfs")
    public ResponseEntity<CerfDTO> createCerf(@Valid @RequestBody CerfDTO cerfDTO) throws URISyntaxException {
        log.debug("REST request to save Cerf : {}", cerfDTO);
        if (cerfDTO.getId() != null) {
            throw new BadRequestAlertException("A new cerf cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CerfDTO result = cerfService.save(cerfDTO);
        return ResponseEntity
            .created(new URI("/api/cerfs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cerfs/:id} : Updates an existing cerf.
     *
     * @param id the id of the cerfDTO to save.
     * @param cerfDTO the cerfDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfDTO,
     * or with status {@code 400 (Bad Request)} if the cerfDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cerfDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cerfs/{id}")
    public ResponseEntity<CerfDTO> updateCerf(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CerfDTO cerfDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Cerf : {}, {}", id, cerfDTO);
        if (cerfDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CerfDTO result = cerfService.update(cerfDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cerfs/:id} : Partial updates given fields of an existing cerf, field will ignore if it is null
     *
     * @param id the id of the cerfDTO to save.
     * @param cerfDTO the cerfDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfDTO,
     * or with status {@code 400 (Bad Request)} if the cerfDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cerfDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cerfDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cerfs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CerfDTO> partialUpdateCerf(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CerfDTO cerfDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Cerf partially : {}, {}", id, cerfDTO);
        if (cerfDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CerfDTO> result = cerfService.partialUpdate(cerfDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cerfs} : get all the cerfs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfs in body.
     */
    @GetMapping("/cerfs")
    public ResponseEntity<List<CerfDTO>> getAllCerfs(
        CerfCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Cerfs by criteria: {}", criteria);
        Page<CerfDTO> page = cerfQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerfs/count} : count all the cerfs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerfs/count")
    public ResponseEntity<Long> countCerfs(CerfCriteria criteria) {
        log.debug("REST request to count Cerfs by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerfs/:id} : get the "id" cerf.
     *
     * @param id the id of the cerfDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerfs/{id}")
    public ResponseEntity<CerfDTO> getCerf(@PathVariable Long id) {
        log.debug("REST request to get Cerf : {}", id);
        Optional<CerfDTO> cerfDTO = cerfService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfDTO);
    }

    /**
     * {@code DELETE  /cerfs/:id} : delete the "id" cerf.
     *
     * @param id the id of the cerfDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cerfs/{id}")
    public ResponseEntity<Void> deleteCerf(@PathVariable Long id) {
        log.debug("REST request to delete Cerf : {}", id);
        cerfService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
