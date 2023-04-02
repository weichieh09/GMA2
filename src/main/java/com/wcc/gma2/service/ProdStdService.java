package com.wcc.gma2.service;

import com.wcc.gma2.domain.ProdStd;
import com.wcc.gma2.repository.ProdStdRepository;
import com.wcc.gma2.service.dto.ProdStdDTO;
import com.wcc.gma2.service.mapper.ProdStdMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ProdStd}.
 */
@Service
@Transactional
public class ProdStdService {

    private final Logger log = LoggerFactory.getLogger(ProdStdService.class);

    private final ProdStdRepository prodStdRepository;

    private final ProdStdMapper prodStdMapper;

    public ProdStdService(ProdStdRepository prodStdRepository, ProdStdMapper prodStdMapper) {
        this.prodStdRepository = prodStdRepository;
        this.prodStdMapper = prodStdMapper;
    }

    /**
     * Save a prodStd.
     *
     * @param prodStdDTO the entity to save.
     * @return the persisted entity.
     */
    public ProdStdDTO save(ProdStdDTO prodStdDTO) {
        log.debug("Request to save ProdStd : {}", prodStdDTO);
        ProdStd prodStd = prodStdMapper.toEntity(prodStdDTO);
        prodStd = prodStdRepository.save(prodStd);
        return prodStdMapper.toDto(prodStd);
    }

    /**
     * Update a prodStd.
     *
     * @param prodStdDTO the entity to save.
     * @return the persisted entity.
     */
    public ProdStdDTO update(ProdStdDTO prodStdDTO) {
        log.debug("Request to update ProdStd : {}", prodStdDTO);
        ProdStd prodStd = prodStdMapper.toEntity(prodStdDTO);
        prodStd = prodStdRepository.save(prodStd);
        return prodStdMapper.toDto(prodStd);
    }

    /**
     * Partially update a prodStd.
     *
     * @param prodStdDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ProdStdDTO> partialUpdate(ProdStdDTO prodStdDTO) {
        log.debug("Request to partially update ProdStd : {}", prodStdDTO);

        return prodStdRepository
            .findById(prodStdDTO.getId())
            .map(existingProdStd -> {
                prodStdMapper.partialUpdate(existingProdStd, prodStdDTO);

                return existingProdStd;
            })
            .map(prodStdRepository::save)
            .map(prodStdMapper::toDto);
    }

    /**
     * Get all the prodStds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProdStdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProdStds");
        return prodStdRepository.findAll(pageable).map(prodStdMapper::toDto);
    }

    /**
     * Get one prodStd by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProdStdDTO> findOne(Long id) {
        log.debug("Request to get ProdStd : {}", id);
        return prodStdRepository.findById(id).map(prodStdMapper::toDto);
    }

    /**
     * Delete the prodStd by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProdStd : {}", id);
        prodStdRepository.deleteById(id);
    }
}
