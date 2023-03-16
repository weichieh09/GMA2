package com.wcc.gma2.repository;

import com.wcc.gma2.domain.AreaDesc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AreaDesc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AreaDescRepository extends JpaRepository<AreaDesc, Long>, JpaSpecificationExecutor<AreaDesc> {}
