package com.wcc.gma2.web.rest;

import com.wcc.gma2.domain.Std;
import com.wcc.gma2.repository.StdRepository;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Std}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class StdResource {

    private final Logger log = LoggerFactory.getLogger(StdResource.class);

    private static final String ENTITY_NAME = "std";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StdRepository stdRepository;

    public StdResource(StdRepository stdRepository) {
        this.stdRepository = stdRepository;
    }

    /**
     * {@code POST  /stds} : Create a new std.
     *
     * @param std the std to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new std, or with status {@code 400 (Bad Request)} if the std has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/stds")
    public ResponseEntity<Std> createStd(@RequestBody Std std) throws URISyntaxException {
        log.debug("REST request to save Std : {}", std);
        if (std.getId() != null) {
            throw new BadRequestAlertException("A new std cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Std result = stdRepository.save(std);
        return ResponseEntity
            .created(new URI("/api/stds/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /stds/:id} : Updates an existing std.
     *
     * @param id the id of the std to save.
     * @param std the std to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated std,
     * or with status {@code 400 (Bad Request)} if the std is not valid,
     * or with status {@code 500 (Internal Server Error)} if the std couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/stds/{id}")
    public ResponseEntity<Std> updateStd(@PathVariable(value = "id", required = false) final Long id, @RequestBody Std std)
        throws URISyntaxException {
        log.debug("REST request to update Std : {}, {}", id, std);
        if (std.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, std.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Std result = stdRepository.save(std);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, std.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /stds/:id} : Partial updates given fields of an existing std, field will ignore if it is null
     *
     * @param id the id of the std to save.
     * @param std the std to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated std,
     * or with status {@code 400 (Bad Request)} if the std is not valid,
     * or with status {@code 404 (Not Found)} if the std is not found,
     * or with status {@code 500 (Internal Server Error)} if the std couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/stds/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Std> partialUpdateStd(@PathVariable(value = "id", required = false) final Long id, @RequestBody Std std)
        throws URISyntaxException {
        log.debug("REST request to partial update Std partially : {}, {}", id, std);
        if (std.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, std.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Std> result = stdRepository
            .findById(std.getId())
            .map(existingStd -> {
                if (std.getStdNo() != null) {
                    existingStd.setStdNo(std.getStdNo());
                }
                if (std.getStdVer() != null) {
                    existingStd.setStdVer(std.getStdVer());
                }
                if (std.getName() != null) {
                    existingStd.setName(std.getName());
                }
                if (std.getStatus() != null) {
                    existingStd.setStatus(std.getStatus());
                }
                if (std.getFee() != null) {
                    existingStd.setFee(std.getFee());
                }
                if (std.getIssuDt() != null) {
                    existingStd.setIssuDt(std.getIssuDt());
                }
                if (std.getExpDt() != null) {
                    existingStd.setExpDt(std.getExpDt());
                }

                return existingStd;
            })
            .map(stdRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, std.getId().toString())
        );
    }

    /**
     * {@code GET  /stds} : get all the stds.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stds in body.
     */
    @GetMapping("/stds")
    public List<Std> getAllStds() {
        log.debug("REST request to get all Stds");
        return stdRepository.findAll();
    }

    /**
     * {@code GET  /stds/:id} : get the "id" std.
     *
     * @param id the id of the std to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the std, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/stds/{id}")
    public ResponseEntity<Std> getStd(@PathVariable Long id) {
        log.debug("REST request to get Std : {}", id);
        Optional<Std> std = stdRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(std);
    }

    /**
     * {@code DELETE  /stds/:id} : delete the "id" std.
     *
     * @param id the id of the std to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/stds/{id}")
    public ResponseEntity<Void> deleteStd(@PathVariable Long id) {
        log.debug("REST request to delete Std : {}", id);
        stdRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
