package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Prod2Fcty;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Prod2Fcty entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Prod2FctyRepository extends JpaRepository<Prod2Fcty, Long>, JpaSpecificationExecutor<Prod2Fcty> {}
