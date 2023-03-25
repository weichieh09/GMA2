package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.repository.StdRepository;
import com.wcc.gma2.service.criteria.StdCriteria;
import com.wcc.gma2.service.dto.StdDTO;
import com.wcc.gma2.service.mapper.StdMapper;
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
 * Service for executing complex queries for {@link Std} entities in the database.
 * The main input is a {@link StdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StdDTO} or a {@link Page} of {@link StdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StdQueryService extends QueryService<Std> {

    private final Logger log = LoggerFactory.getLogger(StdQueryService.class);

    private final StdRepository stdRepository;

    private final StdMapper stdMapper;

    public StdQueryService(StdRepository stdRepository, StdMapper stdMapper) {
        this.stdRepository = stdRepository;
        this.stdMapper = stdMapper;
    }

    /**
     * Return a {@link List} of {@link StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StdDTO> findByCriteria(StdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Std> specification = createSpecification(criteria);
        return stdMapper.toDto(stdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StdDTO> findByCriteria(StdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Std> specification = createSpecification(criteria);
        return stdRepository.findAll(specification, page).map(stdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Std> specification = createSpecification(criteria);
        return stdRepository.count(specification);
    }

    /**
     * Function to convert {@link StdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Std> createSpecification(StdCriteria criteria) {
        Specification<Std> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Std_.id));
            }
            if (criteria.getStdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNo(), Std_.stdNo));
            }
            if (criteria.getStdVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdVer(), Std_.stdVer));
            }
            if (criteria.getEnName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnName(), Std_.enName));
            }
            if (criteria.getChName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getChName(), Std_.chName));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), Std_.status));
            }
            if (criteria.getIssuDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIssuDt(), Std_.issuDt));
            }
            if (criteria.getExpDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExpDt(), Std_.expDt));
            }
            if (criteria.getProdId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getProdId(), root -> root.join(Std_.prods, JoinType.LEFT).get(Prod_.id)));
            }
            if (criteria.getCerfId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getCerfId(), root -> root.join(Std_.cerfs, JoinType.LEFT).get(Cerf_.id)));
            }
            if (criteria.getCountryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCountryId(), root -> root.join(Std_.countries, JoinType.LEFT).get(Country_.id))
                    );
            }
        }
        return specification;
    }
}
