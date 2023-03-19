package com.wcc.gma2.repository;

import com.wcc.gma2.domain.CerfSearchView;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CerfSearchView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CerfSearchViewRepository extends JpaRepository<CerfSearchView, Long>, JpaSpecificationExecutor<CerfSearchView> {
    @Query(
        value = "" +
        "SELECT cerf_no, cerf_ver, fee_cd, fee_desc, fee, area_cd, area_desc, sts_cd, sts_desc, appl_id, mnfctr_nm_ch\n" +
        "FROM gma2.dbo.cerf_search_view\n" +
        "WHERE\n" +
        "appl_id LIKE :applId \n" +
        "OR\n" +
        "fcty_id LIKE :fctyId\n" +
        "OR\n" +
        "mnfctr_id LIKE :mnfctrId\n" +
        "GROUP BY cerf_no, cerf_ver, fee_cd, fee_desc, fee, area_cd, area_desc, sts_cd, sts_desc, appl_id, mnfctr_nm_ch" +
        ""
    )
    Page<CerfSearchView> findAllDistinctPage(
        @Param("applId") String applId,
        @Param("fctyId") String fctyId,
        @Param("mnfctrId") String mnfctrId,
        Pageable pageable
    );

    @Query(
        value = "" +
        "SELECT cerf_no, cerf_ver, fee_cd, fee_desc, fee, area_cd, area_desc, sts_cd, sts_desc, appl_id, mnfctr_nm_ch\n" +
        "FROM gma2.dbo.cerf_search_view\n" +
        "WHERE\n" +
        "appl_id LIKE :applId \n" +
        "OR\n" +
        "fcty_id LIKE :fctyId\n" +
        "OR\n" +
        "mnfctr_id LIKE :mnfctrId\n" +
        "GROUP BY cerf_no, cerf_ver, fee_cd, fee_desc, fee, area_cd, area_desc, sts_cd, sts_desc, appl_id, mnfctr_nm_ch" +
        ""
    )
    List<CerfSearchView> findAllDistinctList(
        @Param("applId") String applId,
        @Param("fctyId") String fctyId,
        @Param("mnfctrId") String mnfctrId
    );
}
