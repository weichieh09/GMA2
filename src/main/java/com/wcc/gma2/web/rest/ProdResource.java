package com.wcc.gma2.web.rest;

import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.repository.ProdRepository;
import com.wcc.gma2.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.wcc.gma2.domain.Prod}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ProdResource {

    private final Logger log = LoggerFactory.getLogger(ProdResource.class);

    private static final String ENTITY_NAME = "prod";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProdRepository prodRepository;

    public ProdResource(ProdRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    /**
     * {@code POST  /prods} : Create a new prod.
     *
     * @param prod the prod to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new prod, or with status {@code 400 (Bad Request)} if the prod has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/prods")
    public ResponseEntity<Prod> createProd(@RequestBody Prod prod) throws URISyntaxException {
        log.debug("REST request to save Prod : {}", prod);
        if (prod.getId() != null) {
            throw new BadRequestAlertException("A new prod cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Prod result = prodRepository.save(prod);
        return ResponseEntity
            .created(new URI("/api/prods/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /prods/:id} : Updates an existing prod.
     *
     * @param id the id of the prod to save.
     * @param prod the prod to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod,
     * or with status {@code 400 (Bad Request)} if the prod is not valid,
     * or with status {@code 500 (Internal Server Error)} if the prod couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/prods/{id}")
    public ResponseEntity<Prod> updateProd(@PathVariable(value = "id", required = false) final Long id, @RequestBody Prod prod)
        throws URISyntaxException {
        log.debug("REST request to update Prod : {}, {}", id, prod);
        if (prod.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Prod result = prodRepository.save(prod);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /prods/:id} : Partial updates given fields of an existing prod, field will ignore if it is null
     *
     * @param id the id of the prod to save.
     * @param prod the prod to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated prod,
     * or with status {@code 400 (Bad Request)} if the prod is not valid,
     * or with status {@code 404 (Not Found)} if the prod is not found,
     * or with status {@code 500 (Internal Server Error)} if the prod couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/prods/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Prod> partialUpdateProd(@PathVariable(value = "id", required = false) final Long id, @RequestBody Prod prod)
        throws URISyntaxException {
        log.debug("REST request to partial update Prod partially : {}, {}", id, prod);
        if (prod.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, prod.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!prodRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Prod> result = prodRepository
            .findById(prod.getId())
            .map(existingProd -> {
                if (prod.getProdNo() != null) {
                    existingProd.setProdNo(prod.getProdNo());
                }
                if (prod.getName() != null) {
                    existingProd.setName(prod.getName());
                }
                if (prod.getHsCode() != null) {
                    existingProd.setHsCode(prod.getHsCode());
                }
                if (prod.getCccCode() != null) {
                    existingProd.setCccCode(prod.getCccCode());
                }

                return existingProd;
            })
            .map(prodRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, prod.getId().toString())
        );
    }

    /**
     * {@code GET  /prods} : get all the prods.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of prods in body.
     */
    @GetMapping("/prods")
    public List<Prod> getAllProds(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Prods");
        if (eagerload) {
            return prodRepository.findAllWithEagerRelationships();
        } else {
            return prodRepository.findAll();
        }
    }

    /**
     * {@code GET  /prods/:id} : get the "id" prod.
     *
     * @param id the id of the prod to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the prod, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/prods/{id}")
    public ResponseEntity<Prod> getProd(@PathVariable Long id) {
        log.debug("REST request to get Prod : {}", id);
        Optional<Prod> prod = prodRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(prod);
    }

    /**
     * {@code DELETE  /prods/:id} : delete the "id" prod.
     *
     * @param id the id of the prod to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/prods/{id}")
    public ResponseEntity<Void> deleteProd(@PathVariable Long id) {
        log.debug("REST request to delete Prod : {}", id);
        prodRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
