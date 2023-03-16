package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Std;
import com.wcc.gma2.repository.StdRepository;
import com.wcc.gma2.service.criteria.StdCriteria;
import com.wcc.gma2.service.dto.StdDTO;
import com.wcc.gma2.service.mapper.StdMapper;
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
 * Service for executing complex queries for {@link Std} entities in the database.
 * The main input is a {@link StdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StdDTO} or a {@link Page} of {@link StdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StdQueryService extends QueryService<Std> {

    private final Logger log = LoggerFactory.getLogger(StdQueryService.class);

    private final StdRepository stdRepository;

    private final StdMapper stdMapper;

    public StdQueryService(StdRepository stdRepository, StdMapper stdMapper) {
        this.stdRepository = stdRepository;
        this.stdMapper = stdMapper;
    }

    /**
     * Return a {@link List} of {@link StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StdDTO> findByCriteria(StdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Std> specification = createSpecification(criteria);
        return stdMapper.toDto(stdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StdDTO> findByCriteria(StdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Std> specification = createSpecification(criteria);
        return stdRepository.findAll(specification, page).map(stdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Std> specification = createSpecification(criteria);
        return stdRepository.count(specification);
    }

    /**
     * Function to convert {@link StdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Std> createSpecification(StdCriteria criteria) {
        Specification<Std> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Std_.id));
            }
            if (criteria.getStdNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNo(), Std_.stdNo));
            }
            if (criteria.getStdVer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdVer(), Std_.stdVer));
            }
            if (criteria.getStsCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStsCd(), Std_.stsCd));
            }
            if (criteria.getStdCd() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdCd(), Std_.stdCd));
            }
            if (criteria.getStdNm() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStdNm(), Std_.stdNm));
            }
            if (criteria.getStdExpDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getStdExpDt(), Std_.stdExpDt));
            }
            if (criteria.getRemainDays() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRemainDays(), Std_.remainDays));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Std_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Std_.lstMtnDt));
            }
        }
        return specification;
    }
}
