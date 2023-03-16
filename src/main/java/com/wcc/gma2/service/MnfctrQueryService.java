package com.wcc.gma2.service;

import com.wcc.gma2.domain.*; // for static metamodels
import com.wcc.gma2.domain.Mnfctr;
import com.wcc.gma2.repository.MnfctrRepository;
import com.wcc.gma2.service.criteria.MnfctrCriteria;
import com.wcc.gma2.service.dto.MnfctrDTO;
import com.wcc.gma2.service.mapper.MnfctrMapper;
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
 * Service for executing complex queries for {@link Mnfctr} entities in the database.
 * The main input is a {@link MnfctrCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link MnfctrDTO} or a {@link Page} of {@link MnfctrDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class MnfctrQueryService extends QueryService<Mnfctr> {

    private final Logger log = LoggerFactory.getLogger(MnfctrQueryService.class);

    private final MnfctrRepository mnfctrRepository;

    private final MnfctrMapper mnfctrMapper;

    public MnfctrQueryService(MnfctrRepository mnfctrRepository, MnfctrMapper mnfctrMapper) {
        this.mnfctrRepository = mnfctrRepository;
        this.mnfctrMapper = mnfctrMapper;
    }

    /**
     * Return a {@link List} of {@link MnfctrDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<MnfctrDTO> findByCriteria(MnfctrCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Mnfctr> specification = createSpecification(criteria);
        return mnfctrMapper.toDto(mnfctrRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link MnfctrDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<MnfctrDTO> findByCriteria(MnfctrCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Mnfctr> specification = createSpecification(criteria);
        return mnfctrRepository.findAll(specification, page).map(mnfctrMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(MnfctrCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Mnfctr> specification = createSpecification(criteria);
        return mnfctrRepository.count(specification);
    }

    /**
     * Function to convert {@link MnfctrCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Mnfctr> createSpecification(MnfctrCriteria criteria) {
        Specification<Mnfctr> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Mnfctr_.id));
            }
            if (criteria.getUniNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUniNo(), Mnfctr_.uniNo));
            }
            if (criteria.getMnfctrNmEn() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrNmEn(), Mnfctr_.mnfctrNmEn));
            }
            if (criteria.getMnfctrNmCh() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMnfctrNmCh(), Mnfctr_.mnfctrNmCh));
            }
            if (criteria.getContact() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContact(), Mnfctr_.contact));
            }
            if (criteria.getEamil() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEamil(), Mnfctr_.eamil));
            }
            if (criteria.getAddr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddr(), Mnfctr_.addr));
            }
            if (criteria.getTel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTel(), Mnfctr_.tel));
            }
            if (criteria.getLstMtnUsr() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLstMtnUsr(), Mnfctr_.lstMtnUsr));
            }
            if (criteria.getLstMtnDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLstMtnDt(), Mnfctr_.lstMtnDt));
            }
        }
        return specification;
    }
}
