package com.wcc.gma2.customized.dto;

import java.util.List;
import lombok.Data;

@Data
public class Wcc321FeeObjectDTO {

    String feeType;
    List<Long> feeList;
}
