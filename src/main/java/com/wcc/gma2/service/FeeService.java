package com.wcc.gma2.service;

import com.wcc.gma2.domain.Fee;
import com.wcc.gma2.repository.FeeRepository;
import com.wcc.gma2.service.dto.FeeDTO;
import com.wcc.gma2.service.mapper.FeeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Fee}.
 */
@Service
@Transactional
public class FeeService {

    private final Logger log = LoggerFactory.getLogger(FeeService.class);

    private final FeeRepository feeRepository;

    private final FeeMapper feeMapper;

    public FeeService(FeeRepository feeRepository, FeeMapper feeMapper) {
        this.feeRepository = feeRepository;
        this.feeMapper = feeMapper;
    }

    /**
     * Save a fee.
     *
     * @param feeDTO the entity to save.
     * @return the persisted entity.
     */
    public FeeDTO save(FeeDTO feeDTO) {
        log.debug("Request to save Fee : {}", feeDTO);
        Fee fee = feeMapper.toEntity(feeDTO);
        fee = feeRepository.save(fee);
        return feeMapper.toDto(fee);
    }

    /**
     * Update a fee.
     *
     * @param feeDTO the entity to save.
     * @return the persisted entity.
     */
    public FeeDTO update(FeeDTO feeDTO) {
        log.debug("Request to update Fee : {}", feeDTO);
        Fee fee = feeMapper.toEntity(feeDTO);
        fee = feeRepository.save(fee);
        return feeMapper.toDto(fee);
    }

    /**
     * Partially update a fee.
     *
     * @param feeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FeeDTO> partialUpdate(FeeDTO feeDTO) {
        log.debug("Request to partially update Fee : {}", feeDTO);

        return feeRepository
            .findById(feeDTO.getId())
            .map(existingFee -> {
                feeMapper.partialUpdate(existingFee, feeDTO);

                return existingFee;
            })
            .map(feeRepository::save)
            .map(feeMapper::toDto);
    }

    /**
     * Get all the fees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Fees");
        return feeRepository.findAll(pageable).map(feeMapper::toDto);
    }

    /**
     * Get one fee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FeeDTO> findOne(Long id) {
        log.debug("Request to get Fee : {}", id);
        return feeRepository.findById(id).map(feeMapper::toDto);
    }

    /**
     * Delete the fee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Fee : {}", id);
        feeRepository.deleteById(id);
    }
}
