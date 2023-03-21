package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Cerf2StdView;
import com.wcc.gma2.repository.Cerf2StdViewRepository;
import com.wcc.gma2.service.criteria.Cerf2StdViewCriteria;
import com.wcc.gma2.service.dto.Cerf2StdViewDTO;
import com.wcc.gma2.service.mapper.Cerf2StdViewMapper;
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
 * Service for executing complex queries for {@link Cerf2StdView} entities in the database.
 * The main input is a {@link Cerf2StdViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Cerf2StdViewDTO} or a {@link Page} of {@link Cerf2StdViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Cerf2StdViewQueryService extends QueryService<Cerf2StdView> {

    private final Logger log = LoggerFactory.getLogger(Cerf2StdViewQueryService.class);

    private final Cerf2StdViewRepository cerf2StdViewRepository;

    private final Cerf2StdViewMapper cerf2StdViewMapper;

    public Cerf2StdViewQueryService(Cerf2StdViewRepository cerf2StdViewRepository, Cerf2StdViewMapper cerf2StdViewMapper) {
        this.cerf2StdViewRepository = cerf2StdViewRepository;
        this.cerf2StdViewMapper = cerf2StdViewMapper;
    }

    /**
     * Return a {@link List} of {@link Cerf2StdViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Cerf2StdViewDTO> findByCriteria(Cerf2StdViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cerf2StdView> specification = createSpecification(criteria);
        return cerf2StdViewMapper.toDto(cerf2StdViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Cerf2StdViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Cerf2StdViewDTO> findByCriteria(Cerf2StdViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cerf2StdView> specification = createSpecification(criteria);
        return cerf2StdViewRepository.findAll(specification, page).map(cerf2StdViewMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Cerf2StdViewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cerf2StdView> specification = createSpecification(criteria);
        return cerf2StdViewRepository.count(specification);
    }

    /**
     * Function to convert {@link Cerf2StdViewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cerf2StdView> createSpecification(Cerf2StdViewCriteria criteria) {
        Specification<Cerf2StdView> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cerf2StdView_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), Cerf2StdView_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), Cerf2StdView_.cerfVer));
            }
            if (criteria.getStdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNo(), Cerf2StdView_.stdNo));
            }
            if (criteria.getStdVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdVer(), Cerf2StdView_.stdVer));
            }
        }
        return specification;
    }
}
