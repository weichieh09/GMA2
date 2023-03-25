package com.wcc.gma2.service;

import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.repository.MarkRepository;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.mapper.MarkMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Mark}.
 */
@Service
@Transactional
public class MarkService {

    private final Logger log = LoggerFactory.getLogger(MarkService.class);

    private final MarkRepository markRepository;

    private final MarkMapper markMapper;

    public MarkService(MarkRepository markRepository, MarkMapper markMapper) {
        this.markRepository = markRepository;
        this.markMapper = markMapper;
    }

    /**
     * Save a mark.
     *
     * @param markDTO the entity to save.
     * @return the persisted entity.
     */
    public MarkDTO save(MarkDTO markDTO) {
        log.debug("Request to save Mark : {}", markDTO);
        Mark mark = markMapper.toEntity(markDTO);
        mark = markRepository.save(mark);
        return markMapper.toDto(mark);
    }

    /**
     * Update a mark.
     *
     * @param markDTO the entity to save.
     * @return the persisted entity.
     */
    public MarkDTO update(MarkDTO markDTO) {
        log.debug("Request to update Mark : {}", markDTO);
        Mark mark = markMapper.toEntity(markDTO);
        mark = markRepository.save(mark);
        return markMapper.toDto(mark);
    }

    /**
     * Partially update a mark.
     *
     * @param markDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MarkDTO> partialUpdate(MarkDTO markDTO) {
        log.debug("Request to partially update Mark : {}", markDTO);

        return markRepository
            .findById(markDTO.getId())
            .map(existingMark -> {
                markMapper.partialUpdate(existingMark, markDTO);

                return existingMark;
            })
            .map(markRepository::save)
            .map(markMapper::toDto);
    }

    /**
     * Get all the marks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MarkDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Marks");
        return markRepository.findAll(pageable).map(markMapper::toDto);
    }

    /**
     * Get one mark by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MarkDTO> findOne(Long id) {
        log.debug("Request to get Mark : {}", id);
        return markRepository.findById(id).map(markMapper::toDto);
    }

    /**
     * Delete the mark by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Mark : {}", id);
        markRepository.deleteById(id);
    }
}
