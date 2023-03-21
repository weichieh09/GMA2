package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cerf2ProdView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cerf2ProdView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Cerf2ProdViewRepository extends JpaRepository<Cerf2ProdView, Long>, JpaSpecificationExecutor<Cerf2ProdView> {}
