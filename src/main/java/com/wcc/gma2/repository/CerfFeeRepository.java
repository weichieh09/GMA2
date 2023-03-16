package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfFee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfFee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfFeeRepository extends JpaRepository<CerfFee, Long>, JpaSpecificationExecutor<CerfFee> {}
