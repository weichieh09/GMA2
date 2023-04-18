package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.SelectListDTO;
import com.wcc.gma2.customized.dto.Wcc321FeeListReq;
import com.wcc.gma2.customized.dto.Wcc321FeeListRes;
import com.wcc.gma2.domain.Country;
import com.wcc.gma2.domain.FeeProdCerfCompany;
import com.wcc.gma2.repository.CountryRepository;
import com.wcc.gma2.repository.FeeProdCerfCompanyRepository;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class Wcc321Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private FeeProdCerfCompanyRepository feeProdCerfCompanyRepository;

    public List<SelectListDTO> findCountryList() {
        List<SelectListDTO> list = new ArrayList<>();
        SelectListDTO selectListDTO = null;
        for (Country country : countryRepository.findAll()) {
            selectListDTO = new SelectListDTO(country.getChName(), country.getId().toString());
            list.add(selectListDTO);
        }
        return list;
    }

    public Wcc321FeeListRes findForWcc321Vue(Wcc321FeeListReq req) {
        Wcc321FeeListRes result = new Wcc321FeeListRes();
        // 查
        List<FeeProdCerfCompany> feeList = this.getFeeList(req);
        // 排序
        feeList = feeList.stream().sorted(Comparator.comparing(FeeProdCerfCompany::getFeeDt)).collect(Collectors.toList());
        // 處理時間軸
        List<String> timeLine = this.getTimeLine(feeList);
        // 處理費用類別
        List<Map<String, Long>> feeObjectList = this.getFeeObjectList(feeList, timeLine);
        // 設定結果
        result.setTimeLine(timeLine);
        result.setFeeObjectList(feeObjectList);
        return result;
    }

    private List<Map<String, Long>> getFeeObjectList(List<FeeProdCerfCompany> feeList, List<String> timeLine) {
        List<Map<String, Long>> result = new LinkedList<>();
        for (String year : timeLine) {
            Map<String, Long> map = new HashMap<>();
            map.put("C", 0L);
            map.put("S", 0L);
            map.put("F", 0L);
            for (FeeProdCerfCompany dto : feeList) {
                Integer dtoYear = dto.getFeeDt().getYear();
                if (dtoYear.toString().equals(year)) {
                    String feeType = dto.getFeeType().substring(0, 1);
                    Long fee = dto.getFee();
                    map.put(feeType, map.get(feeType) + fee);
                }
            }
            result.add(map);
        }
        return result;
    }

    private List<String> getTimeLine(List<FeeProdCerfCompany> feeList) {
        List<String> result = new LinkedList<>();
        for (FeeProdCerfCompany fee : feeList) {
            Integer year = fee.getFeeDt().getYear();
            if (!result.contains(year.toString())) {
                result.add(year.toString());
            }
        }
        return result;
    }

    private List<FeeProdCerfCompany> getFeeList(Wcc321FeeListReq req) {
        String countryId = req.getCountryId() == null ? "" : req.getCountryId();
        String prodNo = req.getProdNo() == null ? "" : req.getProdNo();
        String prodChName = req.getProdChName() == null ? "" : req.getProdChName();
        String startDate = req.getStartDate() == null ? "" : req.getStartDate();
        String endDate = req.getEndDate() == null ? "" : req.getEndDate();
        List<FeeProdCerfCompany> rsult = feeProdCerfCompanyRepository.findForWcc321Vue(countryId, prodNo, prodChName, startDate, endDate);
        return rsult;
    }
}
