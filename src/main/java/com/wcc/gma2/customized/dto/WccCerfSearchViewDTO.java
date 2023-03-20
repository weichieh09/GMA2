package com.wcc.gma2.customized.dto;

import java.util.Objects;
import lombok.Data;

@Data
public class WccCerfSearchViewDTO {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String feeCd;

    private String feeDesc;

    private Long fee;

    private String areaCd;

    private String areaDesc;

    private String stsCd;

    private String stsDesc;

    private String applId;

    private String mnfctrNmCh;

    private String prodId;

    private String mnfctrId;

    private String fctyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WccCerfSearchViewDTO that = (WccCerfSearchViewDTO) o;
        return (
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(feeCd, that.feeCd) &&
            Objects.equals(fee, that.fee) &&
            Objects.equals(areaCd, that.areaCd) &&
            Objects.equals(stsCd, that.stsCd) &&
            Objects.equals(applId, that.applId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(cerfNo, cerfVer, feeCd, fee, areaCd, stsCd, applId);
    }
}
