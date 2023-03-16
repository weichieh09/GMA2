package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Prod2Std;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Prod2Std entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Prod2StdRepository extends JpaRepository<Prod2Std, Long>, JpaSpecificationExecutor<Prod2Std> {}
