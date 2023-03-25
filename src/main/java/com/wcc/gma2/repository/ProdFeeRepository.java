package com.wcc.gma2.repository;

import com.wcc.gma2.domain.ProdFee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProdFee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdFeeRepository extends JpaRepository<ProdFee, Long>, JpaSpecificationExecutor<ProdFee> {}
