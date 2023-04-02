package com.wcc.gma2.repository;

import com.wcc.gma2.domain.ProdCountry;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProdCountry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdCountryRepository extends JpaRepository<ProdCountry, Long>, JpaSpecificationExecutor<ProdCountry> {}
