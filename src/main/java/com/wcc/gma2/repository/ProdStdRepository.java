package com.wcc.gma2.repository;

import com.wcc.gma2.domain.ProdStd;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProdStd entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdStdRepository extends JpaRepository<ProdStd, Long>, JpaSpecificationExecutor<ProdStd> {}
