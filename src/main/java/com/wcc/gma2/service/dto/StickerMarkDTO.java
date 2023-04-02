package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.StickerMark} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StickerMarkDTO implements Serializable {

    private Long id;

    @Size(max = 100)
    private String relType;

    private StickerDTO sticker;

    private MarkDTO mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    public StickerDTO getSticker() {
        return sticker;
    }

    public void setSticker(StickerDTO sticker) {
        this.sticker = sticker;
    }

    public MarkDTO getMark() {
        return mark;
    }

    public void setMark(MarkDTO mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StickerMarkDTO)) {
            return false;
        }

        StickerMarkDTO stickerMarkDTO = (StickerMarkDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, stickerMarkDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StickerMarkDTO{" +
            "id=" + getId() +
            ", relType='" + getRelType() + "'" +
            ", sticker=" + getSticker() +
            ", mark=" + getMark() +
            "}";
    }
}
