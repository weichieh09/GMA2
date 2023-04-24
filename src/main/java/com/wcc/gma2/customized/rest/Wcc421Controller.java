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

    @GetMapping("/cerfList")
    public ResponseEntity<List<Wcc421ViewDTO>> cerfList(Wcc421ViewCriteria criteria, Pageable pageable) {
        Page<Wcc421ViewDTO> page = wcc421ViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(wcc421Service.getCerfStatus(page.getContent()));
    }
}
