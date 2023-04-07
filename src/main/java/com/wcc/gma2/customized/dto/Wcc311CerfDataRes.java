package com.wcc.gma2.customized.dto;

import com.wcc.gma2.service.dto.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class Wcc311CerfDataRes {

    private Long cerfId;
    private String cerfNo;
    private String cerfVer;
    private byte[] pdf;
    private String pdfContentType;
    private LocalDate issuDt;
    private LocalDate expDt;
    private String stsCd;
    private CountryDTO country;
    private List<CompanyDTO> apply;
    private List<CompanyDTO> mnfctr;
    private List<CompanyDTO> fctyList;
    private List<ProdDTO> prodList;
    private List<StdDTO> stdList;
    private List<FeeProdCerfCompanyDTO> feeList;
    private MarkDTO mark;
}
