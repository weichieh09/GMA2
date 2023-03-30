package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Sticker;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface StickerRepositoryWithBagRelationships {
    Optional<Sticker> fetchBagRelationships(Optional<Sticker> sticker);

    List<Sticker> fetchBagRelationships(List<Sticker> stickers);

    Page<Sticker> fetchBagRelationships(Page<Sticker> stickers);
}
