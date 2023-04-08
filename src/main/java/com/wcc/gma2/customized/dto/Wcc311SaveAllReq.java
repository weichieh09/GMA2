package com.wcc.gma2.customized.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class Wcc311SaveAllReq {

    private Long cerfId;
    private Long countryId;
    private String stsCd;
    private String cerfNo;
    private String cerfVer;
    private byte[] pdf;
    private String pdfContentType;
    private LocalDate issuDt;
    private LocalDate expDt;
    private IdDTO apply;
    private IdDTO mnfctr;
    private List<IdDTO> fctyList;
    private List<IdDTO> prodList;
    private List<IdDTO> stdList;
    private List<FeeDTO> feeList;
    private IdDTO mark;
}
