package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.wcc.gma2.domain.CerfImg} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfImgDTO implements Serializable {

    private Long id;

    private String cerfTag;

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

    public String getCerfTag() {
        return cerfTag;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
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
        if (!(o instanceof CerfImgDTO)) {
            return false;
        }

        CerfImgDTO cerfImgDTO = (CerfImgDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerfImgDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfImgDTO{" +
            "id=" + getId() +
            ", cerfTag='" + getCerfTag() + "'" +
            ", imageFile='" + getImageFile() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
