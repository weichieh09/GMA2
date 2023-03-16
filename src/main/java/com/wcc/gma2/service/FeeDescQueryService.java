package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.FeeDesc;
import com.wcc.gma2.repository.FeeDescRepository;
import com.wcc.gma2.service.criteria.FeeDescCriteria;
import com.wcc.gma2.service.dto.FeeDescDTO;
import com.wcc.gma2.service.mapper.FeeDescMapper;
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
 * Service for executing complex queries for {@link FeeDesc} entities in the database.
 * The main input is a {@link FeeDescCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FeeDescDTO} or a {@link Page} of {@link FeeDescDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FeeDescQueryService extends QueryService<FeeDesc> {

    private final Logger log = LoggerFactory.getLogger(FeeDescQueryService.class);

    private final FeeDescRepository feeDescRepository;

    private final FeeDescMapper feeDescMapper;

    public FeeDescQueryService(FeeDescRepository feeDescRepository, FeeDescMapper feeDescMapper) {
        this.feeDescRepository = feeDescRepository;
        this.feeDescMapper = feeDescMapper;
    }

    /**
     * Return a {@link List} of {@link FeeDescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FeeDescDTO> findByCriteria(FeeDescCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<FeeDesc> specification = createSpecification(criteria);
        return feeDescMapper.toDto(feeDescRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link FeeDescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<FeeDescDTO> findByCriteria(FeeDescCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<FeeDesc> specification = createSpecification(criteria);
        return feeDescRepository.findAll(specification, page).map(feeDescMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(FeeDescCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<FeeDesc> specification = createSpecification(criteria);
        return feeDescRepository.count(specification);
    }

    /**
     * Function to convert {@link FeeDescCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<FeeDesc> createSpecification(FeeDescCriteria criteria) {
        Specification<FeeDesc> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), FeeDesc_.id));
            }
            if (criteria.getFeeCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeCd(), FeeDesc_.feeCd));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), FeeDesc_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), FeeDesc_.lstMtnDt));
            }
        }
        return specification;
    }
}
