package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Cerf2StdViewRepository;
import com.wcc.gma2.service.Cerf2StdViewQueryService;
import com.wcc.gma2.service.Cerf2StdViewService;
import com.wcc.gma2.service.criteria.Cerf2StdViewCriteria;
import com.wcc.gma2.service.dto.Cerf2StdViewDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf2StdView}.
 */
@RestController
@RequestMapping("/api")
public class Cerf2StdViewResource {

    private final Logger log = LoggerFactory.getLogger(Cerf2StdViewResource.class);

    private final Cerf2StdViewService cerf2StdViewService;

    private final Cerf2StdViewRepository cerf2StdViewRepository;

    private final Cerf2StdViewQueryService cerf2StdViewQueryService;

    public Cerf2StdViewResource(
        Cerf2StdViewService cerf2StdViewService,
        Cerf2StdViewRepository cerf2StdViewRepository,
        Cerf2StdViewQueryService cerf2StdViewQueryService
    ) {
        this.cerf2StdViewService = cerf2StdViewService;
        this.cerf2StdViewRepository = cerf2StdViewRepository;
        this.cerf2StdViewQueryService = cerf2StdViewQueryService;
    }

    /**
     * {@code GET  /cerf-2-std-views} : get all the cerf2StdViews.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerf2StdViews in body.
     */
    @GetMapping("/cerf-2-std-views")
    public ResponseEntity<List<Cerf2StdViewDTO>> getAllCerf2StdViews(
        Cerf2StdViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Cerf2StdViews by criteria: {}", criteria);
        Page<Cerf2StdViewDTO> page = cerf2StdViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cerf-2-std-views/count} : count all the cerf2StdViews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/cerf-2-std-views/count")
    public ResponseEntity<Long> countCerf2StdViews(Cerf2StdViewCriteria criteria) {
        log.debug("REST request to count Cerf2StdViews by criteria: {}", criteria);
        return ResponseEntity.ok().body(cerf2StdViewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cerf-2-std-views/:id} : get the "id" cerf2StdView.
     *
     * @param id the id of the cerf2StdViewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerf2StdViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerf-2-std-views/{id}")
    public ResponseEntity<Cerf2StdViewDTO> getCerf2StdView(@PathVariable Long id) {
        log.debug("REST request to get Cerf2StdView : {}", id);
        Optional<Cerf2StdViewDTO> cerf2StdViewDTO = cerf2StdViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cerf2StdViewDTO);
    }
}
