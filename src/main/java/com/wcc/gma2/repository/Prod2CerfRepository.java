package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Prod2Cerf;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Prod2Cerf entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Prod2CerfRepository extends JpaRepository<Prod2Cerf, Long>, JpaSpecificationExecutor<Prod2Cerf> {}
