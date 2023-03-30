package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Mark;
import com.wcc.gma2.repository.MarkRepository;
import com.wcc.gma2.service.criteria.MarkCriteria;
import com.wcc.gma2.service.dto.MarkDTO;
import com.wcc.gma2.service.mapper.MarkMapper;
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
 * Service for executing complex queries for {@link Mark} entities in the database.
 * The main input is a {@link MarkCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link MarkDTO} or a {@link Page} of {@link MarkDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class MarkQueryService extends QueryService<Mark> {

    private final Logger log = LoggerFactory.getLogger(MarkQueryService.class);

    private final MarkRepository markRepository;

    private final MarkMapper markMapper;

    public MarkQueryService(MarkRepository markRepository, MarkMapper markMapper) {
        this.markRepository = markRepository;
        this.markMapper = markMapper;
    }

    /**
     * Return a {@link List} of {@link MarkDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<MarkDTO> findByCriteria(MarkCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Mark> specification = createSpecification(criteria);
        return markMapper.toDto(markRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link MarkDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<MarkDTO> findByCriteria(MarkCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Mark> specification = createSpecification(criteria);
        return markRepository.findAll(specification, page).map(markMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(MarkCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Mark> specification = createSpecification(criteria);
        return markRepository.count(specification);
    }

    /**
     * Function to convert {@link MarkCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Mark> createSpecification(MarkCriteria criteria) {
        Specification<Mark> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Mark_.id));
            }
            if (criteria.getMarkNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMarkNo(), Mark_.markNo));
            }
            if (criteria.getEnName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnName(), Mark_.enName));
            }
            if (criteria.getChName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getChName(), Mark_.chName));
            }
            if (criteria.getCountryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCountryId(), root -> root.join(Mark_.country, JoinType.LEFT).get(Country_.id))
                    );
            }
            if (criteria.getCerfId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCerfId(), root -> root.join(Mark_.cerfs, JoinType.LEFT).get(Cerf_.id))
                    );
            }
            if (criteria.getStickerId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getStickerId(), root -> root.join(Mark_.stickers, JoinType.LEFT).get(Sticker_.id))
                    );
            }
        }
        return specification;
    }
}
