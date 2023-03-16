package com.wcc.gma2.service;

import com.wcc.gma2.domain.StsDesc;
import com.wcc.gma2.repository.StsDescRepository;
import com.wcc.gma2.service.dto.StsDescDTO;
import com.wcc.gma2.service.mapper.StsDescMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link StsDesc}.
 */
@Service
@Transactional
public class StsDescService {

    private final Logger log = LoggerFactory.getLogger(StsDescService.class);

    private final StsDescRepository stsDescRepository;

    private final StsDescMapper stsDescMapper;

    public StsDescService(StsDescRepository stsDescRepository, StsDescMapper stsDescMapper) {
        this.stsDescRepository = stsDescRepository;
        this.stsDescMapper = stsDescMapper;
    }

    /**
     * Save a stsDesc.
     *
     * @param stsDescDTO the entity to save.
     * @return the persisted entity.
     */
    public StsDescDTO save(StsDescDTO stsDescDTO) {
        log.debug("Request to save StsDesc : {}", stsDescDTO);
        StsDesc stsDesc = stsDescMapper.toEntity(stsDescDTO);
        stsDesc = stsDescRepository.save(stsDesc);
        return stsDescMapper.toDto(stsDesc);
    }

    /**
     * Update a stsDesc.
     *
     * @param stsDescDTO the entity to save.
     * @return the persisted entity.
     */
    public StsDescDTO update(StsDescDTO stsDescDTO) {
        log.debug("Request to update StsDesc : {}", stsDescDTO);
        StsDesc stsDesc = stsDescMapper.toEntity(stsDescDTO);
        stsDesc = stsDescRepository.save(stsDesc);
        return stsDescMapper.toDto(stsDesc);
    }

    /**
     * Partially update a stsDesc.
     *
     * @param stsDescDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<StsDescDTO> partialUpdate(StsDescDTO stsDescDTO) {
        log.debug("Request to partially update StsDesc : {}", stsDescDTO);

        return stsDescRepository
            .findById(stsDescDTO.getId())
            .map(existingStsDesc -> {
                stsDescMapper.partialUpdate(existingStsDesc, stsDescDTO);

                return existingStsDesc;
            })
            .map(stsDescRepository::save)
            .map(stsDescMapper::toDto);
    }

    /**
     * Get all the stsDescs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<StsDescDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StsDescs");
        return stsDescRepository.findAll(pageable).map(stsDescMapper::toDto);
    }

    /**
     * Get one stsDesc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StsDescDTO> findOne(Long id) {
        log.debug("Request to get StsDesc : {}", id);
        return stsDescRepository.findById(id).map(stsDescMapper::toDto);
    }

    /**
     * Delete the stsDesc by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete StsDesc : {}", id);
        stsDescRepository.deleteById(id);
    }
}
