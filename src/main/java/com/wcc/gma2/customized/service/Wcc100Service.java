package com.wcc.gma2.customized.service;

import com.wcc.gma2.domain.CerfSearchView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Wcc100Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    public Map<String, Long> getChart1(List<CerfSearchView> list) {
        Map<String, Long> result = new HashMap<>();

        for (CerfSearchView dto : list) {
            if (result.get(dto.getFeeCd()) == null) {
                result.put(dto.getFeeCd(), 0L);
            } else {
                Long aLong = result.get(dto.getFeeCd());
                aLong = aLong + dto.getFee();
                result.put(dto.getFeeCd(), aLong);
            }
        }

        return result;
    }

    public Map<String, Long> getChart2(List<CerfSearchView> list) {
        Map<String, Long> result = new HashMap<>();

        for (CerfSearchView dto : list) {
            if (result.get(dto.getStsCd()) == null) {
                result.put(dto.getStsCd(), 0L);
            } else {
                Long aLong = result.get(dto.getStsCd());
                aLong = aLong + 1;
                result.put(dto.getStsCd(), aLong);
            }
        }

        return result;
    }

    public Map<String, Long> getChart3(List<CerfSearchView> list) {
        Map<String, Long> result = new HashMap<>();

        for (CerfSearchView dto : list) {
            if (result.get(dto.getAreaCd()) == null) {
                result.put(dto.getAreaCd(), 0L);
            } else {
                Long aLong = result.get(dto.getAreaCd());
                aLong = aLong + 1;
                result.put(dto.getAreaCd(), aLong);
            }
        }

        return result;
    }
}
