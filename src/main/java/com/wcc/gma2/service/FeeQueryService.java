package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Fee;
import com.wcc.gma2.repository.FeeRepository;
import com.wcc.gma2.service.criteria.FeeCriteria;
import com.wcc.gma2.service.dto.FeeDTO;
import com.wcc.gma2.service.mapper.FeeMapper;
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
 * Service for executing complex queries for {@link Fee} entities in the database.
 * The main input is a {@link FeeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FeeDTO} or a {@link Page} of {@link FeeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FeeQueryService extends QueryService<Fee> {

    private final Logger log = LoggerFactory.getLogger(FeeQueryService.class);

    private final FeeRepository feeRepository;

    private final FeeMapper feeMapper;

    public FeeQueryService(FeeRepository feeRepository, FeeMapper feeMapper) {
        this.feeRepository = feeRepository;
        this.feeMapper = feeMapper;
    }

    /**
     * Return a {@link List} of {@link FeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FeeDTO> findByCriteria(FeeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Fee> specification = createSpecification(criteria);
        return feeMapper.toDto(feeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link FeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<FeeDTO> findByCriteria(FeeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Fee> specification = createSpecification(criteria);
        return feeRepository.findAll(specification, page).map(feeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(FeeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Fee> specification = createSpecification(criteria);
        return feeRepository.count(specification);
    }

    /**
     * Function to convert {@link FeeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Fee> createSpecification(FeeCriteria criteria) {
        Specification<Fee> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Fee_.id));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), Fee_.fee));
            }
            if (criteria.getFeeType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeType(), Fee_.feeType));
            }
            if (criteria.getFeeDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFeeDt(), Fee_.feeDt));
            }
            if (criteria.getProdId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getProdId(), root -> root.join(Fee_.prod, JoinType.LEFT).get(Prod_.id)));
            }
            if (criteria.getCerfId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getCerfId(), root -> root.join(Fee_.cerf, JoinType.LEFT).get(Cerf_.id)));
            }
            if (criteria.getCompanyId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCompanyId(), root -> root.join(Fee_.company, JoinType.LEFT).get(Company_.id))
                    );
            }
        }
        return specification;
    }
}
