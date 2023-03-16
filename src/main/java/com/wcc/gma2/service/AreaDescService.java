package com.wcc.gma2.service;

import com.wcc.gma2.domain.AreaDesc;
import com.wcc.gma2.repository.AreaDescRepository;
import com.wcc.gma2.service.dto.AreaDescDTO;
import com.wcc.gma2.service.mapper.AreaDescMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link AreaDesc}.
 */
@Service
@Transactional
public class AreaDescService {

    private final Logger log = LoggerFactory.getLogger(AreaDescService.class);

    private final AreaDescRepository areaDescRepository;

    private final AreaDescMapper areaDescMapper;

    public AreaDescService(AreaDescRepository areaDescRepository, AreaDescMapper areaDescMapper) {
        this.areaDescRepository = areaDescRepository;
        this.areaDescMapper = areaDescMapper;
    }

    /**
     * Save a areaDesc.
     *
     * @param areaDescDTO the entity to save.
     * @return the persisted entity.
     */
    public AreaDescDTO save(AreaDescDTO areaDescDTO) {
        log.debug("Request to save AreaDesc : {}", areaDescDTO);
        AreaDesc areaDesc = areaDescMapper.toEntity(areaDescDTO);
        areaDesc = areaDescRepository.save(areaDesc);
        return areaDescMapper.toDto(areaDesc);
    }

    /**
     * Update a areaDesc.
     *
     * @param areaDescDTO the entity to save.
     * @return the persisted entity.
     */
    public AreaDescDTO update(AreaDescDTO areaDescDTO) {
        log.debug("Request to update AreaDesc : {}", areaDescDTO);
        AreaDesc areaDesc = areaDescMapper.toEntity(areaDescDTO);
        areaDesc = areaDescRepository.save(areaDesc);
        return areaDescMapper.toDto(areaDesc);
    }

    /**
     * Partially update a areaDesc.
     *
     * @param areaDescDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<AreaDescDTO> partialUpdate(AreaDescDTO areaDescDTO) {
        log.debug("Request to partially update AreaDesc : {}", areaDescDTO);

        return areaDescRepository
            .findById(areaDescDTO.getId())
            .map(existingAreaDesc -> {
                areaDescMapper.partialUpdate(existingAreaDesc, areaDescDTO);

                return existingAreaDesc;
            })
            .map(areaDescRepository::save)
            .map(areaDescMapper::toDto);
    }

    /**
     * Get all the areaDescs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AreaDescDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AreaDescs");
        return areaDescRepository.findAll(pageable).map(areaDescMapper::toDto);
    }

    /**
     * Get one areaDesc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AreaDescDTO> findOne(Long id) {
        log.debug("Request to get AreaDesc : {}", id);
        return areaDescRepository.findById(id).map(areaDescMapper::toDto);
    }

    /**
     * Delete the areaDesc by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AreaDesc : {}", id);
        areaDescRepository.deleteById(id);
    }
}
