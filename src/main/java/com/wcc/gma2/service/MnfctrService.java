package com.wcc.gma2.service;

import com.wcc.gma2.domain.Mnfctr;
import com.wcc.gma2.repository.MnfctrRepository;
import com.wcc.gma2.service.dto.MnfctrDTO;
import com.wcc.gma2.service.mapper.MnfctrMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Mnfctr}.
 */
@Service
@Transactional
public class MnfctrService {

    private final Logger log = LoggerFactory.getLogger(MnfctrService.class);

    private final MnfctrRepository mnfctrRepository;

    private final MnfctrMapper mnfctrMapper;

    public MnfctrService(MnfctrRepository mnfctrRepository, MnfctrMapper mnfctrMapper) {
        this.mnfctrRepository = mnfctrRepository;
        this.mnfctrMapper = mnfctrMapper;
    }

    /**
     * Save a mnfctr.
     *
     * @param mnfctrDTO the entity to save.
     * @return the persisted entity.
     */
    public MnfctrDTO save(MnfctrDTO mnfctrDTO) {
        log.debug("Request to save Mnfctr : {}", mnfctrDTO);
        Mnfctr mnfctr = mnfctrMapper.toEntity(mnfctrDTO);
        mnfctr = mnfctrRepository.save(mnfctr);
        return mnfctrMapper.toDto(mnfctr);
    }

    /**
     * Update a mnfctr.
     *
     * @param mnfctrDTO the entity to save.
     * @return the persisted entity.
     */
    public MnfctrDTO update(MnfctrDTO mnfctrDTO) {
        log.debug("Request to update Mnfctr : {}", mnfctrDTO);
        Mnfctr mnfctr = mnfctrMapper.toEntity(mnfctrDTO);
        mnfctr = mnfctrRepository.save(mnfctr);
        return mnfctrMapper.toDto(mnfctr);
    }

    /**
     * Partially update a mnfctr.
     *
     * @param mnfctrDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MnfctrDTO> partialUpdate(MnfctrDTO mnfctrDTO) {
        log.debug("Request to partially update Mnfctr : {}", mnfctrDTO);

        return mnfctrRepository
            .findById(mnfctrDTO.getId())
            .map(existingMnfctr -> {
                mnfctrMapper.partialUpdate(existingMnfctr, mnfctrDTO);

                return existingMnfctr;
            })
            .map(mnfctrRepository::save)
            .map(mnfctrMapper::toDto);
    }

    /**
     * Get all the mnfctrs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MnfctrDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Mnfctrs");
        return mnfctrRepository.findAll(pageable).map(mnfctrMapper::toDto);
    }

    /**
     * Get one mnfctr by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MnfctrDTO> findOne(Long id) {
        log.debug("Request to get Mnfctr : {}", id);
        return mnfctrRepository.findById(id).map(mnfctrMapper::toDto);
    }

    /**
     * Delete the mnfctr by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Mnfctr : {}", id);
        mnfctrRepository.deleteById(id);
    }
}
