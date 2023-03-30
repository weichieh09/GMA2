package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Sticker;
import com.wcc.gma2.repository.StickerRepository;
import com.wcc.gma2.service.criteria.StickerCriteria;
import com.wcc.gma2.service.dto.StickerDTO;
import com.wcc.gma2.service.mapper.StickerMapper;
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
 * Service for executing complex queries for {@link Sticker} entities in the database.
 * The main input is a {@link StickerCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StickerDTO} or a {@link Page} of {@link StickerDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StickerQueryService extends QueryService<Sticker> {

    private final Logger log = LoggerFactory.getLogger(StickerQueryService.class);

    private final StickerRepository stickerRepository;

    private final StickerMapper stickerMapper;

    public StickerQueryService(StickerRepository stickerRepository, StickerMapper stickerMapper) {
        this.stickerRepository = stickerRepository;
        this.stickerMapper = stickerMapper;
    }

    /**
     * Return a {@link List} of {@link StickerDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StickerDTO> findByCriteria(StickerCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Sticker> specification = createSpecification(criteria);
        return stickerMapper.toDto(stickerRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StickerDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StickerDTO> findByCriteria(StickerCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Sticker> specification = createSpecification(criteria);
        return stickerRepository.findAll(specification, page).map(stickerMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StickerCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Sticker> specification = createSpecification(criteria);
        return stickerRepository.count(specification);
    }

    /**
     * Function to convert {@link StickerCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Sticker> createSpecification(StickerCriteria criteria) {
        Specification<Sticker> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Sticker_.id));
            }
            if (criteria.getStickerNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStickerNo(), Sticker_.stickerNo));
            }
            if (criteria.getMarkId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getMarkId(), root -> root.join(Sticker_.marks, JoinType.LEFT).get(Mark_.id))
                    );
            }
            if (criteria.getProdId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProdId(), root -> root.join(Sticker_.prod, JoinType.LEFT).get(Prod_.id))
                    );
            }
        }
        return specification;
    }
}
