package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CountryMark;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CountryMark entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CountryMarkRepository extends JpaRepository<CountryMark, Long>, JpaSpecificationExecutor<CountryMark> {}
