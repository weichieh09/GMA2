package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cerf2StdView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cerf2StdView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Cerf2StdViewRepository extends JpaRepository<Cerf2StdView, Long>, JpaSpecificationExecutor<Cerf2StdView> {}
