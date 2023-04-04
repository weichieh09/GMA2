package com.wcc.gma2.customized.rest;

import com.wcc.gma2.service.CompanyQueryService;
import com.wcc.gma2.service.CountryQueryService;
import com.wcc.gma2.service.criteria.CompanyCriteria;
import com.wcc.gma2.service.criteria.CountryCriteria;
import com.wcc.gma2.service.dto.CompanyDTO;
import com.wcc.gma2.service.dto.CountryDTO;
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
@RequestMapping("/api/wcc310")
public class Wcc310 {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CountryQueryService countryQueryService;

    @Autowired
    private CompanyQueryService companyQueryService;

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
}
