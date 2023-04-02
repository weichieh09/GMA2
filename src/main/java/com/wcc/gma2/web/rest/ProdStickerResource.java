package com.wcc.gma2.web.rest;

import com.wcc.gma2.repository.ProdStickerRepository;
import com.wcc.gma2.service.ProdStickerQueryService;
import com.wcc.gma2.service.ProdStickerService;
import com.wcc.gma2.service.criteria.ProdStickerCriteria;
import com.wcc.gma2.service.dto.ProdStickerDTO;
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
 * REST controller for managing {@link com.wcc.gma2.domain.ProdSticker}.
 */
@RestController
@RequestMapping("/api")
public class ProdStickerResource {

    private final Logger log = LoggerFactory.getLogger(ProdStickerResource.class);

    private static final String ENTITY_NAME = "prodSticker";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProdStickerService prodStickerService;

    private final ProdStickerRepository prodStickerRepository;

    private final ProdStickerQueryService prodStickerQueryService;

    public ProdStickerResource(
        ProdStickerService prodStickerService,
        ProdStickerRepository prodStickerRepository,
        ProdStickerQueryService prodStickerQueryService
    ) {
        this.prodStickerService = prodStickerService;
        this.prodStickerRepository = prodStickerRepository;
        this.prodStickerQueryService = prodStickerQueryService;
    }

    /**
     * {@code POST  /prod-stickers} : Create a new prodSticker.
     *
     * @param prodStickerDTO the prodStickerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prodStickerDTO, or with status {@code 400 (Bad Request)} if the prodSticker has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prod-stickers")
    public ResponseEntity<ProdStickerDTO> createProdSticker(@Valid @RequestBody ProdStickerDTO prodStickerDTO) throws URISyntaxException {
        log.debug("REST request to save ProdSticker : {}", prodStickerDTO);
        if (prodStickerDTO.getId() != null) {
            throw new BadRequestAlertException("A new prodSticker cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProdStickerDTO result = prodStickerService.save(prodStickerDTO);
        return ResponseEntity
            .created(new URI("/api/prod-stickers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prod-stickers/:id} : Updates an existing prodSticker.
     *
     * @param id the id of the prodStickerDTO to save.
     * @param prodStickerDTO the prodStickerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prodStickerDTO,
     * or with status {@code 400 (Bad Request)} if the prodStickerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prodStickerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prod-stickers/{id}")
    public ResponseEntity<ProdStickerDTO> updateProdSticker(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ProdStickerDTO prodStickerDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProdSticker : {}, {}", id, prodStickerDTO);
        if (prodStickerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prodStickerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodStickerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ProdStickerDTO result = prodStickerService.update(prodStickerDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prodStickerDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prod-stickers/:id} : Partial updates given fields of an existing prodSticker, field will ignore if it is null
     *
     * @param id the id of the prodStickerDTO to save.
     * @param prodStickerDTO the prodStickerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prodStickerDTO,
     * or with status {@code 400 (Bad Request)} if the prodStickerDTO is not valid,
     * or with status {@code 404 (Not Found)} if the prodStickerDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the prodStickerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prod-stickers/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ProdStickerDTO> partialUpdateProdSticker(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ProdStickerDTO prodStickerDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProdSticker partially : {}, {}", id, prodStickerDTO);
        if (prodStickerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prodStickerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodStickerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ProdStickerDTO> result = prodStickerService.partialUpdate(prodStickerDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prodStickerDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /prod-stickers} : get all the prodStickers.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prodStickers in body.
     */
    @GetMapping("/prod-stickers")
    public ResponseEntity<List<ProdStickerDTO>> getAllProdStickers(
        ProdStickerCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get ProdStickers by criteria: {}", criteria);
        Page<ProdStickerDTO> page = prodStickerQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /prod-stickers/count} : count all the prodStickers.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/prod-stickers/count")
    public ResponseEntity<Long> countProdStickers(ProdStickerCriteria criteria) {
        log.debug("REST request to count ProdStickers by criteria: {}", criteria);
        return ResponseEntity.ok().body(prodStickerQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /prod-stickers/:id} : get the "id" prodSticker.
     *
     * @param id the id of the prodStickerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prodStickerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prod-stickers/{id}")
    public ResponseEntity<ProdStickerDTO> getProdSticker(@PathVariable Long id) {
        log.debug("REST request to get ProdSticker : {}", id);
        Optional<ProdStickerDTO> prodStickerDTO = prodStickerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(prodStickerDTO);
    }

    /**
     * {@code DELETE  /prod-stickers/:id} : delete the "id" prodSticker.
     *
     * @param id the id of the prodStickerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prod-stickers/{id}")
    public ResponseEntity<Void> deleteProdSticker(@PathVariable Long id) {
        log.debug("REST request to delete ProdSticker : {}", id);
        prodStickerService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
