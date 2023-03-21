package com.wcc.gma2.service;

import com.wcc.gma2.domain.Cerf2MnfctrView;
import com.wcc.gma2.repository.Cerf2MnfctrViewRepository;
import com.wcc.gma2.service.dto.Cerf2MnfctrViewDTO;
import com.wcc.gma2.service.mapper.Cerf2MnfctrViewMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cerf2MnfctrView}.
 */
@Service
@Transactional
public class Cerf2MnfctrViewService {

    private final Logger log = LoggerFactory.getLogger(Cerf2MnfctrViewService.class);

    private final Cerf2MnfctrViewRepository cerf2MnfctrViewRepository;

    private final Cerf2MnfctrViewMapper cerf2MnfctrViewMapper;

    public Cerf2MnfctrViewService(Cerf2MnfctrViewRepository cerf2MnfctrViewRepository, Cerf2MnfctrViewMapper cerf2MnfctrViewMapper) {
        this.cerf2MnfctrViewRepository = cerf2MnfctrViewRepository;
        this.cerf2MnfctrViewMapper = cerf2MnfctrViewMapper;
    }

    /**
     * Save a cerf2MnfctrView.
     *
     * @param cerf2MnfctrViewDTO the entity to save.
     * @return the persisted entity.
     */
    public Cerf2MnfctrViewDTO save(Cerf2MnfctrViewDTO cerf2MnfctrViewDTO) {
        log.debug("Request to save Cerf2MnfctrView : {}", cerf2MnfctrViewDTO);
        Cerf2MnfctrView cerf2MnfctrView = cerf2MnfctrViewMapper.toEntity(cerf2MnfctrViewDTO);
        cerf2MnfctrView = cerf2MnfctrViewRepository.save(cerf2MnfctrView);
        return cerf2MnfctrViewMapper.toDto(cerf2MnfctrView);
    }

    /**
     * Update a cerf2MnfctrView.
     *
     * @param cerf2MnfctrViewDTO the entity to save.
     * @return the persisted entity.
     */
    public Cerf2MnfctrViewDTO update(Cerf2MnfctrViewDTO cerf2MnfctrViewDTO) {
        log.debug("Request to update Cerf2MnfctrView : {}", cerf2MnfctrViewDTO);
        Cerf2MnfctrView cerf2MnfctrView = cerf2MnfctrViewMapper.toEntity(cerf2MnfctrViewDTO);
        cerf2MnfctrView = cerf2MnfctrViewRepository.save(cerf2MnfctrView);
        return cerf2MnfctrViewMapper.toDto(cerf2MnfctrView);
    }

    /**
     * Partially update a cerf2MnfctrView.
     *
     * @param cerf2MnfctrViewDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Cerf2MnfctrViewDTO> partialUpdate(Cerf2MnfctrViewDTO cerf2MnfctrViewDTO) {
        log.debug("Request to partially update Cerf2MnfctrView : {}", cerf2MnfctrViewDTO);

        return cerf2MnfctrViewRepository
            .findById(cerf2MnfctrViewDTO.getId())
            .map(existingCerf2MnfctrView -> {
                cerf2MnfctrViewMapper.partialUpdate(existingCerf2MnfctrView, cerf2MnfctrViewDTO);

                return existingCerf2MnfctrView;
            })
            .map(cerf2MnfctrViewRepository::save)
            .map(cerf2MnfctrViewMapper::toDto);
    }

    /**
     * Get all the cerf2MnfctrViews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Cerf2MnfctrViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cerf2MnfctrViews");
        return cerf2MnfctrViewRepository.findAll(pageable).map(cerf2MnfctrViewMapper::toDto);
    }

    /**
     * Get one cerf2MnfctrView by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cerf2MnfctrViewDTO> findOne(Long id) {
        log.debug("Request to get Cerf2MnfctrView : {}", id);
        return cerf2MnfctrViewRepository.findById(id).map(cerf2MnfctrViewMapper::toDto);
    }

    /**
     * Delete the cerf2MnfctrView by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cerf2MnfctrView : {}", id);
        cerf2MnfctrViewRepository.deleteById(id);
    }
}
