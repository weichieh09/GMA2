package com.wcc.gma2.customized.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnumListDTO implements Serializable {

    @NotNull
    private String code;

    @NotNull
    private String name;

    public EnumListDTO(@NotNull String code, @NotNull String name) {
        this.code = code;
        this.name = name;
    }

    public EnumListDTO() {}
}
