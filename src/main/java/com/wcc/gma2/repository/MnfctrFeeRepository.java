package com.wcc.gma2.repository;

import com.wcc.gma2.domain.MnfctrFee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MnfctrFee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MnfctrFeeRepository extends JpaRepository<MnfctrFee, Long>, JpaSpecificationExecutor<MnfctrFee> {}
