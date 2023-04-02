package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfMark;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfMark entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfMarkRepository extends JpaRepository<CerfMark, Long>, JpaSpecificationExecutor<CerfMark> {}
