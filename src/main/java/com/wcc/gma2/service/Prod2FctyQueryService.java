package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Prod2Fcty;
import com.wcc.gma2.repository.Prod2FctyRepository;
import com.wcc.gma2.service.criteria.Prod2FctyCriteria;
import com.wcc.gma2.service.dto.Prod2FctyDTO;
import com.wcc.gma2.service.mapper.Prod2FctyMapper;
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
 * Service for executing complex queries for {@link Prod2Fcty} entities in the database.
 * The main input is a {@link Prod2FctyCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Prod2FctyDTO} or a {@link Page} of {@link Prod2FctyDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class Prod2FctyQueryService extends QueryService<Prod2Fcty> {

    private final Logger log = LoggerFactory.getLogger(Prod2FctyQueryService.class);

    private final Prod2FctyRepository prod2FctyRepository;

    private final Prod2FctyMapper prod2FctyMapper;

    public Prod2FctyQueryService(Prod2FctyRepository prod2FctyRepository, Prod2FctyMapper prod2FctyMapper) {
        this.prod2FctyRepository = prod2FctyRepository;
        this.prod2FctyMapper = prod2FctyMapper;
    }

    /**
     * Return a {@link List} of {@link Prod2FctyDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Prod2FctyDTO> findByCriteria(Prod2FctyCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Prod2Fcty> specification = createSpecification(criteria);
        return prod2FctyMapper.toDto(prod2FctyRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link Prod2FctyDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Prod2FctyDTO> findByCriteria(Prod2FctyCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Prod2Fcty> specification = createSpecification(criteria);
        return prod2FctyRepository.findAll(specification, page).map(prod2FctyMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(Prod2FctyCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Prod2Fcty> specification = createSpecification(criteria);
        return prod2FctyRepository.count(specification);
    }

    /**
     * Function to convert {@link Prod2FctyCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Prod2Fcty> createSpecification(Prod2FctyCriteria criteria) {
        Specification<Prod2Fcty> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Prod2Fcty_.id));
            }
            if (criteria.getProdId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdId(), Prod2Fcty_.prodId));
            }
            if (criteria.getMnfctrId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrId(), Prod2Fcty_.mnfctrId));
            }
            if (criteria.getFctyId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFctyId(), Prod2Fcty_.fctyId));
            }
            if (criteria.getInspectDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInspectDt(), Prod2Fcty_.inspectDt));
            }
            if (criteria.getDiscontinueFg() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDiscontinueFg(), Prod2Fcty_.discontinueFg));
            }
            if (criteria.getDiscontinueDesc() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDiscontinueDesc(), Prod2Fcty_.discontinueDesc));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Prod2Fcty_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Prod2Fcty_.lstMtnDt));
            }
        }
        return specification;
    }
}
