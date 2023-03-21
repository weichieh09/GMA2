package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.CerfView;
import com.wcc.gma2.repository.CerfViewRepository;
import com.wcc.gma2.service.criteria.CerfViewCriteria;
import com.wcc.gma2.service.dto.CerfViewDTO;
import com.wcc.gma2.service.mapper.CerfViewMapper;
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
 * Service for executing complex queries for {@link CerfView} entities in the database.
 * The main input is a {@link CerfViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfViewDTO} or a {@link Page} of {@link CerfViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfViewQueryService extends QueryService<CerfView> {

    private final Logger log = LoggerFactory.getLogger(CerfViewQueryService.class);

    private final CerfViewRepository cerfViewRepository;

    private final CerfViewMapper cerfViewMapper;

    public CerfViewQueryService(CerfViewRepository cerfViewRepository, CerfViewMapper cerfViewMapper) {
        this.cerfViewRepository = cerfViewRepository;
        this.cerfViewMapper = cerfViewMapper;
    }

    /**
     * Return a {@link List} of {@link CerfViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfViewDTO> findByCriteria(CerfViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CerfView> specification = createSpecification(criteria);
        return cerfViewMapper.toDto(cerfViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfViewDTO> findByCriteria(CerfViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CerfView> specification = createSpecification(criteria);
        return cerfViewRepository.findAll(specification, page).map(cerfViewMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfViewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CerfView> specification = createSpecification(criteria);
        return cerfViewRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfViewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CerfView> createSpecification(CerfViewCriteria criteria) {
        Specification<CerfView> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CerfView_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), CerfView_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), CerfView_.cerfVer));
            }
            if (criteria.getFeeDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFeeDt(), CerfView_.feeDt));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), CerfView_.fee));
            }
        }
        return specification;
    }
}
