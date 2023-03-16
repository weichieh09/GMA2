package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfImgRepository;
import com.wcc.gma2.service.CerfImgQueryService;
import com.wcc.gma2.service.CerfImgService;
import com.wcc.gma2.service.criteria.CerfImgCriteria;
import com.wcc.gma2.service.dto.CerfImgDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.CerfImg}.
 */
@RestController
@RequestMapping("/api")
public class CerfImgResource {

    private final Logger log = LoggerFactory.getLogger(CerfImgResource.class);

    private static final String ENTITY_NAME = "cerfImg";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CerfImgService cerfImgService;

    private final CerfImgRepository cerfImgRepository;

    private final CerfImgQueryService cerfImgQueryService;

    public CerfImgResource(CerfImgService cerfImgService, CerfImgRepository cerfImgRepository, CerfImgQueryService cerfImgQueryService) {
        this.cerfImgService = cerfImgService;
        this.cerfImgRepository = cerfImgRepository;
        this.cerfImgQueryService = cerfImgQueryService;
    }

    /**
     * {@code POST  /cerf-imgs} : Create a new cerfImg.
     *
     * @param cerfImgDTO the cerfImgDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cerfImgDTO, or with status {@code 400 (Bad Request)} if the cerfImg has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cerf-imgs")
    public ResponseEntity<CerfImgDTO> createCerfImg(@RequestBody CerfImgDTO cerfImgDTO) throws URISyntaxException {
        log.debug("REST request to save CerfImg : {}", cerfImgDTO);
        if (cerfImgDTO.getId() != null) {
            throw new BadRequestAlertException("A new cerfImg cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CerfImgDTO result = cerfImgService.save(cerfImgDTO);
        return ResponseEntity
            .created(new URI("/api/cerf-imgs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cerf-imgs/:id} : Updates an existing cerfImg.
     *
     * @param id the id of the cerfImgDTO to save.
     * @param cerfImgDTO the cerfImgDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfImgDTO,
     * or with status {@code 400 (Bad Request)} if the cerfImgDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cerfImgDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cerf-imgs/{id}")
    public ResponseEntity<CerfImgDTO> updateCerfImg(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CerfImgDTO cerfImgDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CerfImg : {}, {}", id, cerfImgDTO);
        if (cerfImgDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfImgDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfImgRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CerfImgDTO result = cerfImgService.update(cerfImgDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfImgDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cerf-imgs/:id} : Partial updates given fields of an existing cerfImg, field will ignore if it is null
     *
     * @param id the id of the cerfImgDTO to save.
     * @param cerfImgDTO the cerfImgDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerfImgDTO,
     * or with status {@code 400 (Bad Request)} if the cerfImgDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cerfImgDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cerfImgDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cerf-imgs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CerfImgDTO> partialUpdateCerfImg(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CerfImgDTO cerfImgDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update CerfImg partially : {}, {}", id, cerfImgDTO);
        if (cerfImgDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerfImgDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfImgRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CerfImgDTO> result = cerfImgService.partialUpdate(cerfImgDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerfImgDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cerf-imgs} : get all the cerfImgs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfImgs in body.
     */
    @GetMapping("/cerf-imgs")
    public ResponseEntity<List<CerfImgDTO>> getAllCerfImgs(
        CerfImgCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get CerfImgs by criteria: {}", criteria);
        Page<CerfImgDTO> page = cerfImgQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-imgs/count} : count all the cerfImgs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-imgs/count")
    public ResponseEntity<Long> countCerfImgs(CerfImgCriteria criteria) {
        log.debug("REST request to count CerfImgs by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfImgQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-imgs/:id} : get the "id" cerfImg.
     *
     * @param id the id of the cerfImgDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfImgDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-imgs/{id}")
    public ResponseEntity<CerfImgDTO> getCerfImg(@PathVariable Long id) {
        log.debug("REST request to get CerfImg : {}", id);
        Optional<CerfImgDTO> cerfImgDTO = cerfImgService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfImgDTO);
    }

    /**
     * {@code DELETE  /cerf-imgs/:id} : delete the "id" cerfImg.
     *
     * @param id the id of the cerfImgDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cerf-imgs/{id}")
    public ResponseEntity<Void> deleteCerfImg(@PathVariable Long id) {
        log.debug("REST request to delete CerfImg : {}", id);
        cerfImgService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
