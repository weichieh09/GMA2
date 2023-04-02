package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CountryCert;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CountryCert entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CountryCertRepository extends JpaRepository<CountryCert, Long>, JpaSpecificationExecutor<CountryCert> {}
