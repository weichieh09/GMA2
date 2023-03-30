package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Sticker} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.StickerResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /stickers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StickerCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter stickerNo;

    private LongFilter prodId;

    private LongFilter markId;

    private Boolean distinct;

    public StickerCriteria() {}

    public StickerCriteria(StickerCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.stickerNo = other.stickerNo == null ? null : other.stickerNo.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.markId = other.markId == null ? null : other.markId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public StickerCriteria copy() {
        return new StickerCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getStickerNo() {
        return stickerNo;
    }

    public StringFilter stickerNo() {
        if (stickerNo == null) {
            stickerNo = new StringFilter();
        }
        return stickerNo;
    }

    public void setStickerNo(StringFilter stickerNo) {
        this.stickerNo = stickerNo;
    }

    public LongFilter getProdId() {
        return prodId;
    }

    public LongFilter prodId() {
        if (prodId == null) {
            prodId = new LongFilter();
        }
        return prodId;
    }

    public void setProdId(LongFilter prodId) {
        this.prodId = prodId;
    }

    public LongFilter getMarkId() {
        return markId;
    }

    public LongFilter markId() {
        if (markId == null) {
            markId = new LongFilter();
        }
        return markId;
    }

    public void setMarkId(LongFilter markId) {
        this.markId = markId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final StickerCriteria that = (StickerCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(stickerNo, that.stickerNo) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(markId, that.markId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stickerNo, prodId, markId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StickerCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (stickerNo != null ? "stickerNo=" + stickerNo + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (markId != null ? "markId=" + markId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
