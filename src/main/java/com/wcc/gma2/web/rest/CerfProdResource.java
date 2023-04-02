package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfProdRepository;
import com.wcc.gma2.service.CerfProdQueryService;
import com.wcc.gma2.service.CerfProdService;
import com.wcc.gma2.service.criteria.CerfProdCriteria;
import com.wcc.gma2.service.dto.CerfProdDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.CerfProd}.
 */
@RestController
@RequestMapping("/api")
public class CerfProdResource {

    private final Logger log = LoggerFactory.getLogger(CerfProdResource.class);

    private static final String ENTITY_NAME = "cerfProd";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CerfProdService cerfProdService;

    private final CerfProdRepository cerfProdRepository;

    private final CerfProdQueryService cerfProdQueryService;

    public CerfProdResource(
        CerfProdService cerfProdService,
        CerfProdRepository cerfProdRepository,
        CerfProdQueryService cerfProdQueryService
    ) {
        this.cerfProdService = cerfProdService;
        this.cerfProdRepository = cerfProdRepository;
        this.cerfProdQueryService = cerfProdQueryService;
    }

    /**
     * {@code POST  /cerf-prods} : Create a new cerfProd.
     *
     * @param cerfProdDTO the cerfProdDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cerfProdDTO, or with status {@code 400 (Bad Request)} if the cerfProd has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cerf-prods")
    public ResponseEntity<CerfProdDTO> createCerfProd(@Valid @RequestBody CerfProdDTO cerfProdDTO) throws URISyntaxException {
        log.debug("REST request to save CerfProd : {}", cerfProdDTO);
        if (cerfProdDTO.getId() != null) {
            throw new BadRequestAlertException("A new cerfProd cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CerfProdDTO result = cerfProdService.save(cerfProdDTO);
        return ResponseEntity
            .created(new URI("/api/cerf-prods/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cerf-prods/:id} : Updates an existing cerfProd.
     *
     * @param id the id of the cerfProdDTO to save.
     * @param cerfProdDTO the cerfProdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfProdDTO,
     * or with status {@code 400 (Bad Request)} if the cerfProdDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cerfProdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cerf-prods/{id}")
    public ResponseEntity<CerfProdDTO> updateCerfProd(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CerfProdDTO cerfProdDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CerfProd : {}, {}", id, cerfProdDTO);
        if (cerfProdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfProdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfProdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CerfProdDTO result = cerfProdService.update(cerfProdDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfProdDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cerf-prods/:id} : Partial updates given fields of an existing cerfProd, field will ignore if it is null
     *
     * @param id the id of the cerfProdDTO to save.
     * @param cerfProdDTO the cerfProdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfProdDTO,
     * or with status {@code 400 (Bad Request)} if the cerfProdDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cerfProdDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cerfProdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cerf-prods/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CerfProdDTO> partialUpdateCerfProd(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CerfProdDTO cerfProdDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CerfProd partially : {}, {}", id, cerfProdDTO);
        if (cerfProdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfProdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfProdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CerfProdDTO> result = cerfProdService.partialUpdate(cerfProdDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfProdDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cerf-prods} : get all the cerfProds.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfProds in body.
     */
    @GetMapping("/cerf-prods")
    public ResponseEntity<List<CerfProdDTO>> getAllCerfProds(
        CerfProdCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get CerfProds by criteria: {}", criteria);
        Page<CerfProdDTO> page = cerfProdQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-prods/count} : count all the cerfProds.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-prods/count")
    public ResponseEntity<Long> countCerfProds(CerfProdCriteria criteria) {
        log.debug("REST request to count CerfProds by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfProdQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-prods/:id} : get the "id" cerfProd.
     *
     * @param id the id of the cerfProdDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfProdDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-prods/{id}")
    public ResponseEntity<CerfProdDTO> getCerfProd(@PathVariable Long id) {
        log.debug("REST request to get CerfProd : {}", id);
        Optional<CerfProdDTO> cerfProdDTO = cerfProdService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfProdDTO);
    }

    /**
     * {@code DELETE  /cerf-prods/:id} : delete the "id" cerfProd.
     *
     * @param id the id of the cerfProdDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cerf-prods/{id}")
    public ResponseEntity<Void> deleteCerfProd(@PathVariable Long id) {
        log.debug("REST request to delete CerfProd : {}", id);
        cerfProdService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
