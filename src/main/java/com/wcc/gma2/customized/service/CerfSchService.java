package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.customized.utils.StringFilterUtils;
import com.wcc.gma2.service.CerfQueryService;
import com.wcc.gma2.service.CerfService;
import com.wcc.gma2.service.criteria.CerfCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class CerfSchService {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CerfQueryService cerfQueryService;

    @Autowired
    private CerfService cerfService;

    public void checkCerfStatus() {
        CerfCriteria cerfCriteria = new CerfCriteria();
        List<String> statusList = new ArrayList<>();
        statusList.add(CerfStatusTypeList.DELETE.getValue());
        statusList.add(CerfStatusTypeList.FAILURE.getValue());
        cerfCriteria.setStatus(StringFilterUtils.toNotInStringFilter(statusList));
        List<CerfDTO> byCriteria = cerfQueryService.findByCriteria(cerfCriteria);
        if (byCriteria != null && !byCriteria.isEmpty()) {
            for (CerfDTO dto : byCriteria) {
                String cerfStatus = this.getCerfStatus(dto.getExpDt());
                if (!dto.getStatus().equals(cerfStatus)) {
                    dto.setStatus(cerfStatus);
                    cerfService.save(dto);
                }
            }
        }
    }

    private String getCerfStatus(LocalDate expDt) {
        Long until = LocalDate.now().until(expDt, ChronoUnit.DAYS);
        if (until > 90) return CerfStatusTypeList.VALID.getValue(); else if (
            until >= 0
        ) return CerfStatusTypeList.MAINTEN.getValue(); else return CerfStatusTypeList.FAILURE.getValue();
    }
}
