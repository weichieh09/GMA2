package com.wcc.gma2.service;

import com.wcc.gma2.domain.CerfImg;
import com.wcc.gma2.repository.CerfImgRepository;
import com.wcc.gma2.service.dto.CerfImgDTO;
import com.wcc.gma2.service.mapper.CerfImgMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CerfImg}.
 */
@Service
@Transactional
public class CerfImgService {

    private final Logger log = LoggerFactory.getLogger(CerfImgService.class);

    private final CerfImgRepository cerfImgRepository;

    private final CerfImgMapper cerfImgMapper;

    public CerfImgService(CerfImgRepository cerfImgRepository, CerfImgMapper cerfImgMapper) {
        this.cerfImgRepository = cerfImgRepository;
        this.cerfImgMapper = cerfImgMapper;
    }

    /**
     * Save a cerfImg.
     *
     * @param cerfImgDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfImgDTO save(CerfImgDTO cerfImgDTO) {
        log.debug("Request to save CerfImg : {}", cerfImgDTO);
        CerfImg cerfImg = cerfImgMapper.toEntity(cerfImgDTO);
        cerfImg = cerfImgRepository.save(cerfImg);
        return cerfImgMapper.toDto(cerfImg);
    }

    /**
     * Update a cerfImg.
     *
     * @param cerfImgDTO the entity to save.
     * @return the persisted entity.
     */
    public CerfImgDTO update(CerfImgDTO cerfImgDTO) {
        log.debug("Request to update CerfImg : {}", cerfImgDTO);
        CerfImg cerfImg = cerfImgMapper.toEntity(cerfImgDTO);
        cerfImg = cerfImgRepository.save(cerfImg);
        return cerfImgMapper.toDto(cerfImg);
    }

    /**
     * Partially update a cerfImg.
     *
     * @param cerfImgDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CerfImgDTO> partialUpdate(CerfImgDTO cerfImgDTO) {
        log.debug("Request to partially update CerfImg : {}", cerfImgDTO);

        return cerfImgRepository
            .findById(cerfImgDTO.getId())
            .map(existingCerfImg -> {
                cerfImgMapper.partialUpdate(existingCerfImg, cerfImgDTO);

                return existingCerfImg;
            })
            .map(cerfImgRepository::save)
            .map(cerfImgMapper::toDto);
    }

    /**
     * Get all the cerfImgs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfImgDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CerfImgs");
        return cerfImgRepository.findAll(pageable).map(cerfImgMapper::toDto);
    }

    /**
     * Get one cerfImg by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CerfImgDTO> findOne(Long id) {
        log.debug("Request to get CerfImg : {}", id);
        return cerfImgRepository.findById(id).map(cerfImgMapper::toDto);
    }

    /**
     * Delete the cerfImg by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CerfImg : {}", id);
        cerfImgRepository.deleteById(id);
    }
}
