package com.wcc.gma2.service;

import com.wcc.gma2.domain.CerfFee;
import com.wcc.gma2.repository.CerfFeeRepository;
import com.wcc.gma2.service.dto.CerfFeeDTO;
import com.wcc.gma2.service.mapper.CerfFeeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CerfFee}.
 */
@Service
@Transactional
public class CerfFeeService {

    private final Logger log = LoggerFactory.getLogger(CerfFeeService.class);

    private final CerfFeeRepository cerfFeeRepository;

    private final CerfFeeMapper cerfFeeMapper;

    public CerfFeeService(CerfFeeRepository cerfFeeRepository, CerfFeeMapper cerfFeeMapper) {
        this.cerfFeeRepository = cerfFeeRepository;
        this.cerfFeeMapper = cerfFeeMapper;
    }

    /**
     * Save a cerfFee.
     *
     * @param cerfFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfFeeDTO save(CerfFeeDTO cerfFeeDTO) {
        log.debug("Request to save CerfFee : {}", cerfFeeDTO);
        CerfFee cerfFee = cerfFeeMapper.toEntity(cerfFeeDTO);
        cerfFee = cerfFeeRepository.save(cerfFee);
        return cerfFeeMapper.toDto(cerfFee);
    }

    /**
     * Update a cerfFee.
     *
     * @param cerfFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfFeeDTO update(CerfFeeDTO cerfFeeDTO) {
        log.debug("Request to update CerfFee : {}", cerfFeeDTO);
        CerfFee cerfFee = cerfFeeMapper.toEntity(cerfFeeDTO);
        cerfFee = cerfFeeRepository.save(cerfFee);
        return cerfFeeMapper.toDto(cerfFee);
    }

    /**
     * Partially update a cerfFee.
     *
     * @param cerfFeeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CerfFeeDTO> partialUpdate(CerfFeeDTO cerfFeeDTO) {
        log.debug("Request to partially update CerfFee : {}", cerfFeeDTO);

        return cerfFeeRepository
            .findById(cerfFeeDTO.getId())
            .map(existingCerfFee -> {
                cerfFeeMapper.partialUpdate(existingCerfFee, cerfFeeDTO);

                return existingCerfFee;
            })
            .map(cerfFeeRepository::save)
            .map(cerfFeeMapper::toDto);
    }

    /**
     * Get all the cerfFees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfFeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CerfFees");
        return cerfFeeRepository.findAll(pageable).map(cerfFeeMapper::toDto);
    }

    /**
     * Get one cerfFee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CerfFeeDTO> findOne(Long id) {
        log.debug("Request to get CerfFee : {}", id);
        return cerfFeeRepository.findById(id).map(cerfFeeMapper::toDto);
    }

    /**
     * Delete the cerfFee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CerfFee : {}", id);
        cerfFeeRepository.deleteById(id);
    }
}
