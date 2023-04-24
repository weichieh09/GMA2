package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.service.Wcc421Service;
import com.wcc.gma2.service.Wcc421ViewQueryService;
import com.wcc.gma2.service.criteria.Wcc421ViewCriteria;
import com.wcc.gma2.service.dto.Wcc421ViewDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;

@Slf4j
@RestController
@RequestMapping("/api/wcc421")
public class Wcc421Controller {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc421ViewQueryService wcc421ViewQueryService;

    @Autowired
    private Wcc421Service wcc421Service;

    /**
     * GET /cerfList : 根據條件和分頁信息獲取一頁證書視圖。
     *
     * @param criteria  用於篩選結果的條件。
     * @param pageable  分頁信息。
     * @return 帶有200狀態碼（OK）和證書視圖列表的ResponseEntity。
     */
    @GetMapping("/cerfList")
    public ResponseEntity<List<Wcc421ViewDTO>> cerfList(Wcc421ViewCriteria criteria, Pageable pageable) {
        // 使用查詢服務 wcc421ViewQueryService 查找與條件和分頁信息匹配的證書視圖。
        Page<Wcc421ViewDTO> page = wcc421ViewQueryService.findByCriteria(criteria, pageable);
        // 使用 PaginationUtil 生成 HTTP 響應頭，包括下一頁和上一頁的鏈接（如果適用）。
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        // 獲取頁面上證書的狀態，並在 Response 中返回證書視圖和分頁頭。
        return ResponseEntity.ok().headers(headers).body(wcc421Service.getCerfStatus(page.getContent()));
    }
}
