package com.wcc.gma2.repository;

import com.wcc.gma2.domain.StdFee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the StdFee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StdFeeRepository extends JpaRepository<StdFee, Long>, JpaSpecificationExecutor<StdFee> {}
