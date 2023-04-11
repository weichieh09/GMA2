package com.wcc.gma2.customized.dto;

import lombok.Data;

@Data
public class Wcc412CerfListReq {

    private Long countryId;
    private String prodNo;
    private String prodName;
    private Long page;
    private Long size;
}
