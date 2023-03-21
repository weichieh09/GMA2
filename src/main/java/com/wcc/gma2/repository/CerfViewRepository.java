package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfViewRepository extends JpaRepository<CerfView, Long>, JpaSpecificationExecutor<CerfView> {}
