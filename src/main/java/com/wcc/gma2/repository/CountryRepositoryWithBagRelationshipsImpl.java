package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Country;
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
public class CountryRepositoryWithBagRelationshipsImpl implements CountryRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Country> fetchBagRelationships(Optional<Country> country) {
        return country.map(this::fetchStds);
    }

    @Override
    public Page<Country> fetchBagRelationships(Page<Country> countries) {
        return new PageImpl<>(fetchBagRelationships(countries.getContent()), countries.getPageable(), countries.getTotalElements());
    }

    @Override
    public List<Country> fetchBagRelationships(List<Country> countries) {
        return Optional.of(countries).map(this::fetchStds).orElse(Collections.emptyList());
    }

    Country fetchStds(Country result) {
        return entityManager
            .createQuery("select country from Country country left join fetch country.stds where country is :country", Country.class)
            .setParameter("country", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Country> fetchStds(List<Country> countries) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, countries.size()).forEach(index -> order.put(countries.get(index).getId(), index));
        List<Country> result = entityManager
            .createQuery(
                "select distinct country from Country country left join fetch country.stds where country in :countries",
                Country.class
            )
            .setParameter("countries", countries)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
