package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Cerf2MnfctrViewRepository;
import com.wcc.gma2.service.Cerf2MnfctrViewQueryService;
import com.wcc.gma2.service.Cerf2MnfctrViewService;
import com.wcc.gma2.service.criteria.Cerf2MnfctrViewCriteria;
import com.wcc.gma2.service.dto.Cerf2MnfctrViewDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf2MnfctrView}.
 */
@RestController
@RequestMapping("/api")
public class Cerf2MnfctrViewResource {

    private final Logger log = LoggerFactory.getLogger(Cerf2MnfctrViewResource.class);

    private final Cerf2MnfctrViewService cerf2MnfctrViewService;

    private final Cerf2MnfctrViewRepository cerf2MnfctrViewRepository;

    private final Cerf2MnfctrViewQueryService cerf2MnfctrViewQueryService;

    public Cerf2MnfctrViewResource(
        Cerf2MnfctrViewService cerf2MnfctrViewService,
        Cerf2MnfctrViewRepository cerf2MnfctrViewRepository,
        Cerf2MnfctrViewQueryService cerf2MnfctrViewQueryService
    ) {
        this.cerf2MnfctrViewService = cerf2MnfctrViewService;
        this.cerf2MnfctrViewRepository = cerf2MnfctrViewRepository;
        this.cerf2MnfctrViewQueryService = cerf2MnfctrViewQueryService;
    }

    /**
     * {@code GET  /cerf-2-mnfctr-views} : get all the cerf2MnfctrViews.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerf2MnfctrViews in body.
     */
    @GetMapping("/cerf-2-mnfctr-views")
    public ResponseEntity<List<Cerf2MnfctrViewDTO>> getAllCerf2MnfctrViews(
        Cerf2MnfctrViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Cerf2MnfctrViews by criteria: {}", criteria);
        Page<Cerf2MnfctrViewDTO> page = cerf2MnfctrViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-2-mnfctr-views/count} : count all the cerf2MnfctrViews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-2-mnfctr-views/count")
    public ResponseEntity<Long> countCerf2MnfctrViews(Cerf2MnfctrViewCriteria criteria) {
        log.debug("REST request to count Cerf2MnfctrViews by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerf2MnfctrViewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-2-mnfctr-views/:id} : get the "id" cerf2MnfctrView.
     *
     * @param id the id of the cerf2MnfctrViewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerf2MnfctrViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-2-mnfctr-views/{id}")
    public ResponseEntity<Cerf2MnfctrViewDTO> getCerf2MnfctrView(@PathVariable Long id) {
        log.debug("REST request to get Cerf2MnfctrView : {}", id);
        Optional<Cerf2MnfctrViewDTO> cerf2MnfctrViewDTO = cerf2MnfctrViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerf2MnfctrViewDTO);
    }
}
