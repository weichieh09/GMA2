package com.wcc.gma2.service;

import com.wcc.gma2.domain.Cref2Std;
import com.wcc.gma2.repository.Cref2StdRepository;
import com.wcc.gma2.service.dto.Cref2StdDTO;
import com.wcc.gma2.service.mapper.Cref2StdMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cref2Std}.
 */
@Service
@Transactional
public class Cref2StdService {

    private final Logger log = LoggerFactory.getLogger(Cref2StdService.class);

    private final Cref2StdRepository cref2StdRepository;

    private final Cref2StdMapper cref2StdMapper;

    public Cref2StdService(Cref2StdRepository cref2StdRepository, Cref2StdMapper cref2StdMapper) {
        this.cref2StdRepository = cref2StdRepository;
        this.cref2StdMapper = cref2StdMapper;
    }

    /**
     * Save a cref2Std.
     *
     * @param cref2StdDTO the entity to save.
     * @return the persisted entity.
     */
    public Cref2StdDTO save(Cref2StdDTO cref2StdDTO) {
        log.debug("Request to save Cref2Std : {}", cref2StdDTO);
        Cref2Std cref2Std = cref2StdMapper.toEntity(cref2StdDTO);
        cref2Std = cref2StdRepository.save(cref2Std);
        return cref2StdMapper.toDto(cref2Std);
    }

    /**
     * Update a cref2Std.
     *
     * @param cref2StdDTO the entity to save.
     * @return the persisted entity.
     */
    public Cref2StdDTO update(Cref2StdDTO cref2StdDTO) {
        log.debug("Request to update Cref2Std : {}", cref2StdDTO);
        Cref2Std cref2Std = cref2StdMapper.toEntity(cref2StdDTO);
        cref2Std = cref2StdRepository.save(cref2Std);
        return cref2StdMapper.toDto(cref2Std);
    }

    /**
     * Partially update a cref2Std.
     *
     * @param cref2StdDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Cref2StdDTO> partialUpdate(Cref2StdDTO cref2StdDTO) {
        log.debug("Request to partially update Cref2Std : {}", cref2StdDTO);

        return cref2StdRepository
            .findById(cref2StdDTO.getId())
            .map(existingCref2Std -> {
                cref2StdMapper.partialUpdate(existingCref2Std, cref2StdDTO);

                return existingCref2Std;
            })
            .map(cref2StdRepository::save)
            .map(cref2StdMapper::toDto);
    }

    /**
     * Get all the cref2Stds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Cref2StdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cref2Stds");
        return cref2StdRepository.findAll(pageable).map(cref2StdMapper::toDto);
    }

    /**
     * Get one cref2Std by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cref2StdDTO> findOne(Long id) {
        log.debug("Request to get Cref2Std : {}", id);
        return cref2StdRepository.findById(id).map(cref2StdMapper::toDto);
    }

    /**
     * Delete the cref2Std by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cref2Std : {}", id);
        cref2StdRepository.deleteById(id);
    }
}
