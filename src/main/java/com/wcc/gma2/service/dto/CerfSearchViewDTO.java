package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.wcc.gma2.domain.CerfSearchView} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfSearchViewDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String feeCd;

    @Lob
    private String feeDesc;

    private Long fee;

    private String areaCd;

    @Lob
    private String areaDesc;

    private String stsCd;

    @Lob
    private String stsDesc;

    private String applId;

    private String mnfctrNmCh;

    private String prodId;

    private String mnfctrId;

    private String fctyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return cerfNo;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return cerfVer;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getFeeCd() {
        return feeCd;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getAreaCd() {
        return areaCd;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getAreaDesc() {
        return areaDesc;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getStsDesc() {
        return stsDesc;
    }

    public void setStsDesc(String stsDesc) {
        this.stsDesc = stsDesc;
    }

    public String getApplId() {
        return applId;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getMnfctrNmCh() {
        return mnfctrNmCh;
    }

    public void setMnfctrNmCh(String mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return mnfctrId;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getFctyId() {
        return fctyId;
    }

    public void setFctyId(String fctyId) {
        this.fctyId = fctyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CerfSearchViewDTO)) {
            return false;
        }

        CerfSearchViewDTO cerfSearchViewDTO = (CerfSearchViewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerfSearchViewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfSearchViewDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDesc='" + getFeeDesc() + "'" +
            ", fee=" + getFee() +
            ", areaCd='" + getAreaCd() + "'" +
            ", areaDesc='" + getAreaDesc() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", stsDesc='" + getStsDesc() + "'" +
            ", applId='" + getApplId() + "'" +
            ", mnfctrNmCh='" + getMnfctrNmCh() + "'" +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", fctyId='" + getFctyId() + "'" +
            "}";
    }
}
