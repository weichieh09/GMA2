package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Prod2Cerf;
import com.wcc.gma2.repository.Prod2CerfRepository;
import com.wcc.gma2.service.criteria.Prod2CerfCriteria;
import com.wcc.gma2.service.dto.Prod2CerfDTO;
import com.wcc.gma2.service.mapper.Prod2CerfMapper;
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
 * Service for executing complex queries for {@link Prod2Cerf} entities in the database.
 * The main input is a {@link Prod2CerfCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Prod2CerfDTO} or a {@link Page} of {@link Prod2CerfDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Prod2CerfQueryService extends QueryService<Prod2Cerf> {

    private final Logger log = LoggerFactory.getLogger(Prod2CerfQueryService.class);

    private final Prod2CerfRepository prod2CerfRepository;

    private final Prod2CerfMapper prod2CerfMapper;

    public Prod2CerfQueryService(Prod2CerfRepository prod2CerfRepository, Prod2CerfMapper prod2CerfMapper) {
        this.prod2CerfRepository = prod2CerfRepository;
        this.prod2CerfMapper = prod2CerfMapper;
    }

    /**
     * Return a {@link List} of {@link Prod2CerfDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Prod2CerfDTO> findByCriteria(Prod2CerfCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Prod2Cerf> specification = createSpecification(criteria);
        return prod2CerfMapper.toDto(prod2CerfRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Prod2CerfDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Prod2CerfDTO> findByCriteria(Prod2CerfCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Prod2Cerf> specification = createSpecification(criteria);
        return prod2CerfRepository.findAll(specification, page).map(prod2CerfMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Prod2CerfCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Prod2Cerf> specification = createSpecification(criteria);
        return prod2CerfRepository.count(specification);
    }

    /**
     * Function to convert {@link Prod2CerfCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Prod2Cerf> createSpecification(Prod2CerfCriteria criteria) {
        Specification<Prod2Cerf> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Prod2Cerf_.id));
            }
            if (criteria.getProdId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdId(), Prod2Cerf_.prodId));
            }
            if (criteria.getMnfctrId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrId(), Prod2Cerf_.mnfctrId));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), Prod2Cerf_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), Prod2Cerf_.cerfVer));
            }
            if (criteria.getApplId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApplId(), Prod2Cerf_.applId));
            }
            if (criteria.getAreaCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAreaCd(), Prod2Cerf_.areaCd));
            }
            if (criteria.getCerfTag() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfTag(), Prod2Cerf_.cerfTag));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), Prod2Cerf_.stsCd));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Prod2Cerf_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Prod2Cerf_.lstMtnDt));
            }
        }
        return specification;
    }
}
