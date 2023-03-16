package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.CerfFee;
import com.wcc.gma2.repository.CerfFeeRepository;
import com.wcc.gma2.service.criteria.CerfFeeCriteria;
import com.wcc.gma2.service.dto.CerfFeeDTO;
import com.wcc.gma2.service.mapper.CerfFeeMapper;
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
 * Service for executing complex queries for {@link CerfFee} entities in the database.
 * The main input is a {@link CerfFeeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfFeeDTO} or a {@link Page} of {@link CerfFeeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfFeeQueryService extends QueryService<CerfFee> {

    private final Logger log = LoggerFactory.getLogger(CerfFeeQueryService.class);

    private final CerfFeeRepository cerfFeeRepository;

    private final CerfFeeMapper cerfFeeMapper;

    public CerfFeeQueryService(CerfFeeRepository cerfFeeRepository, CerfFeeMapper cerfFeeMapper) {
        this.cerfFeeRepository = cerfFeeRepository;
        this.cerfFeeMapper = cerfFeeMapper;
    }

    /**
     * Return a {@link List} of {@link CerfFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfFeeDTO> findByCriteria(CerfFeeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CerfFee> specification = createSpecification(criteria);
        return cerfFeeMapper.toDto(cerfFeeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfFeeDTO> findByCriteria(CerfFeeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CerfFee> specification = createSpecification(criteria);
        return cerfFeeRepository.findAll(specification, page).map(cerfFeeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfFeeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CerfFee> specification = createSpecification(criteria);
        return cerfFeeRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfFeeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CerfFee> createSpecification(CerfFeeCriteria criteria) {
        Specification<CerfFee> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CerfFee_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), CerfFee_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), CerfFee_.cerfVer));
            }
            if (criteria.getCerfTag() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfTag(), CerfFee_.cerfTag));
            }
            if (criteria.getAreaCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAreaCd(), CerfFee_.areaCd));
            }
            if (criteria.getApplId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApplId(), CerfFee_.applId));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), CerfFee_.stsCd));
            }
            if (criteria.getFeeCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeCd(), CerfFee_.feeCd));
            }
            if (criteria.getFeeDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFeeDt(), CerfFee_.feeDt));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), CerfFee_.fee));
            }
            if (criteria.getCurr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCurr(), CerfFee_.curr));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), CerfFee_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), CerfFee_.lstMtnDt));
            }
        }
        return specification;
    }
}
