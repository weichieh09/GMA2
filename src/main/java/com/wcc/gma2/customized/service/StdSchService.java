package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.customized.utils.LongFilterUtils;
import com.wcc.gma2.customized.utils.StringFilterUtils;
import com.wcc.gma2.service.*;
import com.wcc.gma2.service.criteria.CerfCriteria;
import com.wcc.gma2.service.criteria.CerfStdCriteria;
import com.wcc.gma2.service.criteria.StdCriteria;
import com.wcc.gma2.service.dto.CerfDTO;
import com.wcc.gma2.service.dto.CerfStdDTO;
import com.wcc.gma2.service.dto.StdDTO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class StdSchService {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private StdQueryService stdQueryService;

    @Autowired
    private StdService stdService;

    @Autowired
    private CerfStdQueryService cerfStdQueryService;

    @Autowired
    private CerfQueryService cerfQueryService;

    @Autowired
    private CerfService cerfService;

    public void checkStdStatus() {
        StdCriteria stdCriteria = new StdCriteria();
        stdCriteria.setStatus(StringFilterUtils.toNotEqualStringFilter(CerfStatusTypeList.FAILURE.getText()));
        List<StdDTO> byCriteria = stdQueryService.findByCriteria(stdCriteria);
        if (byCriteria != null && !byCriteria.isEmpty()) {
            for (StdDTO dto : byCriteria) {
                String cerfStatus = this.getStdStatus(dto.getExpDt());
                if (!dto.getStatus().equals(cerfStatus)) {
                    dto.setStatus(cerfStatus);
                    stdService.save(dto);
                    this.checkCerf(dto.getId());
                }
            }
        }
    }

    private void checkCerf(Long stdId) {
        CerfStdCriteria criteria = new CerfStdCriteria();
        criteria.setStdId(LongFilterUtils.toEqualLongFilter(stdId));
        List<CerfStdDTO> byCriteria = cerfStdQueryService.findByCriteria(criteria);
        if (byCriteria != null && !byCriteria.isEmpty()) {
            for (CerfStdDTO dto : byCriteria) {
                Long cerfId = dto.getCerf().getId();
                CerfCriteria cerfCriteria = new CerfCriteria();
                cerfCriteria.setId(LongFilterUtils.toEqualLongFilter(cerfId));
                cerfCriteria.setStatus(StringFilterUtils.toNotEqualStringFilter(CerfStatusTypeList.DELETE.getValue()));
                List<CerfDTO> byCriteria1 = cerfQueryService.findByCriteria(cerfCriteria);
                if (byCriteria1 != null && !byCriteria1.isEmpty()) {
                    CerfDTO cerfDTO = byCriteria1.get(0);
                    cerfDTO.setStatus(CerfStatusTypeList.FAILURE.getValue());
                    cerfService.save(cerfDTO);
                }
            }
        }
    }

    private String getStdStatus(LocalDate expDt) {
        Long until = LocalDate.now().until(expDt, ChronoUnit.DAYS);
        if (until >= 0) return "有效"; else return "失效";
    }
}
