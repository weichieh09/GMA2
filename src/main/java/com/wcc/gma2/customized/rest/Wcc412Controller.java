package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.service.Wcc312Service;
import com.wcc.gma2.customized.service.Wcc412Service;
import com.wcc.gma2.domain.Wcc412View;
import com.wcc.gma2.service.Wcc412ViewQueryService;
import com.wcc.gma2.service.criteria.Wcc412ViewCriteria;
import com.wcc.gma2.service.dto.Wcc412ViewDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;

@Slf4j
@RestController
@RequestMapping("/api/wcc412")
public class Wcc412Controller {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc312Service wcc312Service;

    @Autowired
    private Wcc412Service wcc412Service;

    @Autowired
    private Wcc412ViewQueryService wcc412ViewQueryService;

    /**
     * GET /countryList：取得國家清單。
     *
     * @return 帶有200狀態碼（OK）和國家清單的ResponseEntity。
     */
    @GetMapping("/countryList")
    public ResponseEntity<List<SelectListDTO>> countryList() {
        // 設置HTTP響應頭。
        HttpHeaders headers = new HttpHeaders();
        // 使用 wcc312Service 查找國家清單，並返回ResponseEntity。
        return ResponseEntity.ok().headers(headers).body(wcc312Service.findCountryList());
    }

    /**
     * GET /cerfList：根據條件和分頁信息取得一页證書視圖。
     *
     * @param criteria 用於篩選結果的條件。
     * @param pageable 分頁信息。
     * @return 帶有200狀態碼（OK）和證書視圖列表的ResponseEntity。
     */
    //    @GetMapping("/cerfList")
    //    public ResponseEntity<List<Wcc412View>> cerfList(Wcc412ViewCriteria criteria, Pageable pageable) {
    //        // 使用查詢服務 wcc412Service 查找與條件和分頁信息匹配的證書視圖。
    //        Page<Wcc412View> page = wcc412Service.findForWcc412View(criteria, pageable);
    //        // 使用 PaginationUtil 生成 HTTP 響應頭，包括下一頁和上一頁的鏈接（如果適用）。
    //        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
    //        // 獲取頁面上證書的狀態，並在 Response 中返回證書視圖和分頁頭。
    //        return ResponseEntity.ok().headers(headers).body(wcc412Service.getCerfStatus(page.getContent()));
    //    }

    @GetMapping("/cerfList")
    public ResponseEntity<List<Wcc412ViewDTO>> cerfList(Wcc412ViewCriteria criteria, Pageable pageable) {
        Page<Wcc412ViewDTO> page = wcc412ViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(wcc412Service.getCerfStatus(page.getContent()));
    }
}
