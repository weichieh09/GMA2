package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.domain.Wcc412View;
import com.wcc.gma2.repository.Wcc412ViewRepository;
import com.wcc.gma2.service.criteria.Wcc412ViewCriteria;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class Wcc412Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private Wcc412ViewRepository wcc412ViewRepository;

    public List<Wcc412View> getCerfStatus(List<Wcc412View> content) {
        List<Wcc412View> list = new ArrayList<>();
        for (Wcc412View dto : content) {
            dto.setCerfStatus(CerfStatusTypeList.toText(dto.getCerfStatus()));
            list.add(dto);
        }
        return list;
    }

    public Page<Wcc412View> findForWcc412View(Wcc412ViewCriteria criteria, Pageable pageable) {
        String countryId = criteria.getCountryId().getEquals() == null ? "" : criteria.getCountryId().getEquals().toString();
        String prodNo = criteria.getProdNo().getContains();
        String prodChName = criteria.getProdChName().getContains();
        return wcc412ViewRepository.findForWcc412View(countryId, prodNo, prodChName, pageable);
    }
}
