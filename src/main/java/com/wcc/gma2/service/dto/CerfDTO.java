package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Cerf} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String areaCd;

    private String stsCd;

    private String applId;

    private String cerfTag;

    private LocalDate issuDt;

    private LocalDate cerfExpDt;

    private Long remainDays;

    @Lob
    private byte[] upldFile;

    private String upldFileContentType;
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

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
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

    public LocalDate getIssuDt() {
        return issuDt;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public LocalDate getCerfExpDt() {
        return cerfExpDt;
    }

    public void setCerfExpDt(LocalDate cerfExpDt) {
        this.cerfExpDt = cerfExpDt;
    }

    public Long getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(Long remainDays) {
        this.remainDays = remainDays;
    }

    public byte[] getUpldFile() {
        return upldFile;
    }

    public void setUpldFile(byte[] upldFile) {
        this.upldFile = upldFile;
    }

    public String getUpldFileContentType() {
        return upldFileContentType;
    }

    public void setUpldFileContentType(String upldFileContentType) {
        this.upldFileContentType = upldFileContentType;
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
        if (!(o instanceof CerfDTO)) {
            return false;
        }

        CerfDTO cerfDTO = (CerfDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerfDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", applId='" + getApplId() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", issuDt='" + getIssuDt() + "'" +
            ", cerfExpDt='" + getCerfExpDt() + "'" +
            ", remainDays=" + getRemainDays() +
            ", upldFile='" + getUpldFile() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
