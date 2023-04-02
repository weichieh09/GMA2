package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.CerfProd;
import com.wcc.gma2.repository.CerfProdRepository;
import com.wcc.gma2.service.criteria.CerfProdCriteria;
import com.wcc.gma2.service.dto.CerfProdDTO;
import com.wcc.gma2.service.mapper.CerfProdMapper;
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
 * Service for executing complex queries for {@link CerfProd} entities in the database.
 * The main input is a {@link CerfProdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfProdDTO} or a {@link Page} of {@link CerfProdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfProdQueryService extends QueryService<CerfProd> {

    private final Logger log = LoggerFactory.getLogger(CerfProdQueryService.class);

    private final CerfProdRepository cerfProdRepository;

    private final CerfProdMapper cerfProdMapper;

    public CerfProdQueryService(CerfProdRepository cerfProdRepository, CerfProdMapper cerfProdMapper) {
        this.cerfProdRepository = cerfProdRepository;
        this.cerfProdMapper = cerfProdMapper;
    }

    /**
     * Return a {@link List} of {@link CerfProdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfProdDTO> findByCriteria(CerfProdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CerfProd> specification = createSpecification(criteria);
        return cerfProdMapper.toDto(cerfProdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfProdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfProdDTO> findByCriteria(CerfProdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CerfProd> specification = createSpecification(criteria);
        return cerfProdRepository.findAll(specification, page).map(cerfProdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfProdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CerfProd> specification = createSpecification(criteria);
        return cerfProdRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfProdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CerfProd> createSpecification(CerfProdCriteria criteria) {
        Specification<CerfProd> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CerfProd_.id));
            }
            if (criteria.getRelType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRelType(), CerfProd_.relType));
            }
            if (criteria.getCerfId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCerfId(), root -> root.join(CerfProd_.cerf, JoinType.LEFT).get(Cerf_.id))
                    );
            }
            if (criteria.getProdId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProdId(), root -> root.join(CerfProd_.prod, JoinType.LEFT).get(Prod_.id))
                    );
            }
        }
        return specification;
    }
}
