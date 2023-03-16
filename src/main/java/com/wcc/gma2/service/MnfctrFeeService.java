package com.wcc.gma2.service;

import com.wcc.gma2.domain.MnfctrFee;
import com.wcc.gma2.repository.MnfctrFeeRepository;
import com.wcc.gma2.service.dto.MnfctrFeeDTO;
import com.wcc.gma2.service.mapper.MnfctrFeeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MnfctrFee}.
 */
@Service
@Transactional
public class MnfctrFeeService {

    private final Logger log = LoggerFactory.getLogger(MnfctrFeeService.class);

    private final MnfctrFeeRepository mnfctrFeeRepository;

    private final MnfctrFeeMapper mnfctrFeeMapper;

    public MnfctrFeeService(MnfctrFeeRepository mnfctrFeeRepository, MnfctrFeeMapper mnfctrFeeMapper) {
        this.mnfctrFeeRepository = mnfctrFeeRepository;
        this.mnfctrFeeMapper = mnfctrFeeMapper;
    }

    /**
     * Save a mnfctrFee.
     *
     * @param mnfctrFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public MnfctrFeeDTO save(MnfctrFeeDTO mnfctrFeeDTO) {
        log.debug("Request to save MnfctrFee : {}", mnfctrFeeDTO);
        MnfctrFee mnfctrFee = mnfctrFeeMapper.toEntity(mnfctrFeeDTO);
        mnfctrFee = mnfctrFeeRepository.save(mnfctrFee);
        return mnfctrFeeMapper.toDto(mnfctrFee);
    }

    /**
     * Update a mnfctrFee.
     *
     * @param mnfctrFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public MnfctrFeeDTO update(MnfctrFeeDTO mnfctrFeeDTO) {
        log.debug("Request to update MnfctrFee : {}", mnfctrFeeDTO);
        MnfctrFee mnfctrFee = mnfctrFeeMapper.toEntity(mnfctrFeeDTO);
        mnfctrFee = mnfctrFeeRepository.save(mnfctrFee);
        return mnfctrFeeMapper.toDto(mnfctrFee);
    }

    /**
     * Partially update a mnfctrFee.
     *
     * @param mnfctrFeeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MnfctrFeeDTO> partialUpdate(MnfctrFeeDTO mnfctrFeeDTO) {
        log.debug("Request to partially update MnfctrFee : {}", mnfctrFeeDTO);

        return mnfctrFeeRepository
            .findById(mnfctrFeeDTO.getId())
            .map(existingMnfctrFee -> {
                mnfctrFeeMapper.partialUpdate(existingMnfctrFee, mnfctrFeeDTO);

                return existingMnfctrFee;
            })
            .map(mnfctrFeeRepository::save)
            .map(mnfctrFeeMapper::toDto);
    }

    /**
     * Get all the mnfctrFees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MnfctrFeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MnfctrFees");
        return mnfctrFeeRepository.findAll(pageable).map(mnfctrFeeMapper::toDto);
    }

    /**
     * Get one mnfctrFee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MnfctrFeeDTO> findOne(Long id) {
        log.debug("Request to get MnfctrFee : {}", id);
        return mnfctrFeeRepository.findById(id).map(mnfctrFeeMapper::toDto);
    }

    /**
     * Delete the mnfctrFee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MnfctrFee : {}", id);
        mnfctrFeeRepository.deleteById(id);
    }
}
