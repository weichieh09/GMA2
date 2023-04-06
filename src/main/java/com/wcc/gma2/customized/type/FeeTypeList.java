package com.wcc.gma2.customized.type;

import com.wcc.gma2.customized.dto.SelectListDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FeeTypeList {
    C1101("證書-首次申請", "C1101"),
    C1201("證書-年費", "C1201"),
    C1301("證書-新增型號", "C1301"),
    C1302("證書-設計變更", "C1302"),
    C1303("證書-標準變更", "C1303"),
    C1304("證書-申請變更", "C1304"),
    C1801("證書-到期展延", "C1801"),
    C1802("證書-到期註銷", "C1802"),
    S2100("標準-產品檢測", "S2100"),
    S2200("標準-變更檢測", "S2200"),
    F3100("工廠-年費", "F3100"),
    F3200("工廠-檢驗", "F3200");

    @Getter
    private String text;

    @Getter
    private String value;

    public static List<SelectListDTO> getFeeTypeList() {
        List<SelectListDTO> list = new ArrayList<>();
        for (FeeTypeList type : FeeTypeList.values()) list.add(new SelectListDTO(type.getText(), type.getValue()));
        return list;
    }
}
