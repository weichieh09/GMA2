package com.wcc.gma2.repository;

import com.wcc.gma2.domain.ProdSticker;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProdSticker entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdStickerRepository extends JpaRepository<ProdSticker, Long>, JpaSpecificationExecutor<ProdSticker> {}
