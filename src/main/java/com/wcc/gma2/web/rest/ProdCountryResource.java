package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.ProdCountryRepository;
import com.wcc.gma2.service.ProdCountryQueryService;
import com.wcc.gma2.service.ProdCountryService;
import com.wcc.gma2.service.criteria.ProdCountryCriteria;
import com.wcc.gma2.service.dto.ProdCountryDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.ProdCountry}.
 */
@RestController
@RequestMapping("/api")
public class ProdCountryResource {

    private final Logger log = LoggerFactory.getLogger(ProdCountryResource.class);

    private static final String ENTITY_NAME = "prodCountry";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProdCountryService prodCountryService;

    private final ProdCountryRepository prodCountryRepository;

    private final ProdCountryQueryService prodCountryQueryService;

    public ProdCountryResource(
        ProdCountryService prodCountryService,
        ProdCountryRepository prodCountryRepository,
        ProdCountryQueryService prodCountryQueryService
    ) {
        this.prodCountryService = prodCountryService;
        this.prodCountryRepository = prodCountryRepository;
        this.prodCountryQueryService = prodCountryQueryService;
    }

    /**
     * {@code POST  /prod-countries} : Create a new prodCountry.
     *
     * @param prodCountryDTO the prodCountryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prodCountryDTO, or with status {@code 400 (Bad Request)} if the prodCountry has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prod-countries")
    public ResponseEntity<ProdCountryDTO> createProdCountry(@Valid @RequestBody ProdCountryDTO prodCountryDTO) throws URISyntaxException {
        log.debug("REST request to save ProdCountry : {}", prodCountryDTO);
        if (prodCountryDTO.getId() != null) {
            throw new BadRequestAlertException("A new prodCountry cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProdCountryDTO result = prodCountryService.save(prodCountryDTO);
        return ResponseEntity
            .created(new URI("/api/prod-countries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prod-countries/:id} : Updates an existing prodCountry.
     *
     * @param id the id of the prodCountryDTO to save.
     * @param prodCountryDTO the prodCountryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prodCountryDTO,
     * or with status {@code 400 (Bad Request)} if the prodCountryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prodCountryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prod-countries/{id}")
    public ResponseEntity<ProdCountryDTO> updateProdCountry(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ProdCountryDTO prodCountryDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProdCountry : {}, {}", id, prodCountryDTO);
        if (prodCountryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prodCountryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodCountryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ProdCountryDTO result = prodCountryService.update(prodCountryDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prodCountryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prod-countries/:id} : Partial updates given fields of an existing prodCountry, field will ignore if it is null
     *
     * @param id the id of the prodCountryDTO to save.
     * @param prodCountryDTO the prodCountryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prodCountryDTO,
     * or with status {@code 400 (Bad Request)} if the prodCountryDTO is not valid,
     * or with status {@code 404 (Not Found)} if the prodCountryDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the prodCountryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prod-countries/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ProdCountryDTO> partialUpdateProdCountry(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ProdCountryDTO prodCountryDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProdCountry partially : {}, {}", id, prodCountryDTO);
        if (prodCountryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prodCountryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodCountryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ProdCountryDTO> result = prodCountryService.partialUpdate(prodCountryDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prodCountryDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /prod-countries} : get all the prodCountries.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prodCountries in body.
     */
    @GetMapping("/prod-countries")
    public ResponseEntity<List<ProdCountryDTO>> getAllProdCountries(
        ProdCountryCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get ProdCountries by criteria: {}", criteria);
        Page<ProdCountryDTO> page = prodCountryQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /prod-countries/count} : count all the prodCountries.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/prod-countries/count")
    public ResponseEntity<Long> countProdCountries(ProdCountryCriteria criteria) {
        log.debug("REST request to count ProdCountries by criteria: {}", criteria);
        return ResponseEntity.ok().body(prodCountryQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /prod-countries/:id} : get the "id" prodCountry.
     *
     * @param id the id of the prodCountryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prodCountryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prod-countries/{id}")
    public ResponseEntity<ProdCountryDTO> getProdCountry(@PathVariable Long id) {
        log.debug("REST request to get ProdCountry : {}", id);
        Optional<ProdCountryDTO> prodCountryDTO = prodCountryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(prodCountryDTO);
    }

    /**
     * {@code DELETE  /prod-countries/:id} : delete the "id" prodCountry.
     *
     * @param id the id of the prodCountryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prod-countries/{id}")
    public ResponseEntity<Void> deleteProdCountry(@PathVariable Long id) {
        log.debug("REST request to delete ProdCountry : {}", id);
        prodCountryService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
