package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Sticker} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StickerDTO implements Serializable {

    private Long id;

    @Size(max = 20)
    private String stickerNo;

    @Lob
    private byte[] img;

    private String imgContentType;
    private Set<MarkDTO> marks = new HashSet<>();

    private ProdDTO prod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStickerNo() {
        return stickerNo;
    }

    public void setStickerNo(String stickerNo) {
        this.stickerNo = stickerNo;
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

    public Set<MarkDTO> getMarks() {
        return marks;
    }

    public void setMarks(Set<MarkDTO> marks) {
        this.marks = marks;
    }

    public ProdDTO getProd() {
        return prod;
    }

    public void setProd(ProdDTO prod) {
        this.prod = prod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StickerDTO)) {
            return false;
        }

        StickerDTO stickerDTO = (StickerDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, stickerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StickerDTO{" +
            "id=" + getId() +
            ", stickerNo='" + getStickerNo() + "'" +
            ", img='" + getImg() + "'" +
            ", marks=" + getMarks() +
            ", prod=" + getProd() +
            "}";
    }
}
