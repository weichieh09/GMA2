package com.wcc.gma2.customized.dto;

import com.wcc.gma2.service.dto.CerfSearchViewDTO;
import java.util.List;
import lombok.Data;

@Data
public class Wcc102Res {

    private String name;

    private List<CerfSearchViewDTO> csvList;
}
