package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Cref2Std;
import com.wcc.gma2.repository.Cref2StdRepository;
import com.wcc.gma2.service.criteria.Cref2StdCriteria;
import com.wcc.gma2.service.dto.Cref2StdDTO;
import com.wcc.gma2.service.mapper.Cref2StdMapper;
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
 * Service for executing complex queries for {@link Cref2Std} entities in the database.
 * The main input is a {@link Cref2StdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Cref2StdDTO} or a {@link Page} of {@link Cref2StdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Cref2StdQueryService extends QueryService<Cref2Std> {

    private final Logger log = LoggerFactory.getLogger(Cref2StdQueryService.class);

    private final Cref2StdRepository cref2StdRepository;

    private final Cref2StdMapper cref2StdMapper;

    public Cref2StdQueryService(Cref2StdRepository cref2StdRepository, Cref2StdMapper cref2StdMapper) {
        this.cref2StdRepository = cref2StdRepository;
        this.cref2StdMapper = cref2StdMapper;
    }

    /**
     * Return a {@link List} of {@link Cref2StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Cref2StdDTO> findByCriteria(Cref2StdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cref2Std> specification = createSpecification(criteria);
        return cref2StdMapper.toDto(cref2StdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Cref2StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Cref2StdDTO> findByCriteria(Cref2StdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cref2Std> specification = createSpecification(criteria);
        return cref2StdRepository.findAll(specification, page).map(cref2StdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Cref2StdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cref2Std> specification = createSpecification(criteria);
        return cref2StdRepository.count(specification);
    }

    /**
     * Function to convert {@link Cref2StdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cref2Std> createSpecification(Cref2StdCriteria criteria) {
        Specification<Cref2Std> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cref2Std_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), Cref2Std_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), Cref2Std_.cerfVer));
            }
            if (criteria.getAreaCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAreaCd(), Cref2Std_.areaCd));
            }
            if (criteria.getApplId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApplId(), Cref2Std_.applId));
            }
            if (criteria.getCerfTag() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfTag(), Cref2Std_.cerfTag));
            }
            if (criteria.getStdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNo(), Cref2Std_.stdNo));
            }
            if (criteria.getStdVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdVer(), Cref2Std_.stdVer));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), Cref2Std_.stsCd));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Cref2Std_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Cref2Std_.lstMtnDt));
            }
        }
        return specification;
    }
}
