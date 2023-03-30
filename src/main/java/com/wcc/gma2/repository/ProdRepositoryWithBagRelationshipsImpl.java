package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Prod;
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
public class ProdRepositoryWithBagRelationshipsImpl implements ProdRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Prod> fetchBagRelationships(Optional<Prod> prod) {
        return prod.map(this::fetchCountries).map(this::fetchStds);
    }

    @Override
    public Page<Prod> fetchBagRelationships(Page<Prod> prods) {
        return new PageImpl<>(fetchBagRelationships(prods.getContent()), prods.getPageable(), prods.getTotalElements());
    }

    @Override
    public List<Prod> fetchBagRelationships(List<Prod> prods) {
        return Optional.of(prods).map(this::fetchCountries).map(this::fetchStds).orElse(Collections.emptyList());
    }

    Prod fetchCountries(Prod result) {
        return entityManager
            .createQuery("select prod from Prod prod left join fetch prod.countries where prod is :prod", Prod.class)
            .setParameter("prod", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Prod> fetchCountries(List<Prod> prods) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, prods.size()).forEach(index -> order.put(prods.get(index).getId(), index));
        List<Prod> result = entityManager
            .createQuery("select distinct prod from Prod prod left join fetch prod.countries where prod in :prods", Prod.class)
            .setParameter("prods", prods)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }

    Prod fetchStds(Prod result) {
        return entityManager
            .createQuery("select prod from Prod prod left join fetch prod.stds where prod is :prod", Prod.class)
            .setParameter("prod", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Prod> fetchStds(List<Prod> prods) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, prods.size()).forEach(index -> order.put(prods.get(index).getId(), index));
        List<Prod> result = entityManager
            .createQuery("select distinct prod from Prod prod left join fetch prod.stds where prod in :prods", Prod.class)
            .setParameter("prods", prods)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
