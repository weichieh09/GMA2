package com.wcc.gma2.service;

import com.wcc.gma2.domain.CountryStd;
import com.wcc.gma2.repository.CountryStdRepository;
import com.wcc.gma2.service.dto.CountryStdDTO;
import com.wcc.gma2.service.mapper.CountryStdMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CountryStd}.
 */
@Service
@Transactional
public class CountryStdService {

    private final Logger log = LoggerFactory.getLogger(CountryStdService.class);

    private final CountryStdRepository countryStdRepository;

    private final CountryStdMapper countryStdMapper;

    public CountryStdService(CountryStdRepository countryStdRepository, CountryStdMapper countryStdMapper) {
        this.countryStdRepository = countryStdRepository;
        this.countryStdMapper = countryStdMapper;
    }

    /**
     * Save a countryStd.
     *
     * @param countryStdDTO the entity to save.
     * @return the persisted entity.
     */
    public CountryStdDTO save(CountryStdDTO countryStdDTO) {
        log.debug("Request to save CountryStd : {}", countryStdDTO);
        CountryStd countryStd = countryStdMapper.toEntity(countryStdDTO);
        countryStd = countryStdRepository.save(countryStd);
        return countryStdMapper.toDto(countryStd);
    }

    /**
     * Update a countryStd.
     *
     * @param countryStdDTO the entity to save.
     * @return the persisted entity.
     */
    public CountryStdDTO update(CountryStdDTO countryStdDTO) {
        log.debug("Request to update CountryStd : {}", countryStdDTO);
        CountryStd countryStd = countryStdMapper.toEntity(countryStdDTO);
        countryStd = countryStdRepository.save(countryStd);
        return countryStdMapper.toDto(countryStd);
    }

    /**
     * Partially update a countryStd.
     *
     * @param countryStdDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CountryStdDTO> partialUpdate(CountryStdDTO countryStdDTO) {
        log.debug("Request to partially update CountryStd : {}", countryStdDTO);

        return countryStdRepository
            .findById(countryStdDTO.getId())
            .map(existingCountryStd -> {
                countryStdMapper.partialUpdate(existingCountryStd, countryStdDTO);

                return existingCountryStd;
            })
            .map(countryStdRepository::save)
            .map(countryStdMapper::toDto);
    }

    /**
     * Get all the countryStds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CountryStdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CountryStds");
        return countryStdRepository.findAll(pageable).map(countryStdMapper::toDto);
    }

    /**
     * Get one countryStd by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CountryStdDTO> findOne(Long id) {
        log.debug("Request to get CountryStd : {}", id);
        return countryStdRepository.findById(id).map(countryStdMapper::toDto);
    }

    /**
     * Delete the countryStd by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CountryStd : {}", id);
        countryStdRepository.deleteById(id);
    }
}
