package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.dto.Wcc312CerfListRes;
import com.wcc.gma2.customized.service.Wcc312Service;
import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.service.CountryCertQueryService;
import com.wcc.gma2.service.criteria.CountryCertCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CountryCertDTO;
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
@RequestMapping("/api/wcc312")
public class Wcc312Controller {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc312Service wcc312Service;

    @Autowired
    private CountryCertQueryService countryCertQueryService;

    @GetMapping("/countryList")
    public ResponseEntity<List<SelectListDTO>> countryList() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(wcc312Service.findCountryList());
    }

    @GetMapping("/cerfStatusList")
    public ResponseEntity<List<SelectListDTO>> cerfStatusList() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(CerfStatusTypeList.getCerfStatusTypeList());
    }

    @GetMapping("/cerfList")
    public ResponseEntity<List<Wcc312CerfListRes>> cerfList(CountryCertCriteria req, Pageable pageable) {
        Page<CountryCertDTO> page = countryCertQueryService.findByCriteria(req, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(wcc312Service.getCerfList(page.getContent()));
    }

    @PostMapping("/removeCerf")
    public ResponseEntity<ResponseDTO> removeCerf(@RequestBody CerfDTO req) {
        log.info(CLASS_NAME + ".removeCerf");
        ResponseDTO res = new ResponseDTO();
        res.setStatusCode(StatusCode.SUCCESS);
        res.setContent(wcc312Service.removeCerf(req));
        return ResponseEntity.ok().body(res);
    }
}
