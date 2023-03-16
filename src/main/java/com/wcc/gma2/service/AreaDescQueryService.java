package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.AreaDesc;
import com.wcc.gma2.repository.AreaDescRepository;
import com.wcc.gma2.service.criteria.AreaDescCriteria;
import com.wcc.gma2.service.dto.AreaDescDTO;
import com.wcc.gma2.service.mapper.AreaDescMapper;
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
 * Service for executing complex queries for {@link AreaDesc} entities in the database.
 * The main input is a {@link AreaDescCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AreaDescDTO} or a {@link Page} of {@link AreaDescDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AreaDescQueryService extends QueryService<AreaDesc> {

    private final Logger log = LoggerFactory.getLogger(AreaDescQueryService.class);

    private final AreaDescRepository areaDescRepository;

    private final AreaDescMapper areaDescMapper;

    public AreaDescQueryService(AreaDescRepository areaDescRepository, AreaDescMapper areaDescMapper) {
        this.areaDescRepository = areaDescRepository;
        this.areaDescMapper = areaDescMapper;
    }

    /**
     * Return a {@link List} of {@link AreaDescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AreaDescDTO> findByCriteria(AreaDescCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<AreaDesc> specification = createSpecification(criteria);
        return areaDescMapper.toDto(areaDescRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link AreaDescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AreaDescDTO> findByCriteria(AreaDescCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<AreaDesc> specification = createSpecification(criteria);
        return areaDescRepository.findAll(specification, page).map(areaDescMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AreaDescCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<AreaDesc> specification = createSpecification(criteria);
        return areaDescRepository.count(specification);
    }

    /**
     * Function to convert {@link AreaDescCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<AreaDesc> createSpecification(AreaDescCriteria criteria) {
        Specification<AreaDesc> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), AreaDesc_.id));
            }
            if (criteria.getAreaCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAreaCd(), AreaDesc_.areaCd));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), AreaDesc_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), AreaDesc_.lstMtnDt));
            }
        }
        return specification;
    }
}
