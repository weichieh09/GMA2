package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfStd;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfStd entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfStdRepository extends JpaRepository<CerfStd, Long>, JpaSpecificationExecutor<CerfStd> {}
