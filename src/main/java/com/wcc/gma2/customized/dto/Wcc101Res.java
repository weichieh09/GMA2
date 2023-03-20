package com.wcc.gma2.customized.dto;

import java.util.Map;
import lombok.Data;

@Data
public class Wcc101Res {

    private Map<String, Long> chart1;

    private Map<String, Long> chart2;

    private Map<String, Long> chart3;
}
