package com.wcc.gma2.repository;

import com.wcc.gma2.domain.FeeDesc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FeeDesc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FeeDescRepository extends JpaRepository<FeeDesc, Long>, JpaSpecificationExecutor<FeeDesc> {}
