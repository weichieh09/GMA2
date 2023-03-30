package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Sticker;
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
public class StickerRepositoryWithBagRelationshipsImpl implements StickerRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Sticker> fetchBagRelationships(Optional<Sticker> sticker) {
        return sticker.map(this::fetchMarks);
    }

    @Override
    public Page<Sticker> fetchBagRelationships(Page<Sticker> stickers) {
        return new PageImpl<>(fetchBagRelationships(stickers.getContent()), stickers.getPageable(), stickers.getTotalElements());
    }

    @Override
    public List<Sticker> fetchBagRelationships(List<Sticker> stickers) {
        return Optional.of(stickers).map(this::fetchMarks).orElse(Collections.emptyList());
    }

    Sticker fetchMarks(Sticker result) {
        return entityManager
            .createQuery("select sticker from Sticker sticker left join fetch sticker.marks where sticker is :sticker", Sticker.class)
            .setParameter("sticker", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Sticker> fetchMarks(List<Sticker> stickers) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, stickers.size()).forEach(index -> order.put(stickers.get(index).getId(), index));
        List<Sticker> result = entityManager
            .createQuery(
                "select distinct sticker from Sticker sticker left join fetch sticker.marks where sticker in :stickers",
                Sticker.class
            )
            .setParameter("stickers", stickers)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
