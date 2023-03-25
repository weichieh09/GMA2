package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Mark} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MarkDTO implements Serializable {

    private Long id;

    @Size(max = 20)
    private String markNo;

    @Size(max = 100)
    private String enName;

    @Size(max = 100)
    private String chName;

    @Lob
    private byte[] img;

    private String imgContentType;
    private CountryDTO country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarkNo() {
        return markNo;
    }

    public void setMarkNo(String markNo) {
        this.markNo = markNo;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getImgContentType() {
        return imgContentType;
    }

    public void setImgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MarkDTO)) {
            return false;
        }

        MarkDTO markDTO = (MarkDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, markDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MarkDTO{" +
            "id=" + getId() +
            ", markNo='" + getMarkNo() + "'" +
            ", enName='" + getEnName() + "'" +
            ", chName='" + getChName() + "'" +
            ", img='" + getImg() + "'" +
            ", country=" + getCountry() +
            "}";
    }
}
