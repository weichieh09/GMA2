package com.wcc.gma2.service;

import com.wcc.gma2.domain.ProdFee;
import com.wcc.gma2.repository.ProdFeeRepository;
import com.wcc.gma2.service.dto.ProdFeeDTO;
import com.wcc.gma2.service.mapper.ProdFeeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ProdFee}.
 */
@Service
@Transactional
public class ProdFeeService {

    private final Logger log = LoggerFactory.getLogger(ProdFeeService.class);

    private final ProdFeeRepository prodFeeRepository;

    private final ProdFeeMapper prodFeeMapper;

    public ProdFeeService(ProdFeeRepository prodFeeRepository, ProdFeeMapper prodFeeMapper) {
        this.prodFeeRepository = prodFeeRepository;
        this.prodFeeMapper = prodFeeMapper;
    }

    /**
     * Save a prodFee.
     *
     * @param prodFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public ProdFeeDTO save(ProdFeeDTO prodFeeDTO) {
        log.debug("Request to save ProdFee : {}", prodFeeDTO);
        ProdFee prodFee = prodFeeMapper.toEntity(prodFeeDTO);
        prodFee = prodFeeRepository.save(prodFee);
        return prodFeeMapper.toDto(prodFee);
    }

    /**
     * Update a prodFee.
     *
     * @param prodFeeDTO the entity to save.
     * @return the persisted entity.
     */
    public ProdFeeDTO update(ProdFeeDTO prodFeeDTO) {
        log.debug("Request to update ProdFee : {}", prodFeeDTO);
        ProdFee prodFee = prodFeeMapper.toEntity(prodFeeDTO);
        prodFee = prodFeeRepository.save(prodFee);
        return prodFeeMapper.toDto(prodFee);
    }

    /**
     * Partially update a prodFee.
     *
     * @param prodFeeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ProdFeeDTO> partialUpdate(ProdFeeDTO prodFeeDTO) {
        log.debug("Request to partially update ProdFee : {}", prodFeeDTO);

        return prodFeeRepository
            .findById(prodFeeDTO.getId())
            .map(existingProdFee -> {
                prodFeeMapper.partialUpdate(existingProdFee, prodFeeDTO);

                return existingProdFee;
            })
            .map(prodFeeRepository::save)
            .map(prodFeeMapper::toDto);
    }

    /**
     * Get all the prodFees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProdFeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProdFees");
        return prodFeeRepository.findAll(pageable).map(prodFeeMapper::toDto);
    }

    /**
     * Get one prodFee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProdFeeDTO> findOne(Long id) {
        log.debug("Request to get ProdFee : {}", id);
        return prodFeeRepository.findById(id).map(prodFeeMapper::toDto);
    }

    /**
     * Delete the prodFee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProdFee : {}", id);
        prodFeeRepository.deleteById(id);
    }
}
