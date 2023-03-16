package com.wcc.gma2.service;

import com.wcc.gma2.domain.Prod2Cerf;
import com.wcc.gma2.repository.Prod2CerfRepository;
import com.wcc.gma2.service.dto.Prod2CerfDTO;
import com.wcc.gma2.service.mapper.Prod2CerfMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Prod2Cerf}.
 */
@Service
@Transactional
public class Prod2CerfService {

    private final Logger log = LoggerFactory.getLogger(Prod2CerfService.class);

    private final Prod2CerfRepository prod2CerfRepository;

    private final Prod2CerfMapper prod2CerfMapper;

    public Prod2CerfService(Prod2CerfRepository prod2CerfRepository, Prod2CerfMapper prod2CerfMapper) {
        this.prod2CerfRepository = prod2CerfRepository;
        this.prod2CerfMapper = prod2CerfMapper;
    }

    /**
     * Save a prod2Cerf.
     *
     * @param prod2CerfDTO the entity to save.
     * @return the persisted entity.
     */
    public Prod2CerfDTO save(Prod2CerfDTO prod2CerfDTO) {
        log.debug("Request to save Prod2Cerf : {}", prod2CerfDTO);
        Prod2Cerf prod2Cerf = prod2CerfMapper.toEntity(prod2CerfDTO);
        prod2Cerf = prod2CerfRepository.save(prod2Cerf);
        return prod2CerfMapper.toDto(prod2Cerf);
    }

    /**
     * Update a prod2Cerf.
     *
     * @param prod2CerfDTO the entity to save.
     * @return the persisted entity.
     */
    public Prod2CerfDTO update(Prod2CerfDTO prod2CerfDTO) {
        log.debug("Request to update Prod2Cerf : {}", prod2CerfDTO);
        Prod2Cerf prod2Cerf = prod2CerfMapper.toEntity(prod2CerfDTO);
        prod2Cerf = prod2CerfRepository.save(prod2Cerf);
        return prod2CerfMapper.toDto(prod2Cerf);
    }

    /**
     * Partially update a prod2Cerf.
     *
     * @param prod2CerfDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Prod2CerfDTO> partialUpdate(Prod2CerfDTO prod2CerfDTO) {
        log.debug("Request to partially update Prod2Cerf : {}", prod2CerfDTO);

        return prod2CerfRepository
            .findById(prod2CerfDTO.getId())
            .map(existingProd2Cerf -> {
                prod2CerfMapper.partialUpdate(existingProd2Cerf, prod2CerfDTO);

                return existingProd2Cerf;
            })
            .map(prod2CerfRepository::save)
            .map(prod2CerfMapper::toDto);
    }

    /**
     * Get all the prod2Cerfs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Prod2CerfDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Prod2Cerfs");
        return prod2CerfRepository.findAll(pageable).map(prod2CerfMapper::toDto);
    }

    /**
     * Get one prod2Cerf by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Prod2CerfDTO> findOne(Long id) {
        log.debug("Request to get Prod2Cerf : {}", id);
        return prod2CerfRepository.findById(id).map(prod2CerfMapper::toDto);
    }

    /**
     * Delete the prod2Cerf by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Prod2Cerf : {}", id);
        prod2CerfRepository.deleteById(id);
    }
}
