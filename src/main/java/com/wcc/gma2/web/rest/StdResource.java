package com.wcc.gma2.web.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.service.WccStdService;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.repository.StdRepository;
import com.wcc.gma2.service.StdQueryService;
import com.wcc.gma2.service.StdService;
import com.wcc.gma2.service.criteria.StdCriteria;
import com.wcc.gma2.service.dto.StdDTO;
import com.wcc.gma2.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * REST controller for managing {@link com.wcc.gma2.domain.Std}.
 */
@RestController
@RequestMapping("/api")
public class StdResource {

    private final Logger log = LoggerFactory.getLogger(StdResource.class);

    private static final String ENTITY_NAME = "std";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StdService stdService;

    private final StdRepository stdRepository;

    private final StdQueryService stdQueryService;

    @Autowired
    private WccStdService wccStdService;

    public StdResource(StdService stdService, StdRepository stdRepository, StdQueryService stdQueryService) {
        this.stdService = stdService;
        this.stdRepository = stdRepository;
        this.stdQueryService = stdQueryService;
    }

    /**
     * {@code POST  /stds} : Create a new std.
     *
     * @param stdDTO the stdDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stdDTO, or with status {@code 400 (Bad Request)} if the std has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/stds")
    public ResponseEntity<StdDTO> createStd(@Valid @RequestBody StdDTO stdDTO) throws URISyntaxException {
        log.debug("REST request to save Std : {}", stdDTO);
        if (stdDTO.getId() != null) {
            throw new BadRequestAlertException("A new std cannot already have an ID", ENTITY_NAME, "idexists");
        }

        stdDTO = wccStdService.setStdStatus(stdDTO);

        StdDTO result = stdService.save(stdDTO);
        return ResponseEntity
            .created(new URI("/api/stds/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /stds/:id} : Updates an existing std.
     *
     * @param id the id of the stdDTO to save.
     * @param stdDTO the stdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stdDTO,
     * or with status {@code 400 (Bad Request)} if the stdDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/stds/{id}")
    public ResponseEntity<StdDTO> updateStd(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody StdDTO stdDTO)
        throws URISyntaxException {
        log.debug("REST request to update Std : {}, {}", id, stdDTO);
        if (stdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        stdDTO = wccStdService.setStdStatus(stdDTO);

        StdDTO result = stdService.update(stdDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stdDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /stds/:id} : Partial updates given fields of an existing std, field will ignore if it is null
     *
     * @param id the id of the stdDTO to save.
     * @param stdDTO the stdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stdDTO,
     * or with status {@code 400 (Bad Request)} if the stdDTO is not valid,
     * or with status {@code 404 (Not Found)} if the stdDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the stdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/stds/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<StdDTO> partialUpdateStd(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody StdDTO stdDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Std partially : {}, {}", id, stdDTO);
        if (stdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, stdDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!stdRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<StdDTO> result = stdService.partialUpdate(stdDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, stdDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /stds} : get all the stds.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stds in body.
     */
    @GetMapping("/stds")
    public ResponseEntity<List<StdDTO>> getAllStds(StdCriteria criteria, @org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get Stds by criteria: {}", criteria);
        Page<StdDTO> page = stdQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /stds/count} : count all the stds.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/stds/count")
    public ResponseEntity<Long> countStds(StdCriteria criteria) {
        log.debug("REST request to count Stds by criteria: {}", criteria);
        return ResponseEntity.ok().body(stdQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /stds/:id} : get the "id" std.
     *
     * @param id the id of the stdDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stdDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/stds/{id}")
    public ResponseEntity<StdDTO> getStd(@PathVariable Long id) {
        log.debug("REST request to get Std : {}", id);
        Optional<StdDTO> stdDTO = stdService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stdDTO);
    }

    /**
     * {@code DELETE  /stds/:id} : delete the "id" std.
     *
     * @param id the id of the stdDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/stds/{id}")
    public ResponseEntity<Void> deleteStd(@PathVariable Long id) {
        log.debug("REST request to delete Std : {}", id);
        stdService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    @PostMapping("/stds/sendMail")
    public ResponseEntity<ResponseDTO> sendMail(@Valid @RequestBody Map<String, Long> req) {
        ResponseDTO res = new ResponseDTO<>();
        res.setStatusCode(wccStdService.sndMail(req.get("stdId")));
        return ResponseEntity.ok().body(res);
    }
}
