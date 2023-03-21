package com.wcc.gma2.service;

import com.wcc.gma2.domain.Cerf2StdView;
import com.wcc.gma2.repository.Cerf2StdViewRepository;
import com.wcc.gma2.service.dto.Cerf2StdViewDTO;
import com.wcc.gma2.service.mapper.Cerf2StdViewMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cerf2StdView}.
 */
@Service
@Transactional
public class Cerf2StdViewService {

    private final Logger log = LoggerFactory.getLogger(Cerf2StdViewService.class);

    private final Cerf2StdViewRepository cerf2StdViewRepository;

    private final Cerf2StdViewMapper cerf2StdViewMapper;

    public Cerf2StdViewService(Cerf2StdViewRepository cerf2StdViewRepository, Cerf2StdViewMapper cerf2StdViewMapper) {
        this.cerf2StdViewRepository = cerf2StdViewRepository;
        this.cerf2StdViewMapper = cerf2StdViewMapper;
    }

    /**
     * Save a cerf2StdView.
     *
     * @param cerf2StdViewDTO the entity to save.
     * @return the persisted entity.
     */
    public Cerf2StdViewDTO save(Cerf2StdViewDTO cerf2StdViewDTO) {
        log.debug("Request to save Cerf2StdView : {}", cerf2StdViewDTO);
        Cerf2StdView cerf2StdView = cerf2StdViewMapper.toEntity(cerf2StdViewDTO);
        cerf2StdView = cerf2StdViewRepository.save(cerf2StdView);
        return cerf2StdViewMapper.toDto(cerf2StdView);
    }

    /**
     * Update a cerf2StdView.
     *
     * @param cerf2StdViewDTO the entity to save.
     * @return the persisted entity.
     */
    public Cerf2StdViewDTO update(Cerf2StdViewDTO cerf2StdViewDTO) {
        log.debug("Request to update Cerf2StdView : {}", cerf2StdViewDTO);
        Cerf2StdView cerf2StdView = cerf2StdViewMapper.toEntity(cerf2StdViewDTO);
        cerf2StdView = cerf2StdViewRepository.save(cerf2StdView);
        return cerf2StdViewMapper.toDto(cerf2StdView);
    }

    /**
     * Partially update a cerf2StdView.
     *
     * @param cerf2StdViewDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Cerf2StdViewDTO> partialUpdate(Cerf2StdViewDTO cerf2StdViewDTO) {
        log.debug("Request to partially update Cerf2StdView : {}", cerf2StdViewDTO);

        return cerf2StdViewRepository
            .findById(cerf2StdViewDTO.getId())
            .map(existingCerf2StdView -> {
                cerf2StdViewMapper.partialUpdate(existingCerf2StdView, cerf2StdViewDTO);

                return existingCerf2StdView;
            })
            .map(cerf2StdViewRepository::save)
            .map(cerf2StdViewMapper::toDto);
    }

    /**
     * Get all the cerf2StdViews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Cerf2StdViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cerf2StdViews");
        return cerf2StdViewRepository.findAll(pageable).map(cerf2StdViewMapper::toDto);
    }

    /**
     * Get one cerf2StdView by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cerf2StdViewDTO> findOne(Long id) {
        log.debug("Request to get Cerf2StdView : {}", id);
        return cerf2StdViewRepository.findById(id).map(cerf2StdViewMapper::toDto);
    }

    /**
     * Delete the cerf2StdView by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cerf2StdView : {}", id);
        cerf2StdViewRepository.deleteById(id);
    }
}
