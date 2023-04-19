package com.wcc.gma2.repository;

import com.wcc.gma2.domain.FeeProdCerfCompany;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FeeProdCerfCompany entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FeeProdCerfCompanyRepository
    extends JpaRepository<FeeProdCerfCompany, Long>, JpaSpecificationExecutor<FeeProdCerfCompany> {
    @Query(
        value = "SELECT A.*\n" +
        "FROM gma2.dbo.fee_prod_cerf_company AS A\n" +
        "INNER JOIN (\n" +
        " SELECT MAX(id) AS ID, cerf_id\n" +
        " FROM wcc_412_view\n" +
        " WHERE\n" +
        "  country_id like %:countryId%\n" +
        "  AND\n" +
        "  prod_no = :prodNo\n" +
        "  AND\n" +
        "  prod_ch_name = :prodChName\n" +
        " GROUP BY cerf_id \n" +
        ") AS B\n" +
        "ON A.cerf_id = B.cerf_id\n" +
        "WHERE\n" +
        " A.fee_dt >= :startDate\n" +
        " AND\n" +
        " A.fee_dt <= :endDate",
        nativeQuery = true
    )
    List<FeeProdCerfCompany> findForWcc321Vue(
        @Param("countryId") String countryId,
        @Param("prodNo") String prodNo,
        @Param("prodChName") String prodChName,
        @Param("startDate") String startDate,
        @Param("endDate") String endDate
    );
}
