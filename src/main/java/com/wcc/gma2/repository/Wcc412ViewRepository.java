package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Wcc412View;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Wcc412View entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Wcc412ViewRepository extends JpaRepository<Wcc412View, Long>, JpaSpecificationExecutor<Wcc412View> {}
