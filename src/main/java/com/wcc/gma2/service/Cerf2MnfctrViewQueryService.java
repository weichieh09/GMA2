package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Cerf2MnfctrView;
import com.wcc.gma2.repository.Cerf2MnfctrViewRepository;
import com.wcc.gma2.service.criteria.Cerf2MnfctrViewCriteria;
import com.wcc.gma2.service.dto.Cerf2MnfctrViewDTO;
import com.wcc.gma2.service.mapper.Cerf2MnfctrViewMapper;
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
 * Service for executing complex queries for {@link Cerf2MnfctrView} entities in the database.
 * The main input is a {@link Cerf2MnfctrViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Cerf2MnfctrViewDTO} or a {@link Page} of {@link Cerf2MnfctrViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Cerf2MnfctrViewQueryService extends QueryService<Cerf2MnfctrView> {

    private final Logger log = LoggerFactory.getLogger(Cerf2MnfctrViewQueryService.class);

    private final Cerf2MnfctrViewRepository cerf2MnfctrViewRepository;

    private final Cerf2MnfctrViewMapper cerf2MnfctrViewMapper;

    public Cerf2MnfctrViewQueryService(Cerf2MnfctrViewRepository cerf2MnfctrViewRepository, Cerf2MnfctrViewMapper cerf2MnfctrViewMapper) {
        this.cerf2MnfctrViewRepository = cerf2MnfctrViewRepository;
        this.cerf2MnfctrViewMapper = cerf2MnfctrViewMapper;
    }

    /**
     * Return a {@link List} of {@link Cerf2MnfctrViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Cerf2MnfctrViewDTO> findByCriteria(Cerf2MnfctrViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cerf2MnfctrView> specification = createSpecification(criteria);
        return cerf2MnfctrViewMapper.toDto(cerf2MnfctrViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Cerf2MnfctrViewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Cerf2MnfctrViewDTO> findByCriteria(Cerf2MnfctrViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cerf2MnfctrView> specification = createSpecification(criteria);
        return cerf2MnfctrViewRepository.findAll(specification, page).map(cerf2MnfctrViewMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Cerf2MnfctrViewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cerf2MnfctrView> specification = createSpecification(criteria);
        return cerf2MnfctrViewRepository.count(specification);
    }

    /**
     * Function to convert {@link Cerf2MnfctrViewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cerf2MnfctrView> createSpecification(Cerf2MnfctrViewCriteria criteria) {
        Specification<Cerf2MnfctrView> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cerf2MnfctrView_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), Cerf2MnfctrView_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), Cerf2MnfctrView_.cerfVer));
            }
            if (criteria.getArea() != null) {
                specification = specification.and(buildStringSpecification(criteria.getArea(), Cerf2MnfctrView_.area));
            }
            if (criteria.getSts() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSts(), Cerf2MnfctrView_.sts));
            }
            if (criteria.getIssuDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIssuDt(), Cerf2MnfctrView_.issuDt));
            }
            if (criteria.getRemainDays() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRemainDays(), Cerf2MnfctrView_.remainDays));
            }
            if (criteria.getApplId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApplId(), Cerf2MnfctrView_.applId));
            }
            if (criteria.getMnfctrNmCh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrNmCh(), Cerf2MnfctrView_.mnfctrNmCh));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Cerf2MnfctrView_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Cerf2MnfctrView_.lstMtnDt));
            }
        }
        return specification;
    }
}
