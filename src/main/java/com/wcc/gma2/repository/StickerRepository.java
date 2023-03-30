package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Sticker;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Sticker entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StickerRepository extends JpaRepository<Sticker, Long>, JpaSpecificationExecutor<Sticker> {}
