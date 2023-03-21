package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfViewRepository;
import com.wcc.gma2.service.CerfViewQueryService;
import com.wcc.gma2.service.CerfViewService;
import com.wcc.gma2.service.criteria.CerfViewCriteria;
import com.wcc.gma2.service.dto.CerfViewDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.CerfView}.
 */
@RestController
@RequestMapping("/api")
public class CerfViewResource {

    private final Logger log = LoggerFactory.getLogger(CerfViewResource.class);

    private final CerfViewService cerfViewService;

    private final CerfViewRepository cerfViewRepository;

    private final CerfViewQueryService cerfViewQueryService;

    public CerfViewResource(
        CerfViewService cerfViewService,
        CerfViewRepository cerfViewRepository,
        CerfViewQueryService cerfViewQueryService
    ) {
        this.cerfViewService = cerfViewService;
        this.cerfViewRepository = cerfViewRepository;
        this.cerfViewQueryService = cerfViewQueryService;
    }

    /**
     * {@code GET  /cerf-views} : get all the cerfViews.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfViews in body.
     */
    @GetMapping("/cerf-views")
    public ResponseEntity<List<CerfViewDTO>> getAllCerfViews(
        CerfViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get CerfViews by criteria: {}", criteria);
        Page<CerfViewDTO> page = cerfViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-views/count} : count all the cerfViews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-views/count")
    public ResponseEntity<Long> countCerfViews(CerfViewCriteria criteria) {
        log.debug("REST request to count CerfViews by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfViewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-views/:id} : get the "id" cerfView.
     *
     * @param id the id of the cerfViewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-views/{id}")
    public ResponseEntity<CerfViewDTO> getCerfView(@PathVariable Long id) {
        log.debug("REST request to get CerfView : {}", id);
        Optional<CerfViewDTO> cerfViewDTO = cerfViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfViewDTO);
    }
}
