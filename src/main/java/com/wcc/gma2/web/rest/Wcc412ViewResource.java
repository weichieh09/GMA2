package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.Wcc412ViewRepository;
import com.wcc.gma2.service.Wcc412ViewQueryService;
import com.wcc.gma2.service.Wcc412ViewService;
import com.wcc.gma2.service.criteria.Wcc412ViewCriteria;
import com.wcc.gma2.service.dto.Wcc412ViewDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Wcc412View}.
 */
@RestController
@RequestMapping("/api")
public class Wcc412ViewResource {

    private final Logger log = LoggerFactory.getLogger(Wcc412ViewResource.class);

    private final Wcc412ViewService wcc412ViewService;

    private final Wcc412ViewRepository wcc412ViewRepository;

    private final Wcc412ViewQueryService wcc412ViewQueryService;

    public Wcc412ViewResource(
        Wcc412ViewService wcc412ViewService,
        Wcc412ViewRepository wcc412ViewRepository,
        Wcc412ViewQueryService wcc412ViewQueryService
    ) {
        this.wcc412ViewService = wcc412ViewService;
        this.wcc412ViewRepository = wcc412ViewRepository;
        this.wcc412ViewQueryService = wcc412ViewQueryService;
    }

    /**
     * {@code GET  /wcc-412-views} : get all the wcc412Views.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of wcc412Views in body.
     */
    @GetMapping("/wcc-412-views")
    public ResponseEntity<List<Wcc412ViewDTO>> getAllWcc412Views(
        Wcc412ViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Wcc412Views by criteria: {}", criteria);
        Page<Wcc412ViewDTO> page = wcc412ViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /wcc-412-views/count} : count all the wcc412Views.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/wcc-412-views/count")
    public ResponseEntity<Long> countWcc412Views(Wcc412ViewCriteria criteria) {
        log.debug("REST request to count Wcc412Views by criteria: {}", criteria);
        return ResponseEntity.ok().body(wcc412ViewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /wcc-412-views/:id} : get the "id" wcc412View.
     *
     * @param id the id of the wcc412ViewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the wcc412ViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/wcc-412-views/{id}")
    public ResponseEntity<Wcc412ViewDTO> getWcc412View(@PathVariable Long id) {
        log.debug("REST request to get Wcc412View : {}", id);
        Optional<Wcc412ViewDTO> wcc412ViewDTO = wcc412ViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(wcc412ViewDTO);
    }
}
