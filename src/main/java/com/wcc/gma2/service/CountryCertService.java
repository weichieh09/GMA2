package com.wcc.gma2.service;

import com.wcc.gma2.domain.CountryCert;
import com.wcc.gma2.repository.CountryCertRepository;
import com.wcc.gma2.service.dto.CountryCertDTO;
import com.wcc.gma2.service.mapper.CountryCertMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CountryCert}.
 */
@Service
@Transactional
public class CountryCertService {

    private final Logger log = LoggerFactory.getLogger(CountryCertService.class);

    private final CountryCertRepository countryCertRepository;

    private final CountryCertMapper countryCertMapper;

    public CountryCertService(CountryCertRepository countryCertRepository, CountryCertMapper countryCertMapper) {
        this.countryCertRepository = countryCertRepository;
        this.countryCertMapper = countryCertMapper;
    }

    /**
     * Save a countryCert.
     *
     * @param countryCertDTO the entity to save.
     * @return the persisted entity.
     */
    public CountryCertDTO save(CountryCertDTO countryCertDTO) {
        log.debug("Request to save CountryCert : {}", countryCertDTO);
        CountryCert countryCert = countryCertMapper.toEntity(countryCertDTO);
        countryCert = countryCertRepository.save(countryCert);
        return countryCertMapper.toDto(countryCert);
    }

    /**
     * Update a countryCert.
     *
     * @param countryCertDTO the entity to save.
     * @return the persisted entity.
     */
    public CountryCertDTO update(CountryCertDTO countryCertDTO) {
        log.debug("Request to update CountryCert : {}", countryCertDTO);
        CountryCert countryCert = countryCertMapper.toEntity(countryCertDTO);
        countryCert = countryCertRepository.save(countryCert);
        return countryCertMapper.toDto(countryCert);
    }

    /**
     * Partially update a countryCert.
     *
     * @param countryCertDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CountryCertDTO> partialUpdate(CountryCertDTO countryCertDTO) {
        log.debug("Request to partially update CountryCert : {}", countryCertDTO);

        return countryCertRepository
            .findById(countryCertDTO.getId())
            .map(existingCountryCert -> {
                countryCertMapper.partialUpdate(existingCountryCert, countryCertDTO);

                return existingCountryCert;
            })
            .map(countryCertRepository::save)
            .map(countryCertMapper::toDto);
    }

    /**
     * Get all the countryCerts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CountryCertDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CountryCerts");
        return countryCertRepository.findAll(pageable).map(countryCertMapper::toDto);
    }

    /**
     * Get one countryCert by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CountryCertDTO> findOne(Long id) {
        log.debug("Request to get CountryCert : {}", id);
        return countryCertRepository.findById(id).map(countryCertMapper::toDto);
    }

    /**
     * Delete the countryCert by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CountryCert : {}", id);
        countryCertRepository.deleteById(id);
    }
}
