package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.Wcc101Req;
import com.wcc.gma2.customized.service.Wcc100Service;
import com.wcc.gma2.domain.CerfSearchView;
import com.wcc.gma2.repository.CerfSearchViewRepository;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private CerfSearchViewRepository cerfSearchViewRepository;

    /* 圖用 */
    @PostMapping("/wcc101")
    public ResponseEntity<ResponseDTO> wcc101(@RequestBody Wcc101Req req) {
        ResponseDTO responseDTO = new ResponseDTO<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        //        Pageable pageable = PageRequest.of(0, 20, Sort.Direction.DESC, "id");

        List<CerfSearchView> list = cerfSearchViewRepository.findAllDistinctList(req.getApplId(), req.getMnfctrId(), req.getFctyId());

        // 圖1
        Map<String, Long> chart1 = wcc100Service.getChart1(list);
        // 圖2
        Map<String, Long> chart2 = wcc100Service.getChart2(list);
        // 圖3
        Map<String, Long> chart3 = wcc100Service.getChart3(list);

        return ResponseEntity.ok().headers(httpHeaders).body(responseDTO);
    }
}
