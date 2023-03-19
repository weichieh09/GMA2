package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.CerfSearchViewRepository;
import com.wcc.gma2.service.CerfSearchViewQueryService;
import com.wcc.gma2.service.CerfSearchViewService;
import com.wcc.gma2.service.criteria.CerfSearchViewCriteria;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.CerfSearchView}.
 */
@RestController
@RequestMapping("/api")
public class CerfSearchViewResource {

    private final Logger log = LoggerFactory.getLogger(CerfSearchViewResource.class);

    private final CerfSearchViewService cerfSearchViewService;

    private final CerfSearchViewRepository cerfSearchViewRepository;

    private final CerfSearchViewQueryService cerfSearchViewQueryService;

    public CerfSearchViewResource(
        CerfSearchViewService cerfSearchViewService,
        CerfSearchViewRepository cerfSearchViewRepository,
        CerfSearchViewQueryService cerfSearchViewQueryService
    ) {
        this.cerfSearchViewService = cerfSearchViewService;
        this.cerfSearchViewRepository = cerfSearchViewRepository;
        this.cerfSearchViewQueryService = cerfSearchViewQueryService;
    }

    /**
     * {@code GET  /cerf-search-views} : get all the cerfSearchViews.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfSearchViews in body.
     */
    @GetMapping("/cerf-search-views")
    public ResponseEntity<List<CerfSearchViewDTO>> getAllCerfSearchViews(
        CerfSearchViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get CerfSearchViews by criteria: {}", criteria);
        Page<CerfSearchViewDTO> page = cerfSearchViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-search-views/count} : count all the cerfSearchViews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-search-views/count")
    public ResponseEntity<Long> countCerfSearchViews(CerfSearchViewCriteria criteria) {
        log.debug("REST request to count CerfSearchViews by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerfSearchViewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-search-views/:id} : get the "id" cerfSearchView.
     *
     * @param id the id of the cerfSearchViewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerfSearchViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-search-views/{id}")
    public ResponseEntity<CerfSearchViewDTO> getCerfSearchView(@PathVariable Long id) {
        log.debug("REST request to get CerfSearchView : {}", id);
        Optional<CerfSearchViewDTO> cerfSearchViewDTO = cerfSearchViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerfSearchViewDTO);
    }
}
