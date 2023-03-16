package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfImg;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfImg entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfImgRepository extends JpaRepository<CerfImg, Long>, JpaSpecificationExecutor<CerfImg> {}
