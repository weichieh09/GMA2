package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.dto.Wcc311SaveAllReq;
import com.wcc.gma2.customized.dto.Wcc311SaveAllRes;
import com.wcc.gma2.customized.service.Wcc311Service;
import com.wcc.gma2.customized.type.FeeTypeList;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.service.*;
import com.wcc.gma2.service.criteria.*;
import com.wcc.gma2.service.dto.*;
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
@RequestMapping("/api/wcc311")
public class Wcc311Controller {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CountryQueryService countryQueryService;

    @Autowired
    private CompanyQueryService companyQueryService;

    @Autowired
    private ProdQueryService prodQueryService;

    @Autowired
    private StdQueryService stdQueryService;

    @Autowired
    private Wcc311Service wcc311Service;

    @Autowired
    private CountryMarkQueryService countryMarkQueryService;

    @GetMapping("/countryList")
    public ResponseEntity<List<CountryDTO>> countryList(CountryCriteria criteria, Pageable pageable) {
        Page<CountryDTO> page = countryQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/companyList")
    public ResponseEntity<List<CompanyDTO>> companyList(CompanyCriteria criteria, Pageable pageable) {
        Page<CompanyDTO> page = companyQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/prodList")
    public ResponseEntity<List<ProdDTO>> prodList(ProdCriteria criteria, Pageable pageable) {
        Page<ProdDTO> page = prodQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/stdList")
    public ResponseEntity<List<StdDTO>> stdList(StdCriteria criteria, Pageable pageable) {
        Page<StdDTO> page = stdQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/feeTypeList")
    public ResponseEntity<List<SelectListDTO>> feeTypeList() {
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(FeeTypeList.getFeeTypeList());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<ResponseDTO> saveAll(@RequestBody Wcc311SaveAllReq req) {
        Wcc311SaveAllRes resData = null;
        ResponseDTO res = new ResponseDTO<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        StatusCode statusCode = wcc311Service.saveAll(req);

        res.setContent(resData);
        res.setStatusCode(statusCode);
        return ResponseEntity.ok().headers(httpHeaders).body(res);
    }

    @GetMapping("/markList")
    public ResponseEntity<List<CountryMarkDTO>> markList(CountryMarkCriteria criteria, Pageable pageable) {
        Page<CountryMarkDTO> page = countryMarkQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
