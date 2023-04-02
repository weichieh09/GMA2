package com.wcc.gma2.repository;

import com.wcc.gma2.domain.StickerMark;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the StickerMark entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StickerMarkRepository extends JpaRepository<StickerMark, Long>, JpaSpecificationExecutor<StickerMark> {}
