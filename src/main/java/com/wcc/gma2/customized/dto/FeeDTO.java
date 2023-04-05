package com.wcc.gma2.customized.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class FeeDTO {

    private String feeType;
    private Long fee;
    private LocalDate feeDt;
}
