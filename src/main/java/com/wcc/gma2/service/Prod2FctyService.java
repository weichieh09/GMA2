package com.wcc.gma2.service;

import com.wcc.gma2.domain.Prod2Fcty;
import com.wcc.gma2.repository.Prod2FctyRepository;
import com.wcc.gma2.service.dto.Prod2FctyDTO;
import com.wcc.gma2.service.mapper.Prod2FctyMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Prod2Fcty}.
 */
@Service
@Transactional
public class Prod2FctyService {

    private final Logger log = LoggerFactory.getLogger(Prod2FctyService.class);

    private final Prod2FctyRepository prod2FctyRepository;

    private final Prod2FctyMapper prod2FctyMapper;

    public Prod2FctyService(Prod2FctyRepository prod2FctyRepository, Prod2FctyMapper prod2FctyMapper) {
        this.prod2FctyRepository = prod2FctyRepository;
        this.prod2FctyMapper = prod2FctyMapper;
    }

    /**
     * Save a prod2Fcty.
     *
     * @param prod2FctyDTO the entity to save.
     * @return the persisted entity.
     */
    public Prod2FctyDTO save(Prod2FctyDTO prod2FctyDTO) {
        log.debug("Request to save Prod2Fcty : {}", prod2FctyDTO);
        Prod2Fcty prod2Fcty = prod2FctyMapper.toEntity(prod2FctyDTO);
        prod2Fcty = prod2FctyRepository.save(prod2Fcty);
        return prod2FctyMapper.toDto(prod2Fcty);
    }

    /**
     * Update a prod2Fcty.
     *
     * @param prod2FctyDTO the entity to save.
     * @return the persisted entity.
     */
    public Prod2FctyDTO update(Prod2FctyDTO prod2FctyDTO) {
        log.debug("Request to update Prod2Fcty : {}", prod2FctyDTO);
        Prod2Fcty prod2Fcty = prod2FctyMapper.toEntity(prod2FctyDTO);
        prod2Fcty = prod2FctyRepository.save(prod2Fcty);
        return prod2FctyMapper.toDto(prod2Fcty);
    }

    /**
     * Partially update a prod2Fcty.
     *
     * @param prod2FctyDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Prod2FctyDTO> partialUpdate(Prod2FctyDTO prod2FctyDTO) {
        log.debug("Request to partially update Prod2Fcty : {}", prod2FctyDTO);

        return prod2FctyRepository
            .findById(prod2FctyDTO.getId())
            .map(existingProd2Fcty -> {
                prod2FctyMapper.partialUpdate(existingProd2Fcty, prod2FctyDTO);

                return existingProd2Fcty;
            })
            .map(prod2FctyRepository::save)
            .map(prod2FctyMapper::toDto);
    }

    /**
     * Get all the prod2Fcties.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Prod2FctyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Prod2Fcties");
        return prod2FctyRepository.findAll(pageable).map(prod2FctyMapper::toDto);
    }

    /**
     * Get one prod2Fcty by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Prod2FctyDTO> findOne(Long id) {
        log.debug("Request to get Prod2Fcty : {}", id);
        return prod2FctyRepository.findById(id).map(prod2FctyMapper::toDto);
    }

    /**
     * Delete the prod2Fcty by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Prod2Fcty : {}", id);
        prod2FctyRepository.deleteById(id);
    }
}
