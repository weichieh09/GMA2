package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Mnfctr;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Mnfctr entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MnfctrRepository extends JpaRepository<Mnfctr, Long>, JpaSpecificationExecutor<Mnfctr> {}
