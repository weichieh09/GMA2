package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.dto.Wcc312CerfListRes;
import com.wcc.gma2.customized.dto.Wcc412CerfListReq;
import com.wcc.gma2.customized.service.Wcc312Service;
import com.wcc.gma2.customized.service.Wcc412Service;
import com.wcc.gma2.service.CountryCertQueryService;
import com.wcc.gma2.service.ProdCountryQueryService;
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
@RequestMapping("/api/wcc412")
public class Wcc412Controller {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc312Service wcc312Service;

    @Autowired
    private Wcc412Service wcc412Service;

    @GetMapping("/countryList")
    public ResponseEntity<List<SelectListDTO>> countryList() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(wcc312Service.findCountryList());
    }

    //    @GetMapping("/cerfStatusList")
    //    public ResponseEntity<List<SelectListDTO>> cerfStatusList() {
    //        HttpHeaders headers = new HttpHeaders();
    //        return ResponseEntity.ok().headers(headers).body(CerfStatusTypeList.getCerfStatusTypeList());
    //    }

    @PostMapping("/cerfList")
    public ResponseEntity<List<Wcc312CerfListRes>> cerfList(@RequestBody Wcc412CerfListReq req) {
        //        Pageable pageable = wcc412Service.getPageable(req);
        //        Page<CerfDTO> page = wcc412Service.findCerfByCriteria(req, pageable);
        return ResponseEntity.ok().body(null);
    }
}