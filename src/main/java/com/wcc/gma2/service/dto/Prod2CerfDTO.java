package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Prod2Cerf} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2CerfDTO implements Serializable {

    private Long id;

    private String prodId;

    private String mnfctrId;

    private String cerfNo;

    private String cerfVer;

    private String applId;

    private String areaCd;

    private String cerfTag;

    private String stsCd;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getApplId() {
        return applId;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getAreaCd() {
        return areaCd;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getCerfTag() {
        return cerfTag;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getLstMtnUsr() {
        return lstMtnUsr;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return lstMtnDt;
    }

    public void setLstMtnDt(LocalDate lstMtnDt) {
        this.lstMtnDt = lstMtnDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prod2CerfDTO)) {
            return false;
        }

        Prod2CerfDTO prod2CerfDTO = (Prod2CerfDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, prod2CerfDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2CerfDTO{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", applId='" + getApplId() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
