package com.wcc.gma2.service;

import com.wcc.gma2.domain.CerfSearchView;
import com.wcc.gma2.repository.CerfSearchViewRepository;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
import com.wcc.gma2.service.mapper.CerfSearchViewMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CerfSearchView}.
 */
@Service
@Transactional
public class CerfSearchViewService {

    private final Logger log = LoggerFactory.getLogger(CerfSearchViewService.class);

    private final CerfSearchViewRepository cerfSearchViewRepository;

    private final CerfSearchViewMapper cerfSearchViewMapper;

    public CerfSearchViewService(CerfSearchViewRepository cerfSearchViewRepository, CerfSearchViewMapper cerfSearchViewMapper) {
        this.cerfSearchViewRepository = cerfSearchViewRepository;
        this.cerfSearchViewMapper = cerfSearchViewMapper;
    }

    /**
     * Save a cerfSearchView.
     *
     * @param cerfSearchViewDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfSearchViewDTO save(CerfSearchViewDTO cerfSearchViewDTO) {
        log.debug("Request to save CerfSearchView : {}", cerfSearchViewDTO);
        CerfSearchView cerfSearchView = cerfSearchViewMapper.toEntity(cerfSearchViewDTO);
        cerfSearchView = cerfSearchViewRepository.save(cerfSearchView);
        return cerfSearchViewMapper.toDto(cerfSearchView);
    }

    /**
     * Update a cerfSearchView.
     *
     * @param cerfSearchViewDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfSearchViewDTO update(CerfSearchViewDTO cerfSearchViewDTO) {
        log.debug("Request to update CerfSearchView : {}", cerfSearchViewDTO);
        CerfSearchView cerfSearchView = cerfSearchViewMapper.toEntity(cerfSearchViewDTO);
        cerfSearchView = cerfSearchViewRepository.save(cerfSearchView);
        return cerfSearchViewMapper.toDto(cerfSearchView);
    }

    /**
     * Partially update a cerfSearchView.
     *
     * @param cerfSearchViewDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CerfSearchViewDTO> partialUpdate(CerfSearchViewDTO cerfSearchViewDTO) {
        log.debug("Request to partially update CerfSearchView : {}", cerfSearchViewDTO);

        return cerfSearchViewRepository
            .findById(cerfSearchViewDTO.getId())
            .map(existingCerfSearchView -> {
                cerfSearchViewMapper.partialUpdate(existingCerfSearchView, cerfSearchViewDTO);

                return existingCerfSearchView;
            })
            .map(cerfSearchViewRepository::save)
            .map(cerfSearchViewMapper::toDto);
    }

    /**
     * Get all the cerfSearchViews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfSearchViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CerfSearchViews");
        return cerfSearchViewRepository.findAll(pageable).map(cerfSearchViewMapper::toDto);
    }

    /**
     * Get one cerfSearchView by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CerfSearchViewDTO> findOne(Long id) {
        log.debug("Request to get CerfSearchView : {}", id);
        return cerfSearchViewRepository.findById(id).map(cerfSearchViewMapper::toDto);
    }

    /**
     * Delete the cerfSearchView by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CerfSearchView : {}", id);
        cerfSearchViewRepository.deleteById(id);
    }
}
