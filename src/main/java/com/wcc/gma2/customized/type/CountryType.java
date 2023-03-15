package com.wcc.gma2.customized.type;

import com.wcc.gma2.customized.dto.EnumListDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CountryType {
    CN("CN", "中國"),
    TW("TW", "台灣");

    @Getter
    private String code;

    @Getter
    private String name;

    public static CountryType toCountryType(String code) {
        for (CountryType tmp : CountryType.values()) if (tmp.getCode().equals(code)) return tmp;
        return null;
    }

    public static List<EnumListDTO> getCountryTypeList() {
        List<EnumListDTO> list = new ArrayList<>();
        for (CountryType type : CountryType.values()) list.add(new EnumListDTO(type.getCode(), type.getName()));
        return list;
    }
}
