package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.repository.CerfRepository;
import com.wcc.gma2.service.criteria.CerfCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.mapper.CerfMapper;
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
 * Service for executing complex queries for {@link Cerf} entities in the database.
 * The main input is a {@link CerfCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CerfDTO} or a {@link Page} of {@link CerfDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CerfQueryService extends QueryService<Cerf> {

    private final Logger log = LoggerFactory.getLogger(CerfQueryService.class);

    private final CerfRepository cerfRepository;

    private final CerfMapper cerfMapper;

    public CerfQueryService(CerfRepository cerfRepository, CerfMapper cerfMapper) {
        this.cerfRepository = cerfRepository;
        this.cerfMapper = cerfMapper;
    }

    /**
     * Return a {@link List} of {@link CerfDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CerfDTO> findByCriteria(CerfCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cerf> specification = createSpecification(criteria);
        return cerfMapper.toDto(cerfRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CerfDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CerfDTO> findByCriteria(CerfCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cerf> specification = createSpecification(criteria);
        return cerfRepository.findAll(specification, page).map(cerfMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CerfCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cerf> specification = createSpecification(criteria);
        return cerfRepository.count(specification);
    }

    /**
     * Function to convert {@link CerfCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cerf> createSpecification(CerfCriteria criteria) {
        Specification<Cerf> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cerf_.id));
            }
            if (criteria.getCerfNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfNo(), Cerf_.cerfNo));
            }
            if (criteria.getCerfVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCerfVer(), Cerf_.cerfVer));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), Cerf_.status));
            }
            if (criteria.getIssuDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIssuDt(), Cerf_.issuDt));
            }
            if (criteria.getExpDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExpDt(), Cerf_.expDt));
            }
            if (criteria.getCerfCompanyId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getCerfCompanyId(),
                            root -> root.join(Cerf_.cerfCompanies, JoinType.LEFT).get(CerfCompany_.id)
                        )
                    );
            }
            if (criteria.getProdId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProdId(), root -> root.join(Cerf_.prods, JoinType.LEFT).get(Prod_.id))
                    );
            }
            if (criteria.getStdId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getStdId(), root -> root.join(Cerf_.stds, JoinType.LEFT).get(Std_.id)));
            }
            if (criteria.getCountryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCountryId(), root -> root.join(Cerf_.country, JoinType.LEFT).get(Country_.id))
                    );
            }
        }
        return specification;
    }
}
