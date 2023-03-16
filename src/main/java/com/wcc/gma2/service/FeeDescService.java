package com.wcc.gma2.service;

import com.wcc.gma2.domain.FeeDesc;
import com.wcc.gma2.repository.FeeDescRepository;
import com.wcc.gma2.service.dto.FeeDescDTO;
import com.wcc.gma2.service.mapper.FeeDescMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link FeeDesc}.
 */
@Service
@Transactional
public class FeeDescService {

    private final Logger log = LoggerFactory.getLogger(FeeDescService.class);

    private final FeeDescRepository feeDescRepository;

    private final FeeDescMapper feeDescMapper;

    public FeeDescService(FeeDescRepository feeDescRepository, FeeDescMapper feeDescMapper) {
        this.feeDescRepository = feeDescRepository;
        this.feeDescMapper = feeDescMapper;
    }

    /**
     * Save a feeDesc.
     *
     * @param feeDescDTO the entity to save.
     * @return the persisted entity.
     */
    public FeeDescDTO save(FeeDescDTO feeDescDTO) {
        log.debug("Request to save FeeDesc : {}", feeDescDTO);
        FeeDesc feeDesc = feeDescMapper.toEntity(feeDescDTO);
        feeDesc = feeDescRepository.save(feeDesc);
        return feeDescMapper.toDto(feeDesc);
    }

    /**
     * Update a feeDesc.
     *
     * @param feeDescDTO the entity to save.
     * @return the persisted entity.
     */
    public FeeDescDTO update(FeeDescDTO feeDescDTO) {
        log.debug("Request to update FeeDesc : {}", feeDescDTO);
        FeeDesc feeDesc = feeDescMapper.toEntity(feeDescDTO);
        feeDesc = feeDescRepository.save(feeDesc);
        return feeDescMapper.toDto(feeDesc);
    }

    /**
     * Partially update a feeDesc.
     *
     * @param feeDescDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FeeDescDTO> partialUpdate(FeeDescDTO feeDescDTO) {
        log.debug("Request to partially update FeeDesc : {}", feeDescDTO);

        return feeDescRepository
            .findById(feeDescDTO.getId())
            .map(existingFeeDesc -> {
                feeDescMapper.partialUpdate(existingFeeDesc, feeDescDTO);

                return existingFeeDesc;
            })
            .map(feeDescRepository::save)
            .map(feeDescMapper::toDto);
    }

    /**
     * Get all the feeDescs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FeeDescDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FeeDescs");
        return feeDescRepository.findAll(pageable).map(feeDescMapper::toDto);
    }

    /**
     * Get one feeDesc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FeeDescDTO> findOne(Long id) {
        log.debug("Request to get FeeDesc : {}", id);
        return feeDescRepository.findById(id).map(feeDescMapper::toDto);
    }

    /**
     * Delete the feeDesc by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete FeeDesc : {}", id);
        feeDescRepository.deleteById(id);
    }
}
