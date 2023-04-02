package com.wcc.gma2.service;

import com.wcc.gma2.domain.FeeProdCerfCompany;
import com.wcc.gma2.repository.FeeProdCerfCompanyRepository;
import com.wcc.gma2.service.dto.FeeProdCerfCompanyDTO;
import com.wcc.gma2.service.mapper.FeeProdCerfCompanyMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link FeeProdCerfCompany}.
 */
@Service
@Transactional
public class FeeProdCerfCompanyService {

    private final Logger log = LoggerFactory.getLogger(FeeProdCerfCompanyService.class);

    private final FeeProdCerfCompanyRepository feeProdCerfCompanyRepository;

    private final FeeProdCerfCompanyMapper feeProdCerfCompanyMapper;

    public FeeProdCerfCompanyService(
        FeeProdCerfCompanyRepository feeProdCerfCompanyRepository,
        FeeProdCerfCompanyMapper feeProdCerfCompanyMapper
    ) {
        this.feeProdCerfCompanyRepository = feeProdCerfCompanyRepository;
        this.feeProdCerfCompanyMapper = feeProdCerfCompanyMapper;
    }

    /**
     * Save a feeProdCerfCompany.
     *
     * @param feeProdCerfCompanyDTO the entity to save.
     * @return the persisted entity.
     */
    public FeeProdCerfCompanyDTO save(FeeProdCerfCompanyDTO feeProdCerfCompanyDTO) {
        log.debug("Request to save FeeProdCerfCompany : {}", feeProdCerfCompanyDTO);
        FeeProdCerfCompany feeProdCerfCompany = feeProdCerfCompanyMapper.toEntity(feeProdCerfCompanyDTO);
        feeProdCerfCompany = feeProdCerfCompanyRepository.save(feeProdCerfCompany);
        return feeProdCerfCompanyMapper.toDto(feeProdCerfCompany);
    }

    /**
     * Update a feeProdCerfCompany.
     *
     * @param feeProdCerfCompanyDTO the entity to save.
     * @return the persisted entity.
     */
    public FeeProdCerfCompanyDTO update(FeeProdCerfCompanyDTO feeProdCerfCompanyDTO) {
        log.debug("Request to update FeeProdCerfCompany : {}", feeProdCerfCompanyDTO);
        FeeProdCerfCompany feeProdCerfCompany = feeProdCerfCompanyMapper.toEntity(feeProdCerfCompanyDTO);
        feeProdCerfCompany = feeProdCerfCompanyRepository.save(feeProdCerfCompany);
        return feeProdCerfCompanyMapper.toDto(feeProdCerfCompany);
    }

    /**
     * Partially update a feeProdCerfCompany.
     *
     * @param feeProdCerfCompanyDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FeeProdCerfCompanyDTO> partialUpdate(FeeProdCerfCompanyDTO feeProdCerfCompanyDTO) {
        log.debug("Request to partially update FeeProdCerfCompany : {}", feeProdCerfCompanyDTO);

        return feeProdCerfCompanyRepository
            .findById(feeProdCerfCompanyDTO.getId())
            .map(existingFeeProdCerfCompany -> {
                feeProdCerfCompanyMapper.partialUpdate(existingFeeProdCerfCompany, feeProdCerfCompanyDTO);

                return existingFeeProdCerfCompany;
            })
            .map(feeProdCerfCompanyRepository::save)
            .map(feeProdCerfCompanyMapper::toDto);
    }

    /**
     * Get all the feeProdCerfCompanies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FeeProdCerfCompanyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FeeProdCerfCompanies");
        return feeProdCerfCompanyRepository.findAll(pageable).map(feeProdCerfCompanyMapper::toDto);
    }

    /**
     * Get one feeProdCerfCompany by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FeeProdCerfCompanyDTO> findOne(Long id) {
        log.debug("Request to get FeeProdCerfCompany : {}", id);
        return feeProdCerfCompanyRepository.findById(id).map(feeProdCerfCompanyMapper::toDto);
    }

    /**
     * Delete the feeProdCerfCompany by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete FeeProdCerfCompany : {}", id);
        feeProdCerfCompanyRepository.deleteById(id);
    }
}
