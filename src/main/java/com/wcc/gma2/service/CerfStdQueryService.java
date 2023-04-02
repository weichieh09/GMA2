package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.CerfStd;
import com.wcc.gma2.repository.CerfStdRepository;
import com.wcc.gma2.service.criteria.CerfStdCriteria;
import com.wcc.gma2.service.dto.CerfStdDTO;
import com.wcc.gma2.service.mapper.CerfStdMapper;
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
 * Service for executing complex queries for {@link CerfStd} entities in the database.
 * The main input is a {@link CerfStdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfStdDTO} or a {@link Page} of {@link CerfStdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfStdQueryService extends QueryService<CerfStd> {

    private final Logger log = LoggerFactory.getLogger(CerfStdQueryService.class);

    private final CerfStdRepository cerfStdRepository;

    private final CerfStdMapper cerfStdMapper;

    public CerfStdQueryService(CerfStdRepository cerfStdRepository, CerfStdMapper cerfStdMapper) {
        this.cerfStdRepository = cerfStdRepository;
        this.cerfStdMapper = cerfStdMapper;
    }

    /**
     * Return a {@link List} of {@link CerfStdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfStdDTO> findByCriteria(CerfStdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CerfStd> specification = createSpecification(criteria);
        return cerfStdMapper.toDto(cerfStdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfStdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfStdDTO> findByCriteria(CerfStdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CerfStd> specification = createSpecification(criteria);
        return cerfStdRepository.findAll(specification, page).map(cerfStdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfStdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CerfStd> specification = createSpecification(criteria);
        return cerfStdRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfStdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CerfStd> createSpecification(CerfStdCriteria criteria) {
        Specification<CerfStd> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CerfStd_.id));
            }
            if (criteria.getRelType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRelType(), CerfStd_.relType));
            }
            if (criteria.getCerfId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCerfId(), root -> root.join(CerfStd_.cerf, JoinType.LEFT).get(Cerf_.id))
                    );
            }
            if (criteria.getStdId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getStdId(), root -> root.join(CerfStd_.std, JoinType.LEFT).get(Std_.id)));
            }
        }
        return specification;
    }
}
