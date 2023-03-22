package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.Wcc101Req;
import com.wcc.gma2.customized.dto.Wcc101Res;
import com.wcc.gma2.customized.dto.Wcc102Res;
import com.wcc.gma2.customized.service.Wcc100Service;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.service.CerfSearchViewQueryService;
import com.wcc.gma2.service.criteria.CerfSearchViewCriteria;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
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

/**
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf}.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class Wcc100Resource {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc100Service wcc100Service;

    @Autowired
    private CerfSearchViewQueryService cerfSearchViewQueryService;

    /*
     * 圖表用
     *
     * http://localhost:8082/test/wcc101
     * { "applId" : "22099738" }
     *
     *  */
    @PostMapping("/wcc101i")
    public ResponseEntity<ResponseDTO> wcc101(@RequestBody Wcc101Req req) {
        Wcc101Res resData = new Wcc101Res();
        ResponseDTO responseDTO = new ResponseDTO<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        // 查 CerfSearchView
        List<CerfSearchViewDTO> allCsv = wcc100Service.findAllCsv(req.getApplId(), req.getMnfctrId(), req.getFctyId());
        // 去除重複結果
        List<CerfSearchViewDTO> distinctCsv = wcc100Service.distinctCsv(allCsv);

        // 圖1
        resData.setEChart1(wcc100Service.getEChart1(distinctCsv));
        // 圖2
        resData.setEChart2(wcc100Service.getEChart2(distinctCsv));
        // 圖3
        resData.setEChart3(wcc100Service.getEChart3(distinctCsv));

        responseDTO.setContent(resData);
        responseDTO.setStatusCode(StatusCode.SUCCESS);

        return ResponseEntity.ok().headers(httpHeaders).body(responseDTO);
    }

    /*
     * 列表用
     *
     * http://localhost:8082/test/wcc102?applId.equals=22099738&page=0&size=5
     *
     * */
    @GetMapping("/wcc102i")
    public ResponseEntity<ResponseDTO> wcc102(
        CerfSearchViewCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        Wcc102Res resData = new Wcc102Res();
        ResponseDTO responseDTO = new ResponseDTO<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        // 查 CerfSearchView
        List<CerfSearchViewDTO> allCsv = cerfSearchViewQueryService.findByCriteria(criteria);
        // 去除重複結果
        List<CerfSearchViewDTO> distinctCsv = wcc100Service.distinctCsv(allCsv);
        // 把結果分頁化
        Page<CerfSearchViewDTO> page = wcc100Service.pageableCsv(distinctCsv, pageable);
        // 分頁相關資訊放入 httpHeaders
        httpHeaders = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);

        resData.setSearchName(wcc100Service.findSearchName(criteria));
        resData.setCsvList(page.getContent());

        responseDTO.setContent(resData);
        responseDTO.setStatusCode(StatusCode.SUCCESS);

        return ResponseEntity.ok().headers(httpHeaders).body(responseDTO);
    }
}
