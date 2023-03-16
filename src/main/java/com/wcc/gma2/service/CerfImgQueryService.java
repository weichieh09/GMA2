package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.CerfImg;
import com.wcc.gma2.repository.CerfImgRepository;
import com.wcc.gma2.service.criteria.CerfImgCriteria;
import com.wcc.gma2.service.dto.CerfImgDTO;
import com.wcc.gma2.service.mapper.CerfImgMapper;
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
 * Service for executing complex queries for {@link CerfImg} entities in the database.
 * The main input is a {@link CerfImgCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfImgDTO} or a {@link Page} of {@link CerfImgDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfImgQueryService extends QueryService<CerfImg> {

    private final Logger log = LoggerFactory.getLogger(CerfImgQueryService.class);

    private final CerfImgRepository cerfImgRepository;

    private final CerfImgMapper cerfImgMapper;

    public CerfImgQueryService(CerfImgRepository cerfImgRepository, CerfImgMapper cerfImgMapper) {
        this.cerfImgRepository = cerfImgRepository;
        this.cerfImgMapper = cerfImgMapper;
    }

    /**
     * Return a {@link List} of {@link CerfImgDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfImgDTO> findByCriteria(CerfImgCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CerfImg> specification = createSpecification(criteria);
        return cerfImgMapper.toDto(cerfImgRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfImgDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfImgDTO> findByCriteria(CerfImgCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CerfImg> specification = createSpecification(criteria);
        return cerfImgRepository.findAll(specification, page).map(cerfImgMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfImgCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CerfImg> specification = createSpecification(criteria);
        return cerfImgRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfImgCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CerfImg> createSpecification(CerfImgCriteria criteria) {
        Specification<CerfImg> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CerfImg_.id));
            }
            if (criteria.getCerfTag() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfTag(), CerfImg_.cerfTag));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), CerfImg_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), CerfImg_.lstMtnDt));
            }
        }
        return specification;
    }
}
