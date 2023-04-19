package com.wcc.gma2.customized.service;

import com.wcc.gma2.config.Constants;
import com.wcc.gma2.customized.dto.StdCompanyMailDTO;
import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.customized.type.StatusCode;
import com.wcc.gma2.customized.utils.LongFilterUtils;
import com.wcc.gma2.customized.utils.StringFilterUtils;
import com.wcc.gma2.service.CerfCompanyQueryService;
import com.wcc.gma2.service.CerfStdQueryService;
import com.wcc.gma2.service.MailService;
import com.wcc.gma2.service.criteria.CerfCompanyCriteria;
import com.wcc.gma2.service.criteria.CerfStdCriteria;
import com.wcc.gma2.service.dto.*;
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
public class WccStdService {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CerfStdQueryService cerfStdQueryService;

    @Autowired
    private CerfCompanyQueryService cerfCompanyQueryService;

    @Autowired
    private MailService mailService;

    public StatusCode sndMail(Long stdId) {
        try {
            CerfStdCriteria criteria = new CerfStdCriteria();
            criteria.setStdId(LongFilterUtils.toEqualLongFilter(stdId));
            List<CerfStdDTO> byCriteria = cerfStdQueryService.findByCriteria(criteria);
            for (CerfStdDTO cerfStdDTO : byCriteria) {
                StdDTO std = cerfStdDTO.getStd();
                CerfCompanyCriteria companyCriteria = new CerfCompanyCriteria();
                companyCriteria.setCerfId(LongFilterUtils.toEqualLongFilter(cerfStdDTO.getCerf().getId()));
                companyCriteria.setRelType(StringFilterUtils.toEqualStringFilter("APPLY"));
                List<CerfCompanyDTO> list = cerfCompanyQueryService.findByCriteria(companyCriteria);
                for (CerfCompanyDTO cerfCompanyDTO : list) {
                    CompanyDTO company = cerfCompanyDTO.getCompany();
                    CerfDTO cerfDTO = cerfCompanyDTO.getCerf();
                    if (company.getEmail() != null && !company.getEmail().isEmpty()) {
                        StdCompanyMailDTO stdCompanyMailDTO = new StdCompanyMailDTO();
                        stdCompanyMailDTO.setLangKey(Constants.DEFAULT_LANGUAGE);
                        stdCompanyMailDTO.setCompanyChName(company.getChName());
                        stdCompanyMailDTO.setCompanyEmail(company.getEmail());
                        stdCompanyMailDTO.setCerfNo(cerfDTO.getCerfNo());
                        stdCompanyMailDTO.setCerfVer(cerfDTO.getCerfVer());
                        stdCompanyMailDTO.setStdNo(std.getStdNo());
                        stdCompanyMailDTO.setStdVer(std.getStdVer());
                        mailService.sendStdNoticeEmail(stdCompanyMailDTO);
                    }
                }
            }
            return StatusCode.SUCCESS;
        } catch (Exception e) {
            log.error("sndMail: {}", e.getMessage());
            return StatusCode.FAIL;
        }
    }

    private String geStdfStatus(LocalDate issuDt, LocalDate expDt) {
        Long until = LocalDate.now().until(expDt, ChronoUnit.DAYS);
        if (until >= 0) return "有效"; else return "失效";
    }

    public StdDTO setStdStatus(StdDTO stdDTO) {
        LocalDate issuDt = stdDTO.getIssuDt();
        LocalDate expDt = stdDTO.getExpDt();
        if (issuDt != null && expDt != null) stdDTO.setStatus(geStdfStatus(issuDt, expDt));
        return stdDTO;
    }
}
