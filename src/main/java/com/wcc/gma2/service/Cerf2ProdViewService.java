package com.wcc.gma2.service;

import com.wcc.gma2.domain.Cerf2ProdView;
import com.wcc.gma2.repository.Cerf2ProdViewRepository;
import com.wcc.gma2.service.dto.Cerf2ProdViewDTO;
import com.wcc.gma2.service.mapper.Cerf2ProdViewMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cerf2ProdView}.
 */
@Service
@Transactional
public class Cerf2ProdViewService {

    private final Logger log = LoggerFactory.getLogger(Cerf2ProdViewService.class);

    private final Cerf2ProdViewRepository cerf2ProdViewRepository;

    private final Cerf2ProdViewMapper cerf2ProdViewMapper;

    public Cerf2ProdViewService(Cerf2ProdViewRepository cerf2ProdViewRepository, Cerf2ProdViewMapper cerf2ProdViewMapper) {
        this.cerf2ProdViewRepository = cerf2ProdViewRepository;
        this.cerf2ProdViewMapper = cerf2ProdViewMapper;
    }

    /**
     * Save a cerf2ProdView.
     *
     * @param cerf2ProdViewDTO the entity to save.
     * @return the persisted entity.
     */
    public Cerf2ProdViewDTO save(Cerf2ProdViewDTO cerf2ProdViewDTO) {
        log.debug("Request to save Cerf2ProdView : {}", cerf2ProdViewDTO);
        Cerf2ProdView cerf2ProdView = cerf2ProdViewMapper.toEntity(cerf2ProdViewDTO);
        cerf2ProdView = cerf2ProdViewRepository.save(cerf2ProdView);
        return cerf2ProdViewMapper.toDto(cerf2ProdView);
    }

    /**
     * Update a cerf2ProdView.
     *
     * @param cerf2ProdViewDTO the entity to save.
     * @return the persisted entity.
     */
    public Cerf2ProdViewDTO update(Cerf2ProdViewDTO cerf2ProdViewDTO) {
        log.debug("Request to update Cerf2ProdView : {}", cerf2ProdViewDTO);
        Cerf2ProdView cerf2ProdView = cerf2ProdViewMapper.toEntity(cerf2ProdViewDTO);
        cerf2ProdView = cerf2ProdViewRepository.save(cerf2ProdView);
        return cerf2ProdViewMapper.toDto(cerf2ProdView);
    }

    /**
     * Partially update a cerf2ProdView.
     *
     * @param cerf2ProdViewDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Cerf2ProdViewDTO> partialUpdate(Cerf2ProdViewDTO cerf2ProdViewDTO) {
        log.debug("Request to partially update Cerf2ProdView : {}", cerf2ProdViewDTO);

        return cerf2ProdViewRepository
            .findById(cerf2ProdViewDTO.getId())
            .map(existingCerf2ProdView -> {
                cerf2ProdViewMapper.partialUpdate(existingCerf2ProdView, cerf2ProdViewDTO);

                return existingCerf2ProdView;
            })
            .map(cerf2ProdViewRepository::save)
            .map(cerf2ProdViewMapper::toDto);
    }

    /**
     * Get all the cerf2ProdViews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Cerf2ProdViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cerf2ProdViews");
        return cerf2ProdViewRepository.findAll(pageable).map(cerf2ProdViewMapper::toDto);
    }

    /**
     * Get one cerf2ProdView by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cerf2ProdViewDTO> findOne(Long id) {
        log.debug("Request to get Cerf2ProdView : {}", id);
        return cerf2ProdViewRepository.findById(id).map(cerf2ProdViewMapper::toDto);
    }

    /**
     * Delete the cerf2ProdView by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cerf2ProdView : {}", id);
        cerf2ProdViewRepository.deleteById(id);
    }
}
