package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Wcc421View;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Wcc421View entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Wcc421ViewRepository extends JpaRepository<Wcc421View, Long>, JpaSpecificationExecutor<Wcc421View> {}
