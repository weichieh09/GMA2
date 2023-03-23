package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cerf;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.annotations.QueryHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class CerfRepositoryWithBagRelationshipsImpl implements CerfRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Cerf> fetchBagRelationships(Optional<Cerf> cerf) {
        return cerf.map(this::fetchProds).map(this::fetchStds);
    }

    @Override
    public Page<Cerf> fetchBagRelationships(Page<Cerf> cerfs) {
        return new PageImpl<>(fetchBagRelationships(cerfs.getContent()), cerfs.getPageable(), cerfs.getTotalElements());
    }

    @Override
    public List<Cerf> fetchBagRelationships(List<Cerf> cerfs) {
        return Optional.of(cerfs).map(this::fetchProds).map(this::fetchStds).orElse(Collections.emptyList());
    }

    Cerf fetchProds(Cerf result) {
        return entityManager
            .createQuery("select cerf from Cerf cerf left join fetch cerf.prods where cerf is :cerf", Cerf.class)
            .setParameter("cerf", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Cerf> fetchProds(List<Cerf> cerfs) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, cerfs.size()).forEach(index -> order.put(cerfs.get(index).getId(), index));
        List<Cerf> result = entityManager
            .createQuery("select distinct cerf from Cerf cerf left join fetch cerf.prods where cerf in :cerfs", Cerf.class)
            .setParameter("cerfs", cerfs)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }

    Cerf fetchStds(Cerf result) {
        return entityManager
            .createQuery("select cerf from Cerf cerf left join fetch cerf.stds where cerf is :cerf", Cerf.class)
            .setParameter("cerf", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Cerf> fetchStds(List<Cerf> cerfs) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, cerfs.size()).forEach(index -> order.put(cerfs.get(index).getId(), index));
        List<Cerf> result = entityManager
            .createQuery("select distinct cerf from Cerf cerf left join fetch cerf.stds where cerf in :cerfs", Cerf.class)
            .setParameter("cerfs", cerfs)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
