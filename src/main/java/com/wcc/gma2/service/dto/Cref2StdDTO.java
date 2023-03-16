package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Cref2Std} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cref2StdDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String areaCd;

    private String applId;

    private String cerfTag;

    private String stdNo;

    private String stdVer;

    private String stsCd;

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

    public String getCerfTag() {
        return cerfTag;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return stdVer;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
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
        if (!(o instanceof Cref2StdDTO)) {
            return false;
        }

        Cref2StdDTO cref2StdDTO = (Cref2StdDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cref2StdDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cref2StdDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", applId='" + getApplId() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
