package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Prod;
import com.wcc.gma2.repository.ProdRepository;
import com.wcc.gma2.service.criteria.ProdCriteria;
import com.wcc.gma2.service.dto.ProdDTO;
import com.wcc.gma2.service.mapper.ProdMapper;
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
 * Service for executing complex queries for {@link Prod} entities in the database.
 * The main input is a {@link ProdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ProdDTO} or a {@link Page} of {@link ProdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ProdQueryService extends QueryService<Prod> {

    private final Logger log = LoggerFactory.getLogger(ProdQueryService.class);

    private final ProdRepository prodRepository;

    private final ProdMapper prodMapper;

    public ProdQueryService(ProdRepository prodRepository, ProdMapper prodMapper) {
        this.prodRepository = prodRepository;
        this.prodMapper = prodMapper;
    }

    /**
     * Return a {@link List} of {@link ProdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ProdDTO> findByCriteria(ProdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Prod> specification = createSpecification(criteria);
        return prodMapper.toDto(prodRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ProdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ProdDTO> findByCriteria(ProdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Prod> specification = createSpecification(criteria);
        return prodRepository.findAll(specification, page).map(prodMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ProdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Prod> specification = createSpecification(criteria);
        return prodRepository.count(specification);
    }

    /**
     * Function to convert {@link ProdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Prod> createSpecification(ProdCriteria criteria) {
        Specification<Prod> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Prod_.id));
            }
            if (criteria.getProdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getProdNo(), Prod_.prodNo));
            }
            if (criteria.getEnName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnName(), Prod_.enName));
            }
            if (criteria.getChName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getChName(), Prod_.chName));
            }
            if (criteria.getHsCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHsCode(), Prod_.hsCode));
            }
            if (criteria.getCccCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCccCode(), Prod_.cccCode));
            }
            if (criteria.getCountryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCountryId(), root -> root.join(Prod_.countries, JoinType.LEFT).get(Country_.id))
                    );
            }
            if (criteria.getStdId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getStdId(), root -> root.join(Prod_.stds, JoinType.LEFT).get(Std_.id)));
            }
            if (criteria.getMarkId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getMarkId(), root -> root.join(Prod_.marks, JoinType.LEFT).get(Mark_.id))
                    );
            }
            if (criteria.getCerfId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCerfId(), root -> root.join(Prod_.cerfs, JoinType.LEFT).get(Cerf_.id))
                    );
            }
        }
        return specification;
    }
}
