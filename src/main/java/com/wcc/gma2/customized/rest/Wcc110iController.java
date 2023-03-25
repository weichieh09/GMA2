package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.Wcc111iReq;
import com.wcc.gma2.customized.service.Wcc110iService;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.domain.Cerf;
import com.wcc.gma2.repository.CerfRepository;
import com.wcc.gma2.service.dto.CerfDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/dev")
public class Wcc110iController {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc110iService wcc110iService;

    @RequestMapping("/test")
    public String test() {
        return CLASS_NAME;
    }

    @PostMapping("/wcc111i")
    public ResponseEntity<ResponseDTO> wcc111i(@RequestBody Wcc111iReq req) {
        log.info("{}", req);
        HttpHeaders headers = new HttpHeaders();
        ResponseDTO res = new ResponseDTO<>();

        Long prodId = wcc110iService.findProdId(req);
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "id");
        Page<CerfDTO> cerfByProdId = wcc110iService.findCerfByProdId(prodId, pageRequest);
        //        List<CerfDTO> content = wcc110iService.displayWcc111i(cerfByProdId.getContent());

        res.setContent(cerfByProdId.getContent());
        res.setStatusCode(StatusCode.SUCCESS);
        return ResponseEntity.ok().headers(headers).body(res);
    }
}
