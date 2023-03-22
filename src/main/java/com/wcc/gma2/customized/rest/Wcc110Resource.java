package com.wcc.gma2.customized.rest;

import com.wcc.gma2.customized.dto.ResponseDTO;
import com.wcc.gma2.customized.dto.Wcc111Res;
import com.wcc.gma2.customized.service.Wcc110Service;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.service.dto.Cerf2MnfctrViewDTO;
import com.wcc.gma2.service.dto.CerfDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link com.wcc.gma2.domain.Cerf}.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class Wcc110Resource {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc110Service wcc110Service;

    /*
     * 證書詳情用
     *
     * http://localhost:8082/api/wcc111i/CI435060200161/00
     *
     * */
    @GetMapping("/wcc111i/{cerfNo}/{cerfVer}")
    public ResponseEntity<ResponseDTO> wcc111(@PathVariable String cerfNo, @PathVariable String cerfVer) {
        Wcc111Res resData = new Wcc111Res();
        ResponseDTO responseDTO = new ResponseDTO<>();
        HttpHeaders httpHeaders = new HttpHeaders();

        // 查 Cerf
        List<CerfDTO> byCerf = wcc110Service.findByCerf(cerfNo, cerfVer);
        // 如果有查到資料才繼續
        if (byCerf.size() > 0) {
            // 將 查Cerf 結果寫入
            resData.setCerf(byCerf.get(0));
            // 將 查Cerf2MnfctrView 結果寫入
            resData.setCerf2Mnfctr(wcc110Service.findByCerf2MnfctrView(cerfNo, cerfVer));
            // 將 查Cerf2ProdView 結果寫入
            resData.setCerf2Prod(wcc110Service.findByCerf2ProdView(cerfNo, cerfVer));
            // 將 查Cerf2StdView 結果寫入
            resData.setCerf2Std(wcc110Service.findByCerf2StdView(cerfNo, cerfVer));
            // 將 查CerfView 結果寫入
            resData.setCerf2CerfFee(wcc110Service.findByCerfView(cerfNo, cerfVer));

            responseDTO.setContent(resData);
            responseDTO.setStatusCode(StatusCode.SUCCESS);
        }

        return ResponseEntity.ok().headers(httpHeaders).body(responseDTO);
    }
}
