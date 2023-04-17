package com.wcc.gma2.repository;

import com.wcc.gma2.domain.Wcc412View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Wcc412View entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Wcc412ViewRepository extends JpaRepository<Wcc412View, Long>, JpaSpecificationExecutor<Wcc412View> {
    @Query(
        value = "SELECT *\n" +
        "FROM wcc_412_view AS A\n" +
        "INNER JOIN (\n" +
        "SELECT MAX(id) AS ID, cerf_id\n" +
        "FROM wcc_412_view\n" +
        "WHERE\n" +
        " country_id like %:countryId%\n" +
        " AND\n" +
        " prod_no like %:prodNo%\n" +
        " AND\n" +
        " prod_ch_name like %:prodChName%\n" +
        "GROUP BY cerf_id \n" +
        ") AS B\n" +
        "ON A.ID = B.ID",
        nativeQuery = true
    )
    Page<Wcc412View> findForWcc412View(
        @Param("countryId") String countryId,
        @Param("prodNo") String prodNo,
        @Param("prodChName") String prodChName,
        Pageable pageable
    );
}
