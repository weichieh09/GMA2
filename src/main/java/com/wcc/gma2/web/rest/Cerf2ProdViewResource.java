package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Cerf2ProdViewRepository;
import com.wcc.gma2.service.Cerf2ProdViewQueryService;
import com.wcc.gma2.service.Cerf2ProdViewService;
import com.wcc.gma2.service.criteria.Cerf2ProdViewCriteria;
import com.wcc.gma2.service.dto.Cerf2ProdViewDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf2ProdView}.
 */
@RestController
@RequestMapping("/api")
public class Cerf2ProdViewResource {

    private final Logger log = LoggerFactory.getLogger(Cerf2ProdViewResource.class);

    private final Cerf2ProdViewService cerf2ProdViewService;

    private final Cerf2ProdViewRepository cerf2ProdViewRepository;

    private final Cerf2ProdViewQueryService cerf2ProdViewQueryService;

    public Cerf2ProdViewResource(
        Cerf2ProdViewService cerf2ProdViewService,
        Cerf2ProdViewRepository cerf2ProdViewRepository,
        Cerf2ProdViewQueryService cerf2ProdViewQueryService
    ) {
        this.cerf2ProdViewService = cerf2ProdViewService;
        this.cerf2ProdViewRepository = cerf2ProdViewRepository;
        this.cerf2ProdViewQueryService = cerf2ProdViewQueryService;
    }

    /**
     * {@code GET  /cerf-2-prod-views} : get all the cerf2ProdViews.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerf2ProdViews in body.
     */
    @GetMapping("/cerf-2-prod-views")
    public ResponseEntity<List<Cerf2ProdViewDTO>> getAllCerf2ProdViews(
        Cerf2ProdViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Cerf2ProdViews by criteria: {}", criteria);
        Page<Cerf2ProdViewDTO> page = cerf2ProdViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-2-prod-views/count} : count all the cerf2ProdViews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-2-prod-views/count")
    public ResponseEntity<Long> countCerf2ProdViews(Cerf2ProdViewCriteria criteria) {
        log.debug("REST request to count Cerf2ProdViews by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerf2ProdViewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-2-prod-views/:id} : get the "id" cerf2ProdView.
     *
     * @param id the id of the cerf2ProdViewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerf2ProdViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-2-prod-views/{id}")
    public ResponseEntity<Cerf2ProdViewDTO> getCerf2ProdView(@PathVariable Long id) {
        log.debug("REST request to get Cerf2ProdView : {}", id);
        Optional<Cerf2ProdViewDTO> cerf2ProdViewDTO = cerf2ProdViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerf2ProdViewDTO);
    }
}
