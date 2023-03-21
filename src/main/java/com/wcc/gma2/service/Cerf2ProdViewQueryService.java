package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Cerf2ProdView;
import com.wcc.gma2.repository.Cerf2ProdViewRepository;
import com.wcc.gma2.service.criteria.Cerf2ProdViewCriteria;
import com.wcc.gma2.service.dto.Cerf2ProdViewDTO;
import com.wcc.gma2.service.mapper.Cerf2ProdViewMapper;
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
 * Service for executing complex queries for {@link Cerf2ProdView} entities in the database.
 * The main input is a {@link Cerf2ProdViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Cerf2ProdViewDTO} or a {@link Page} of {@link Cerf2ProdViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Cerf2ProdViewQueryService extends QueryService<Cerf2ProdView> {

    private final Logger log = LoggerFactory.getLogger(Cerf2ProdViewQueryService.class);

    private final Cerf2ProdViewRepository cerf2ProdViewRepository;

    private final Cerf2ProdViewMapper cerf2ProdViewMapper;

    public Cerf2ProdViewQueryService(Cerf2ProdViewRepository cerf2ProdViewRepository, Cerf2ProdViewMapper cerf2ProdViewMapper) {
        this.cerf2ProdViewRepository = cerf2ProdViewRepository;
        this.cerf2ProdViewMapper = cerf2ProdViewMapper;
    }

    /**
     * Return a {@link List} of {@link Cerf2ProdViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Cerf2ProdViewDTO> findByCriteria(Cerf2ProdViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cerf2ProdView> specification = createSpecification(criteria);
        return cerf2ProdViewMapper.toDto(cerf2ProdViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Cerf2ProdViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Cerf2ProdViewDTO> findByCriteria(Cerf2ProdViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cerf2ProdView> specification = createSpecification(criteria);
        return cerf2ProdViewRepository.findAll(specification, page).map(cerf2ProdViewMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Cerf2ProdViewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cerf2ProdView> specification = createSpecification(criteria);
        return cerf2ProdViewRepository.count(specification);
    }

    /**
     * Function to convert {@link Cerf2ProdViewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cerf2ProdView> createSpecification(Cerf2ProdViewCriteria criteria) {
        Specification<Cerf2ProdView> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cerf2ProdView_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), Cerf2ProdView_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), Cerf2ProdView_.cerfVer));
            }
            if (criteria.getProdId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdId(), Cerf2ProdView_.prodId));
            }
            if (criteria.getProdNmCh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdNmCh(), Cerf2ProdView_.prodNmCh));
            }
        }
        return specification;
    }
}
