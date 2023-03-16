package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cref2Std;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cref2Std entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Cref2StdRepository extends JpaRepository<Cref2Std, Long>, JpaSpecificationExecutor<Cref2Std> {}
