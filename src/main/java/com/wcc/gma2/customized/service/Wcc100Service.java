package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.WccCerfSearchViewDTO;
import com.wcc.gma2.customized.utils.StringFilterUtils;
import com.wcc.gma2.service.CerfSearchViewQueryService;
import com.wcc.gma2.service.criteria.CerfSearchViewCriteria;
import com.wcc.gma2.service.dto.CerfSearchViewDTO;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Wcc100Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CerfSearchViewQueryService cerfSearchViewQueryService;

    public Map<String, Long> getChart1(List<CerfSearchViewDTO> list) {
        Map<String, Long> result = new HashMap<>();

        for (CerfSearchViewDTO dto : list) {
            if (result.get(dto.getFeeCd()) == null) {
                result.put(dto.getFeeCd(), dto.getFee());
            } else {
                Long aLong = result.get(dto.getFeeCd());
                aLong = aLong + dto.getFee();
                result.put(dto.getFeeCd(), aLong);
            }
        }

        return result;
    }

    public Map<String, Long> getChart2(List<CerfSearchViewDTO> list) {
        Map<String, Long> result = new HashMap<>();

        for (CerfSearchViewDTO dto : list) {
            if (result.get(dto.getStsCd()) == null) {
                result.put(dto.getStsCd(), 1L);
            } else {
                Long aLong = result.get(dto.getStsCd());
                aLong = aLong + 1;
                result.put(dto.getStsCd(), aLong);
            }
        }

        return result;
    }

    public Map<String, Long> getChart3(List<CerfSearchViewDTO> list) {
        Map<String, Long> result = new HashMap<>();

        for (CerfSearchViewDTO dto : list) {
            if (result.get(dto.getAreaCd()) == null) {
                result.put(dto.getAreaCd(), 1L);
            } else {
                Long aLong = result.get(dto.getAreaCd());
                aLong = aLong + 1;
                result.put(dto.getAreaCd(), aLong);
            }
        }

        return result;
    }

    public List<CerfSearchViewDTO> findAllCsv(String applId, String mnfctrId, String fctyId) {
        CerfSearchViewCriteria criteria = new CerfSearchViewCriteria();
        criteria.setApplId(StringFilterUtils.toContainStringFilter(applId));
        criteria.setMnfctrId(StringFilterUtils.toContainStringFilter(mnfctrId));
        criteria.setFctyId(StringFilterUtils.toContainStringFilter(fctyId));

        List<CerfSearchViewDTO> byCriteria = cerfSearchViewQueryService.findByCriteria(criteria);

        return byCriteria;
    }

    public List<CerfSearchViewDTO> distinctCsv(List<CerfSearchViewDTO> allCsv) {
        Set<WccCerfSearchViewDTO> set = new HashSet<>();
        List<CerfSearchViewDTO> result = new ArrayList<>();

        for (CerfSearchViewDTO sourceDto : allCsv) {
            WccCerfSearchViewDTO targetDto = new WccCerfSearchViewDTO();
            BeanUtils.copyProperties(sourceDto, targetDto);
            set.add(targetDto);
        }

        for (WccCerfSearchViewDTO sourceDto : set) {
            CerfSearchViewDTO targetDto = new CerfSearchViewDTO();
            BeanUtils.copyProperties(sourceDto, targetDto);
            result.add(targetDto);
        }

        return result.stream().sorted(Comparator.comparing(CerfSearchViewDTO::getId)).collect(Collectors.toList());
    }
}
