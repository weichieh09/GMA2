package com.wcc.gma2.customized.dto;

import java.util.List;
import lombok.Data;

@Data
public class Wcc321FeeListRes {

    List<String> timeLine;
    List<Wcc321FeeObjectDTO> feeObjectList;
}
