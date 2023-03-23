package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Std;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Std entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StdRepository extends JpaRepository<Std, Long> {}
