package com.wcc.gma2.customized.service;

import com.wcc.gma2.customized.type.CerfStatusTypeList;
import com.wcc.gma2.service.dto.Wcc412ViewDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class Wcc412Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    public List<Wcc412ViewDTO> getCerfStatus(List<Wcc412ViewDTO> content) {
        List<Wcc412ViewDTO> list = new ArrayList<>();
        for (Wcc412ViewDTO dto : content) {
            dto.setCerfStatus(CerfStatusTypeList.toText(dto.getCerfStatus()));
            list.add(dto);
        }
        return list;
    }
}
