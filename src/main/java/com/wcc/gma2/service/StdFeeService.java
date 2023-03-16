package com.wcc.gma2.service;

import com.wcc.gma2.domain.StdFee;
import com.wcc.gma2.repository.StdFeeRepository;
import com.wcc.gma2.service.dto.StdFeeDTO;
import com.wcc.gma2.service.mapper.StdFeeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link StdFee}.
 */
@Service
@Transactional
public class StdFeeService {

    private final Logger log = LoggerFactory.getLogger(StdFeeService.class);

    private final StdFeeRepository stdFeeRepository;

    private final StdFeeMapper stdFeeMapper;

    public StdFeeService(StdFeeRepository stdFeeRepository, StdFeeMapper stdFeeMapper) {
        this.stdFeeRepository = stdFeeRepository;
        this.stdFeeMapper = stdFeeMapper;
    }

    /**
     * Save a stdFee.
     *
     * @param stdFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public StdFeeDTO save(StdFeeDTO stdFeeDTO) {
        log.debug("Request to save StdFee : {}", stdFeeDTO);
        StdFee stdFee = stdFeeMapper.toEntity(stdFeeDTO);
        stdFee = stdFeeRepository.save(stdFee);
        return stdFeeMapper.toDto(stdFee);
    }

    /**
     * Update a stdFee.
     *
     * @param stdFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public StdFeeDTO update(StdFeeDTO stdFeeDTO) {
        log.debug("Request to update StdFee : {}", stdFeeDTO);
        StdFee stdFee = stdFeeMapper.toEntity(stdFeeDTO);
        stdFee = stdFeeRepository.save(stdFee);
        return stdFeeMapper.toDto(stdFee);
    }

    /**
     * Partially update a stdFee.
     *
     * @param stdFeeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<StdFeeDTO> partialUpdate(StdFeeDTO stdFeeDTO) {
        log.debug("Request to partially update StdFee : {}", stdFeeDTO);

        return stdFeeRepository
            .findById(stdFeeDTO.getId())
            .map(existingStdFee -> {
                stdFeeMapper.partialUpdate(existingStdFee, stdFeeDTO);

                return existingStdFee;
            })
            .map(stdFeeRepository::save)
            .map(stdFeeMapper::toDto);
    }

    /**
     * Get all the stdFees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<StdFeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StdFees");
        return stdFeeRepository.findAll(pageable).map(stdFeeMapper::toDto);
    }

    /**
     * Get one stdFee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StdFeeDTO> findOne(Long id) {
        log.debug("Request to get StdFee : {}", id);
        return stdFeeRepository.findById(id).map(stdFeeMapper::toDto);
    }

    /**
     * Delete the stdFee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete StdFee : {}", id);
        stdFeeRepository.deleteById(id);
    }
}
