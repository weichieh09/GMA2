package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Cerf2MnfctrView} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2MnfctrViewDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String area;

    private String sts;

    private LocalDate issuDt;

    private Long remainDays;

    private String applId;

    private String mnfctrNmCh;

    @Lob
    private byte[] upldFile;

    private String upldFileContentType;

    @Lob
    private byte[] imageFile;

    private String imageFileContentType;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public LocalDate getIssuDt() {
        return issuDt;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public Long getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(Long remainDays) {
        this.remainDays = remainDays;
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

    public byte[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageFileContentType() {
        return imageFileContentType;
    }

    public void setImageFileContentType(String imageFileContentType) {
        this.imageFileContentType = imageFileContentType;
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
        if (!(o instanceof Cerf2MnfctrViewDTO)) {
            return false;
        }

        Cerf2MnfctrViewDTO cerf2MnfctrViewDTO = (Cerf2MnfctrViewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerf2MnfctrViewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2MnfctrViewDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", area='" + getArea() + "'" +
            ", sts='" + getSts() + "'" +
            ", issuDt='" + getIssuDt() + "'" +
            ", remainDays=" + getRemainDays() +
            ", applId='" + getApplId() + "'" +
            ", mnfctrNmCh='" + getMnfctrNmCh() + "'" +
            ", upldFile='" + getUpldFile() + "'" +
            ", imageFile='" + getImageFile() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
