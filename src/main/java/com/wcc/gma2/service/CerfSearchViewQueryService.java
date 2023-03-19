package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.CerfSearchView;
import com.wcc.gma2.repository.CerfSearchViewRepository;
import com.wcc.gma2.service.criteria.CerfSearchViewCriteria;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
import com.wcc.gma2.service.mapper.CerfSearchViewMapper;
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
 * Service for executing complex queries for {@link CerfSearchView} entities in the database.
 * The main input is a {@link CerfSearchViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfSearchViewDTO} or a {@link Page} of {@link CerfSearchViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfSearchViewQueryService extends QueryService<CerfSearchView> {

    private final Logger log = LoggerFactory.getLogger(CerfSearchViewQueryService.class);

    private final CerfSearchViewRepository cerfSearchViewRepository;

    private final CerfSearchViewMapper cerfSearchViewMapper;

    public CerfSearchViewQueryService(CerfSearchViewRepository cerfSearchViewRepository, CerfSearchViewMapper cerfSearchViewMapper) {
        this.cerfSearchViewRepository = cerfSearchViewRepository;
        this.cerfSearchViewMapper = cerfSearchViewMapper;
    }

    /**
     * Return a {@link List} of {@link CerfSearchViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfSearchViewDTO> findByCriteria(CerfSearchViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CerfSearchView> specification = createSpecification(criteria);
        return cerfSearchViewMapper.toDto(cerfSearchViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfSearchViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfSearchViewDTO> findByCriteria(CerfSearchViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CerfSearchView> specification = createSpecification(criteria);
        return cerfSearchViewRepository.findAll(specification, page).map(cerfSearchViewMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfSearchViewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CerfSearchView> specification = createSpecification(criteria);
        return cerfSearchViewRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfSearchViewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CerfSearchView> createSpecification(CerfSearchViewCriteria criteria) {
        Specification<CerfSearchView> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CerfSearchView_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), CerfSearchView_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), CerfSearchView_.cerfVer));
            }
            if (criteria.getFeeCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeCd(), CerfSearchView_.feeCd));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), CerfSearchView_.fee));
            }
            if (criteria.getAreaCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAreaCd(), CerfSearchView_.areaCd));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), CerfSearchView_.stsCd));
            }
            if (criteria.getApplId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApplId(), CerfSearchView_.applId));
            }
            if (criteria.getMnfctrNmCh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrNmCh(), CerfSearchView_.mnfctrNmCh));
            }
            if (criteria.getProdId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdId(), CerfSearchView_.prodId));
            }
            if (criteria.getMnfctrId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrId(), CerfSearchView_.mnfctrId));
            }
            if (criteria.getFctyId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFctyId(), CerfSearchView_.fctyId));
            }
        }
        return specification;
    }
}
