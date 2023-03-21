package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Cerf2MnfctrView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cerf2MnfctrView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Cerf2MnfctrViewRepository extends JpaRepository<Cerf2MnfctrView, Long>, JpaSpecificationExecutor<Cerf2MnfctrView> {}
