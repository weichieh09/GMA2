package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Prod2Std;
import com.wcc.gma2.repository.Prod2StdRepository;
import com.wcc.gma2.service.criteria.Prod2StdCriteria;
import com.wcc.gma2.service.dto.Prod2StdDTO;
import com.wcc.gma2.service.mapper.Prod2StdMapper;
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
 * Service for executing complex queries for {@link Prod2Std} entities in the database.
 * The main input is a {@link Prod2StdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Prod2StdDTO} or a {@link Page} of {@link Prod2StdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Prod2StdQueryService extends QueryService<Prod2Std> {

    private final Logger log = LoggerFactory.getLogger(Prod2StdQueryService.class);

    private final Prod2StdRepository prod2StdRepository;

    private final Prod2StdMapper prod2StdMapper;

    public Prod2StdQueryService(Prod2StdRepository prod2StdRepository, Prod2StdMapper prod2StdMapper) {
        this.prod2StdRepository = prod2StdRepository;
        this.prod2StdMapper = prod2StdMapper;
    }

    /**
     * Return a {@link List} of {@link Prod2StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Prod2StdDTO> findByCriteria(Prod2StdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Prod2Std> specification = createSpecification(criteria);
        return prod2StdMapper.toDto(prod2StdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Prod2StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Prod2StdDTO> findByCriteria(Prod2StdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Prod2Std> specification = createSpecification(criteria);
        return prod2StdRepository.findAll(specification, page).map(prod2StdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Prod2StdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Prod2Std> specification = createSpecification(criteria);
        return prod2StdRepository.count(specification);
    }

    /**
     * Function to convert {@link Prod2StdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Prod2Std> createSpecification(Prod2StdCriteria criteria) {
        Specification<Prod2Std> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Prod2Std_.id));
            }
            if (criteria.getProdId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdId(), Prod2Std_.prodId));
            }
            if (criteria.getMnfctrId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrId(), Prod2Std_.mnfctrId));
            }
            if (criteria.getStdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNo(), Prod2Std_.stdNo));
            }
            if (criteria.getStdVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdVer(), Prod2Std_.stdVer));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), Prod2Std_.stsCd));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Prod2Std_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Prod2Std_.lstMtnDt));
            }
        }
        return specification;
    }
}
