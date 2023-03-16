package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.StsDesc;
import com.wcc.gma2.repository.StsDescRepository;
import com.wcc.gma2.service.criteria.StsDescCriteria;
import com.wcc.gma2.service.dto.StsDescDTO;
import com.wcc.gma2.service.mapper.StsDescMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link StsDesc} entities in the database.
 * The main input is a {@link StsDescCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StsDescDTO} or a {@link Page} of {@link StsDescDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StsDescQueryService extends QueryService<StsDesc> {

    private final Logger log = LoggerFactory.getLogger(StsDescQueryService.class);

    private final StsDescRepository stsDescRepository;

    private final StsDescMapper stsDescMapper;

    public StsDescQueryService(StsDescRepository stsDescRepository, StsDescMapper stsDescMapper) {
        this.stsDescRepository = stsDescRepository;
        this.stsDescMapper = stsDescMapper;
    }

    /**
     * Return a {@link List} of {@link StsDescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StsDescDTO> findByCriteria(StsDescCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<StsDesc> specification = createSpecification(criteria);
        return stsDescMapper.toDto(stsDescRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StsDescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StsDescDTO> findByCriteria(StsDescCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<StsDesc> specification = createSpecification(criteria);
        return stsDescRepository.findAll(specification, page).map(stsDescMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StsDescCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<StsDesc> specification = createSpecification(criteria);
        return stsDescRepository.count(specification);
    }

    /**
     * Function to convert {@link StsDescCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<StsDesc> createSpecification(StsDescCriteria criteria) {
        Specification<StsDesc> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), StsDesc_.id));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), StsDesc_.stsCd));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), StsDesc_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), StsDesc_.lstMtnDt));
            }
        }
        return specification;
    }
}
