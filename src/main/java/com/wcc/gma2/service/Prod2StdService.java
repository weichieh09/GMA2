package com.wcc.gma2.service;

import com.wcc.gma2.domain.Prod2Std;
import com.wcc.gma2.repository.Prod2StdRepository;
import com.wcc.gma2.service.dto.Prod2StdDTO;
import com.wcc.gma2.service.mapper.Prod2StdMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Prod2Std}.
 */
@Service
@Transactional
public class Prod2StdService {

    private final Logger log = LoggerFactory.getLogger(Prod2StdService.class);

    private final Prod2StdRepository prod2StdRepository;

    private final Prod2StdMapper prod2StdMapper;

    public Prod2StdService(Prod2StdRepository prod2StdRepository, Prod2StdMapper prod2StdMapper) {
        this.prod2StdRepository = prod2StdRepository;
        this.prod2StdMapper = prod2StdMapper;
    }

    /**
     * Save a prod2Std.
     *
     * @param prod2StdDTO the entity to save.
     * @return the persisted entity.
     */
    public Prod2StdDTO save(Prod2StdDTO prod2StdDTO) {
        log.debug("Request to save Prod2Std : {}", prod2StdDTO);
        Prod2Std prod2Std = prod2StdMapper.toEntity(prod2StdDTO);
        prod2Std = prod2StdRepository.save(prod2Std);
        return prod2StdMapper.toDto(prod2Std);
    }

    /**
     * Update a prod2Std.
     *
     * @param prod2StdDTO the entity to save.
     * @return the persisted entity.
     */
    public Prod2StdDTO update(Prod2StdDTO prod2StdDTO) {
        log.debug("Request to update Prod2Std : {}", prod2StdDTO);
        Prod2Std prod2Std = prod2StdMapper.toEntity(prod2StdDTO);
        prod2Std = prod2StdRepository.save(prod2Std);
        return prod2StdMapper.toDto(prod2Std);
    }

    /**
     * Partially update a prod2Std.
     *
     * @param prod2StdDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Prod2StdDTO> partialUpdate(Prod2StdDTO prod2StdDTO) {
        log.debug("Request to partially update Prod2Std : {}", prod2StdDTO);

        return prod2StdRepository
            .findById(prod2StdDTO.getId())
            .map(existingProd2Std -> {
                prod2StdMapper.partialUpdate(existingProd2Std, prod2StdDTO);

                return existingProd2Std;
            })
            .map(prod2StdRepository::save)
            .map(prod2StdMapper::toDto);
    }

    /**
     * Get all the prod2Stds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Prod2StdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Prod2Stds");
        return prod2StdRepository.findAll(pageable).map(prod2StdMapper::toDto);
    }

    /**
     * Get one prod2Std by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Prod2StdDTO> findOne(Long id) {
        log.debug("Request to get Prod2Std : {}", id);
        return prod2StdRepository.findById(id).map(prod2StdMapper::toDto);
    }

    /**
     * Delete the prod2Std by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Prod2Std : {}", id);
        prod2StdRepository.deleteById(id);
    }
}
