package com.wcc.gma2.customized.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SelectListDTO implements Serializable {

    @NotNull
    private String text;

    @NotNull
    private String value;

    public SelectListDTO(@NotNull String text, @NotNull String value) {
        this.text = text;
        this.value = value;
    }

    public SelectListDTO() {}
}
