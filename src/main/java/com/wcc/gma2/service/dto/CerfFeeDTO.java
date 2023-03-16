package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.CerfFee} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfFeeDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String cerfTag;

    private String areaCd;

    private String applId;

    private String stsCd;

    private String feeCd;

    private LocalDate feeDt;

    private Long fee;

    private String curr;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

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

    public String getCerfTag() {
        return cerfTag;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public String getAreaCd() {
        return areaCd;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getApplId() {
        return applId;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getFeeCd() {
        return feeCd;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public LocalDate getFeeDt() {
        return feeDt;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
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
        if (!(o instanceof CerfFeeDTO)) {
            return false;
        }

        CerfFeeDTO cerfFeeDTO = (CerfFeeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerfFeeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfFeeDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", applId='" + getApplId() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            ", fee=" + getFee() +
            ", curr='" + getCurr() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
