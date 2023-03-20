package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfSearchView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfSearchView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfSearchViewRepository extends JpaRepository<CerfSearchView, Long>, JpaSpecificationExecutor<CerfSearchView> {}
