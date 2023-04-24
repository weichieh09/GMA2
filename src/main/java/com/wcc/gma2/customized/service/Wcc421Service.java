package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.domain.Wcc412View;
import com.wcc.gma2.repository.Wcc412ViewRepository;
import com.wcc.gma2.service.criteria.Wcc412ViewCriteria;
import com.wcc.gma2.service.dto.Wcc421ViewDTO;
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
public class Wcc421Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    public List<Wcc421ViewDTO> getCerfStatus(List<Wcc421ViewDTO> content) {
        List<Wcc421ViewDTO> list = new ArrayList<>();
        for (Wcc421ViewDTO dto : content) {
            dto.setCerfStatus(CerfStatusTypeList.toText(dto.getCerfStatus()));
            list.add(dto);
        }
        return list;
    }
}
