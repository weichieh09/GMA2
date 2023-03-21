package com.wcc.gma2.service;

import com.wcc.gma2.domain.CerfView;
import com.wcc.gma2.repository.CerfViewRepository;
import com.wcc.gma2.service.dto.CerfViewDTO;
import com.wcc.gma2.service.mapper.CerfViewMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CerfView}.
 */
@Service
@Transactional
public class CerfViewService {

    private final Logger log = LoggerFactory.getLogger(CerfViewService.class);

    private final CerfViewRepository cerfViewRepository;

    private final CerfViewMapper cerfViewMapper;

    public CerfViewService(CerfViewRepository cerfViewRepository, CerfViewMapper cerfViewMapper) {
        this.cerfViewRepository = cerfViewRepository;
        this.cerfViewMapper = cerfViewMapper;
    }

    /**
     * Save a cerfView.
     *
     * @param cerfViewDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfViewDTO save(CerfViewDTO cerfViewDTO) {
        log.debug("Request to save CerfView : {}", cerfViewDTO);
        CerfView cerfView = cerfViewMapper.toEntity(cerfViewDTO);
        cerfView = cerfViewRepository.save(cerfView);
        return cerfViewMapper.toDto(cerfView);
    }

    /**
     * Update a cerfView.
     *
     * @param cerfViewDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfViewDTO update(CerfViewDTO cerfViewDTO) {
        log.debug("Request to update CerfView : {}", cerfViewDTO);
        CerfView cerfView = cerfViewMapper.toEntity(cerfViewDTO);
        cerfView = cerfViewRepository.save(cerfView);
        return cerfViewMapper.toDto(cerfView);
    }

    /**
     * Partially update a cerfView.
     *
     * @param cerfViewDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CerfViewDTO> partialUpdate(CerfViewDTO cerfViewDTO) {
        log.debug("Request to partially update CerfView : {}", cerfViewDTO);

        return cerfViewRepository
            .findById(cerfViewDTO.getId())
            .map(existingCerfView -> {
                cerfViewMapper.partialUpdate(existingCerfView, cerfViewDTO);

                return existingCerfView;
            })
            .map(cerfViewRepository::save)
            .map(cerfViewMapper::toDto);
    }

    /**
     * Get all the cerfViews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CerfViews");
        return cerfViewRepository.findAll(pageable).map(cerfViewMapper::toDto);
    }

    /**
     * Get one cerfView by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CerfViewDTO> findOne(Long id) {
        log.debug("Request to get CerfView : {}", id);
        return cerfViewRepository.findById(id).map(cerfViewMapper::toDto);
    }

    /**
     * Delete the cerfView by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CerfView : {}", id);
        cerfViewRepository.deleteById(id);
    }
}
