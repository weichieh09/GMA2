package com.wcc.gma2.service;

import com.wcc.gma2.domain.Std;
import com.wcc.gma2.repository.StdRepository;
import com.wcc.gma2.service.dto.StdDTO;
import com.wcc.gma2.service.mapper.StdMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Std}.
 */
@Service
@Transactional
public class StdService {

    private final Logger log = LoggerFactory.getLogger(StdService.class);

    private final StdRepository stdRepository;

    private final StdMapper stdMapper;

    public StdService(StdRepository stdRepository, StdMapper stdMapper) {
        this.stdRepository = stdRepository;
        this.stdMapper = stdMapper;
    }

    /**
     * Save a std.
     *
     * @param stdDTO the entity to save.
     * @return the persisted entity.
     */
    public StdDTO save(StdDTO stdDTO) {
        log.debug("Request to save Std : {}", stdDTO);
        Std std = stdMapper.toEntity(stdDTO);
        std = stdRepository.save(std);
        return stdMapper.toDto(std);
    }

    /**
     * Update a std.
     *
     * @param stdDTO the entity to save.
     * @return the persisted entity.
     */
    public StdDTO update(StdDTO stdDTO) {
        log.debug("Request to update Std : {}", stdDTO);
        Std std = stdMapper.toEntity(stdDTO);
        std = stdRepository.save(std);
        return stdMapper.toDto(std);
    }

    /**
     * Partially update a std.
     *
     * @param stdDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<StdDTO> partialUpdate(StdDTO stdDTO) {
        log.debug("Request to partially update Std : {}", stdDTO);

        return stdRepository
            .findById(stdDTO.getId())
            .map(existingStd -> {
                stdMapper.partialUpdate(existingStd, stdDTO);

                return existingStd;
            })
            .map(stdRepository::save)
            .map(stdMapper::toDto);
    }

    /**
     * Get all the stds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<StdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Stds");
        return stdRepository.findAll(pageable).map(stdMapper::toDto);
    }

    /**
     * Get one std by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StdDTO> findOne(Long id) {
        log.debug("Request to get Std : {}", id);
        return stdRepository.findById(id).map(stdMapper::toDto);
    }

    /**
     * Delete the std by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Std : {}", id);
        stdRepository.deleteById(id);
    }
}
