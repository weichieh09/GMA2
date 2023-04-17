package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.dto.Wcc321FeeListReq;
import com.wcc.gma2.customized.dto.Wcc321FeeListRes;
import com.wcc.gma2.customized.service.Wcc321Service;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/wcc321")
public class Wcc321Controller {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc321Service wcc321Service;

    @GetMapping("/countryList")
    public ResponseEntity<List<SelectListDTO>> countryList() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(wcc321Service.findCountryList());
    }

    @GetMapping("/feeList")
    public ResponseEntity<Wcc321FeeListRes> feeList(Wcc321FeeListReq req) {
        Wcc321FeeListRes result = wcc321Service.findForWcc321Vue(req);
        return ResponseEntity.ok().body(result);
    }
}
