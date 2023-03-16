package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.StdFee;
import com.wcc.gma2.repository.StdFeeRepository;
import com.wcc.gma2.service.criteria.StdFeeCriteria;
import com.wcc.gma2.service.dto.StdFeeDTO;
import com.wcc.gma2.service.mapper.StdFeeMapper;
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
 * Service for executing complex queries for {@link StdFee} entities in the database.
 * The main input is a {@link StdFeeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StdFeeDTO} or a {@link Page} of {@link StdFeeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StdFeeQueryService extends QueryService<StdFee> {

    private final Logger log = LoggerFactory.getLogger(StdFeeQueryService.class);

    private final StdFeeRepository stdFeeRepository;

    private final StdFeeMapper stdFeeMapper;

    public StdFeeQueryService(StdFeeRepository stdFeeRepository, StdFeeMapper stdFeeMapper) {
        this.stdFeeRepository = stdFeeRepository;
        this.stdFeeMapper = stdFeeMapper;
    }

    /**
     * Return a {@link List} of {@link StdFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StdFeeDTO> findByCriteria(StdFeeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<StdFee> specification = createSpecification(criteria);
        return stdFeeMapper.toDto(stdFeeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StdFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StdFeeDTO> findByCriteria(StdFeeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<StdFee> specification = createSpecification(criteria);
        return stdFeeRepository.findAll(specification, page).map(stdFeeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StdFeeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<StdFee> specification = createSpecification(criteria);
        return stdFeeRepository.count(specification);
    }

    /**
     * Function to convert {@link StdFeeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<StdFee> createSpecification(StdFeeCriteria criteria) {
        Specification<StdFee> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), StdFee_.id));
            }
            if (criteria.getProdId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdId(), StdFee_.prodId));
            }
            if (criteria.getMnfctrId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrId(), StdFee_.mnfctrId));
            }
            if (criteria.getStdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNo(), StdFee_.stdNo));
            }
            if (criteria.getStdVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdVer(), StdFee_.stdVer));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), StdFee_.stsCd));
            }
            if (criteria.getFeeCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeCd(), StdFee_.feeCd));
            }
            if (criteria.getFeeDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFeeDt(), StdFee_.feeDt));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), StdFee_.fee));
            }
            if (criteria.getCurr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCurr(), StdFee_.curr));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), StdFee_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), StdFee_.lstMtnDt));
            }
        }
        return specification;
    }
}
