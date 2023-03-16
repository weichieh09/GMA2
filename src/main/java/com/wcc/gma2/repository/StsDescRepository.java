package com.wcc.gma2.repository;

import com.wcc.gma2.domain.StsDesc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the StsDesc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StsDescRepository extends JpaRepository<StsDesc, Long>, JpaSpecificationExecutor<StsDesc> {}
