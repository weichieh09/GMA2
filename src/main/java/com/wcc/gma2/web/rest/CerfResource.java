package com.wcc.gma2.web.rest;

import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.repository.CerfRepository;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class CerfResource {

    private final Logger log = LoggerFactory.getLogger(CerfResource.class);

    private static final String ENTITY_NAME = "cerf";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CerfRepository cerfRepository;

    public CerfResource(CerfRepository cerfRepository) {
        this.cerfRepository = cerfRepository;
    }

    /**
     * {@code POST  /cerfs} : Create a new cerf.
     *
     * @param cerf the cerf to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cerf, or with status {@code 400 (Bad Request)} if the cerf has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cerfs")
    public ResponseEntity<Cerf> createCerf(@RequestBody Cerf cerf) throws URISyntaxException {
        log.debug("REST request to save Cerf : {}", cerf);
        if (cerf.getId() != null) {
            throw new BadRequestAlertException("A new cerf cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cerf result = cerfRepository.save(cerf);
        return ResponseEntity
            .created(new URI("/api/cerfs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cerfs/:id} : Updates an existing cerf.
     *
     * @param id the id of the cerf to save.
     * @param cerf the cerf to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerf,
     * or with status {@code 400 (Bad Request)} if the cerf is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cerf couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cerfs/{id}")
    public ResponseEntity<Cerf> updateCerf(@PathVariable(value = "id", required = false) final Long id, @RequestBody Cerf cerf)
        throws URISyntaxException {
        log.debug("REST request to update Cerf : {}, {}", id, cerf);
        if (cerf.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerf.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Cerf result = cerfRepository.save(cerf);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerf.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cerfs/:id} : Partial updates given fields of an existing cerf, field will ignore if it is null
     *
     * @param id the id of the cerf to save.
     * @param cerf the cerf to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cerf,
     * or with status {@code 400 (Bad Request)} if the cerf is not valid,
     * or with status {@code 404 (Not Found)} if the cerf is not found,
     * or with status {@code 500 (Internal Server Error)} if the cerf couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cerfs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Cerf> partialUpdateCerf(@PathVariable(value = "id", required = false) final Long id, @RequestBody Cerf cerf)
        throws URISyntaxException {
        log.debug("REST request to partial update Cerf partially : {}, {}", id, cerf);
        if (cerf.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cerf.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cerfRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Cerf> result = cerfRepository
            .findById(cerf.getId())
            .map(existingCerf -> {
                if (cerf.getCerfNo() != null) {
                    existingCerf.setCerfNo(cerf.getCerfNo());
                }
                if (cerf.getCerfVer() != null) {
                    existingCerf.setCerfVer(cerf.getCerfVer());
                }
                if (cerf.getStatus() != null) {
                    existingCerf.setStatus(cerf.getStatus());
                }
                if (cerf.getPdf() != null) {
                    existingCerf.setPdf(cerf.getPdf());
                }
                if (cerf.getPdfContentType() != null) {
                    existingCerf.setPdfContentType(cerf.getPdfContentType());
                }
                if (cerf.getApplId() != null) {
                    existingCerf.setApplId(cerf.getApplId());
                }
                if (cerf.getFctyId() != null) {
                    existingCerf.setFctyId(cerf.getFctyId());
                }
                if (cerf.getMnfctrId() != null) {
                    existingCerf.setMnfctrId(cerf.getMnfctrId());
                }
                if (cerf.getIssuDt() != null) {
                    existingCerf.setIssuDt(cerf.getIssuDt());
                }
                if (cerf.getExpDt() != null) {
                    existingCerf.setExpDt(cerf.getExpDt());
                }

                return existingCerf;
            })
            .map(cerfRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cerf.getId().toString())
        );
    }

    /**
     * {@code GET  /cerfs} : get all the cerfs.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cerfs in body.
     */
    @GetMapping("/cerfs")
    public List<Cerf> getAllCerfs(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Cerfs");
        if (eagerload) {
            return cerfRepository.findAllWithEagerRelationships();
        } else {
            return cerfRepository.findAll();
        }
    }

    /**
     * {@code GET  /cerfs/:id} : get the "id" cerf.
     *
     * @param id the id of the cerf to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cerf, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cerfs/{id}")
    public ResponseEntity<Cerf> getCerf(@PathVariable Long id) {
        log.debug("REST request to get Cerf : {}", id);
        Optional<Cerf> cerf = cerfRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(cerf);
    }

    /**
     * {@code DELETE  /cerfs/:id} : delete the "id" cerf.
     *
     * @param id the id of the cerf to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cerfs/{id}")
    public ResponseEntity<Void> deleteCerf(@PathVariable Long id) {
        log.debug("REST request to delete Cerf : {}", id);
        cerfRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
