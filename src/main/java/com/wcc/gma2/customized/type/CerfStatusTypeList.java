package com.wcc.gma2.customized.type;

import com.wcc.gma2.customized.dto.SelectListDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CerfStatusTypeList {
    VALID("有效", "valid"),
    FAILURE("失效", "failure"),
    MAINTEN("維護中", "mainten"),
    DELETE("刪除", "delete");

    @Getter
    private String text;

    @Getter
    private String value;

    public static String toText(String value) {
        for (CerfStatusTypeList type : CerfStatusTypeList.values()) if (type.getValue().equalsIgnoreCase(value)) return type.getText();
        return null;
    }

    public static List<SelectListDTO> getCerfStatusTypeList() {
        List<SelectListDTO> list = new ArrayList<>();
        for (CerfStatusTypeList type : CerfStatusTypeList.values()) list.add(new SelectListDTO(type.getText(), type.getValue()));
        return list;
    }
}
