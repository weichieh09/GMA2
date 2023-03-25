package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.ProdFee;
import com.wcc.gma2.repository.ProdFeeRepository;
import com.wcc.gma2.service.criteria.ProdFeeCriteria;
import com.wcc.gma2.service.dto.ProdFeeDTO;
import com.wcc.gma2.service.mapper.ProdFeeMapper;
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
 * Service for executing complex queries for {@link ProdFee} entities in the database.
 * The main input is a {@link ProdFeeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ProdFeeDTO} or a {@link Page} of {@link ProdFeeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ProdFeeQueryService extends QueryService<ProdFee> {

    private final Logger log = LoggerFactory.getLogger(ProdFeeQueryService.class);

    private final ProdFeeRepository prodFeeRepository;

    private final ProdFeeMapper prodFeeMapper;

    public ProdFeeQueryService(ProdFeeRepository prodFeeRepository, ProdFeeMapper prodFeeMapper) {
        this.prodFeeRepository = prodFeeRepository;
        this.prodFeeMapper = prodFeeMapper;
    }

    /**
     * Return a {@link List} of {@link ProdFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ProdFeeDTO> findByCriteria(ProdFeeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ProdFee> specification = createSpecification(criteria);
        return prodFeeMapper.toDto(prodFeeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ProdFeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ProdFeeDTO> findByCriteria(ProdFeeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ProdFee> specification = createSpecification(criteria);
        return prodFeeRepository.findAll(specification, page).map(prodFeeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ProdFeeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ProdFee> specification = createSpecification(criteria);
        return prodFeeRepository.count(specification);
    }

    /**
     * Function to convert {@link ProdFeeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ProdFee> createSpecification(ProdFeeCriteria criteria) {
        Specification<ProdFee> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ProdFee_.id));
            }
            if (criteria.getFee() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFee(), ProdFee_.fee));
            }
            if (criteria.getFeeType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFeeType(), ProdFee_.feeType));
            }
            if (criteria.getProdId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProdId(), root -> root.join(ProdFee_.prod, JoinType.LEFT).get(Prod_.id))
                    );
            }
        }
        return specification;
    }
}
