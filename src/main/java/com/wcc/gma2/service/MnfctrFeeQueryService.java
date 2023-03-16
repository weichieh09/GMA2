package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.MnfctrFee;
import com.wcc.gma2.repository.MnfctrFeeRepository;
import com.wcc.gma2.service.criteria.MnfctrFeeCriteria;
import com.wcc.gma2.service.dto.MnfctrFeeDTO;
import com.wcc.gma2.service.mapper.MnfctrFeeMapper;
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
 * Service for executing complex queries for {@link MnfctrFee} entities in the database.
 * The main input is a {@link MnfctrFeeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link MnfctrFeeDTO} or a {@link Page} of {@link MnfctrFeeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class MnfctrFeeQueryService extends QueryService<MnfctrFee> {

    private final Logger log = LoggerFactory.getLogger(MnfctrFeeQueryService.class);

    private final MnfctrFeeRepository mnfctrFeeRepository;

    private final MnfctrFeeMapper mnfctrFeeMapper;

    public MnfctrFeeQueryService(MnfctrFeeRepository mnfctrFeeRepository, MnfctrFeeMapper mnfctrFeeMapper) {
        this.mnfctrFeeRepository = mnfctrFeeRepository;
        this.mnfctrFeeMapper = mnfctrFeeMapper;
    }

    /**
     * Return a {@link List} of {@link MnfctrFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<MnfctrFeeDTO> findByCriteria(MnfctrFeeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<MnfctrFee> specification = createSpecification(criteria);
        return mnfctrFeeMapper.toDto(mnfctrFeeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link MnfctrFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<MnfctrFeeDTO> findByCriteria(MnfctrFeeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<MnfctrFee> specification = createSpecification(criteria);
        return mnfctrFeeRepository.findAll(specification, page).map(mnfctrFeeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(MnfctrFeeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<MnfctrFee> specification = createSpecification(criteria);
        return mnfctrFeeRepository.count(specification);
    }

    /**
     * Function to convert {@link MnfctrFeeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<MnfctrFee> createSpecification(MnfctrFeeCriteria criteria) {
        Specification<MnfctrFee> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), MnfctrFee_.id));
            }
            if (criteria.getFctyId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFctyId(), MnfctrFee_.fctyId));
            }
            if (criteria.getFeeCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeCd(), MnfctrFee_.feeCd));
            }
            if (criteria.getFeeDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFeeDt(), MnfctrFee_.feeDt));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), MnfctrFee_.fee));
            }
            if (criteria.getCurr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCurr(), MnfctrFee_.curr));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), MnfctrFee_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), MnfctrFee_.lstMtnDt));
            }
        }
        return specification;
    }
}
