package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.dto.EChartSonDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.jhipster.web.util.PageUtil;

@Slf4j
@Service
public class Wcc100Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CerfSearchViewQueryService cerfSearchViewQueryService;

    public List<EChartSonDTO> getEChart1(List<CerfSearchViewDTO> list) {
        List<EChartSonDTO> result = new ArrayList<>();
        Map<String, Long> tmpMap = new HashMap<>();

        for (CerfSearchViewDTO dto : list) {
            if (tmpMap.get(dto.getFeeCd()) == null) {
                tmpMap.put(dto.getFeeCd(), dto.getFee());
            } else {
                Long aLong = tmpMap.get(dto.getFeeCd());
                aLong = aLong + dto.getFee();
                tmpMap.put(dto.getFeeCd(), aLong);
            }
        }

        tmpMap.forEach((key, value) -> {
            EChartSonDTO dto = new EChartSonDTO();
            dto.setName(key);
            dto.setValue(value);
            result.add(dto);
        });

        return result;
    }

    public List<EChartSonDTO> getEChart2(List<CerfSearchViewDTO> list) {
        List<EChartSonDTO> result = new ArrayList<>();
        Map<String, Long> tmpMap = new HashMap<>();

        for (CerfSearchViewDTO dto : list) {
            if (tmpMap.get(dto.getStsCd()) == null) {
                tmpMap.put(dto.getStsCd(), 1L);
            } else {
                Long aLong = tmpMap.get(dto.getStsCd());
                aLong = aLong + 1;
                tmpMap.put(dto.getStsCd(), aLong);
            }
        }

        tmpMap.forEach((key, value) -> {
            EChartSonDTO dto = new EChartSonDTO();
            dto.setName(key);
            dto.setValue(value);
            result.add(dto);
        });

        return result;
    }

    public List<EChartSonDTO> getEChart3(List<CerfSearchViewDTO> list) {
        List<EChartSonDTO> result = new ArrayList<>();
        Map<String, Long> tmpMap = new HashMap<>();

        for (CerfSearchViewDTO dto : list) {
            if (tmpMap.get(dto.getAreaCd()) == null) {
                tmpMap.put(dto.getAreaCd(), 1L);
            } else {
                Long aLong = tmpMap.get(dto.getAreaCd());
                aLong = aLong + 1;
                tmpMap.put(dto.getAreaCd(), aLong);
            }
        }

        tmpMap.forEach((key, value) -> {
            EChartSonDTO dto = new EChartSonDTO();
            dto.setName(key);
            dto.setValue(value);
            result.add(dto);
        });

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

    public Page<CerfSearchViewDTO> pageableCsv(List<CerfSearchViewDTO> distinctCsv, Pageable pageable) {
        return PageUtil.createPageFromList(distinctCsv, pageable);
    }
}
