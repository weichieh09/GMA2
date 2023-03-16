package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.AreaDescRepository;
import com.wcc.gma2.service.AreaDescQueryService;
import com.wcc.gma2.service.AreaDescService;
import com.wcc.gma2.service.criteria.AreaDescCriteria;
import com.wcc.gma2.service.dto.AreaDescDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.AreaDesc}.
 */
@RestController
@RequestMapping("/api")
public class AreaDescResource {

    private final Logger log = LoggerFactory.getLogger(AreaDescResource.class);

    private static final String ENTITY_NAME = "areaDesc";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AreaDescService areaDescService;

    private final AreaDescRepository areaDescRepository;

    private final AreaDescQueryService areaDescQueryService;

    public AreaDescResource(
        AreaDescService areaDescService,
        AreaDescRepository areaDescRepository,
        AreaDescQueryService areaDescQueryService
    ) {
        this.areaDescService = areaDescService;
        this.areaDescRepository = areaDescRepository;
        this.areaDescQueryService = areaDescQueryService;
    }

    /**
     * {@code POST  /area-descs} : Create a new areaDesc.
     *
     * @param areaDescDTO the areaDescDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new areaDescDTO, or with status {@code 400 (Bad Request)} if the areaDesc has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/area-descs")
    public ResponseEntity<AreaDescDTO> createAreaDesc(@RequestBody AreaDescDTO areaDescDTO) throws URISyntaxException {
        log.debug("REST request to save AreaDesc : {}", areaDescDTO);
        if (areaDescDTO.getId() != null) {
            throw new BadRequestAlertException("A new areaDesc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AreaDescDTO result = areaDescService.save(areaDescDTO);
        return ResponseEntity
            .created(new URI("/api/area-descs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /area-descs/:id} : Updates an existing areaDesc.
     *
     * @param id the id of the areaDescDTO to save.
     * @param areaDescDTO the areaDescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated areaDescDTO,
     * or with status {@code 400 (Bad Request)} if the areaDescDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the areaDescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/area-descs/{id}")
    public ResponseEntity<AreaDescDTO> updateAreaDesc(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AreaDescDTO areaDescDTO
    ) throws URISyntaxException {
        log.debug("REST request to update AreaDesc : {}, {}", id, areaDescDTO);
        if (areaDescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, areaDescDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!areaDescRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AreaDescDTO result = areaDescService.update(areaDescDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, areaDescDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /area-descs/:id} : Partial updates given fields of an existing areaDesc, field will ignore if it is null
     *
     * @param id the id of the areaDescDTO to save.
     * @param areaDescDTO the areaDescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated areaDescDTO,
     * or with status {@code 400 (Bad Request)} if the areaDescDTO is not valid,
     * or with status {@code 404 (Not Found)} if the areaDescDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the areaDescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/area-descs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<AreaDescDTO> partialUpdateAreaDesc(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AreaDescDTO areaDescDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update AreaDesc partially : {}, {}", id, areaDescDTO);
        if (areaDescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, areaDescDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!areaDescRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AreaDescDTO> result = areaDescService.partialUpdate(areaDescDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, areaDescDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /area-descs} : get all the areaDescs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of areaDescs in body.
     */
    @GetMapping("/area-descs")
    public ResponseEntity<List<AreaDescDTO>> getAllAreaDescs(
        AreaDescCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get AreaDescs by criteria: {}", criteria);
        Page<AreaDescDTO> page = areaDescQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /area-descs/count} : count all the areaDescs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/area-descs/count")
    public ResponseEntity<Long> countAreaDescs(AreaDescCriteria criteria) {
        log.debug("REST request to count AreaDescs by criteria: {}", criteria);
        return ResponseEntity.ok().body(areaDescQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /area-descs/:id} : get the "id" areaDesc.
     *
     * @param id the id of the areaDescDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the areaDescDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/area-descs/{id}")
    public ResponseEntity<AreaDescDTO> getAreaDesc(@PathVariable Long id) {
        log.debug("REST request to get AreaDesc : {}", id);
        Optional<AreaDescDTO> areaDescDTO = areaDescService.findOne(id);
        return ResponseUtil.wrapOrNotFound(areaDescDTO);
    }

    /**
     * {@code DELETE  /area-descs/:id} : delete the "id" areaDesc.
     *
     * @param id the id of the areaDescDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/area-descs/{id}")
    public ResponseEntity<Void> deleteAreaDesc(@PathVariable Long id) {
        log.debug("REST request to delete AreaDesc : {}", id);
        areaDescService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
