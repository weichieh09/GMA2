package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cerf;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cerf entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfRepository extends JpaRepository<Cerf, Long>, JpaSpecificationExecutor<Cerf> {}
