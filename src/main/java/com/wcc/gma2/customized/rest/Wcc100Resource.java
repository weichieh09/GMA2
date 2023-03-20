package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.Wcc101Req;
import com.wcc.gma2.customized.dto.Wcc101Res;
import com.wcc.gma2.customized.service.Wcc100Service;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf}.
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class Wcc100Resource {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc100Service wcc100Service;

    /* 圖用 */
    @PostMapping("/wcc101")
    public ResponseEntity<ResponseDTO> wcc101(@RequestBody Wcc101Req req) {
        Wcc101Res resData = new Wcc101Res();
        ResponseDTO responseDTO = new ResponseDTO<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        // 查 CerfSearchView
        List<CerfSearchViewDTO> allCsv = wcc100Service.findAllCsv(req.getApplId(), req.getMnfctrId(), req.getFctyId());
        // 去除重複結果
        List<CerfSearchViewDTO> distinctCsv = wcc100Service.distinctCsv(allCsv);

        // 圖1
        resData.setChart1(wcc100Service.getChart1(distinctCsv));
        // 圖2
        resData.setChart2(wcc100Service.getChart2(distinctCsv));
        // 圖3
        resData.setChart3(wcc100Service.getChart3(distinctCsv));

        responseDTO.setContent(resData);
        responseDTO.setStatusCode(StatusCode.SUCCESS);

        return ResponseEntity.ok().headers(httpHeaders).body(responseDTO);
    }
}
