package com.wcc.gma2.service;

import com.wcc.gma2.domain.CerfStd;
import com.wcc.gma2.repository.CerfStdRepository;
import com.wcc.gma2.service.dto.CerfStdDTO;
import com.wcc.gma2.service.mapper.CerfStdMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CerfStd}.
 */
@Service
@Transactional
public class CerfStdService {

    private final Logger log = LoggerFactory.getLogger(CerfStdService.class);

    private final CerfStdRepository cerfStdRepository;

    private final CerfStdMapper cerfStdMapper;

    public CerfStdService(CerfStdRepository cerfStdRepository, CerfStdMapper cerfStdMapper) {
        this.cerfStdRepository = cerfStdRepository;
        this.cerfStdMapper = cerfStdMapper;
    }

    /**
     * Save a cerfStd.
     *
     * @param cerfStdDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfStdDTO save(CerfStdDTO cerfStdDTO) {
        log.debug("Request to save CerfStd : {}", cerfStdDTO);
        CerfStd cerfStd = cerfStdMapper.toEntity(cerfStdDTO);
        cerfStd = cerfStdRepository.save(cerfStd);
        return cerfStdMapper.toDto(cerfStd);
    }

    /**
     * Update a cerfStd.
     *
     * @param cerfStdDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfStdDTO update(CerfStdDTO cerfStdDTO) {
        log.debug("Request to update CerfStd : {}", cerfStdDTO);
        CerfStd cerfStd = cerfStdMapper.toEntity(cerfStdDTO);
        cerfStd = cerfStdRepository.save(cerfStd);
        return cerfStdMapper.toDto(cerfStd);
    }

    /**
     * Partially update a cerfStd.
     *
     * @param cerfStdDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CerfStdDTO> partialUpdate(CerfStdDTO cerfStdDTO) {
        log.debug("Request to partially update CerfStd : {}", cerfStdDTO);

        return cerfStdRepository
            .findById(cerfStdDTO.getId())
            .map(existingCerfStd -> {
                cerfStdMapper.partialUpdate(existingCerfStd, cerfStdDTO);

                return existingCerfStd;
            })
            .map(cerfStdRepository::save)
            .map(cerfStdMapper::toDto);
    }

    /**
     * Get all the cerfStds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfStdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CerfStds");
        return cerfStdRepository.findAll(pageable).map(cerfStdMapper::toDto);
    }

    /**
     * Get one cerfStd by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CerfStdDTO> findOne(Long id) {
        log.debug("Request to get CerfStd : {}", id);
        return cerfStdRepository.findById(id).map(cerfStdMapper::toDto);
    }

    /**
     * Delete the cerfStd by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CerfStd : {}", id);
        cerfStdRepository.deleteById(id);
    }
}
