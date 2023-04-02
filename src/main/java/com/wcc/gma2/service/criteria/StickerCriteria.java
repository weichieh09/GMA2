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

    private LongFilter stickerMarkId;

    private LongFilter prodStickerId;

    private Boolean distinct;

    public StickerCriteria() {}

    public StickerCriteria(StickerCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.stickerNo = other.stickerNo == null ? null : other.stickerNo.copy();
        this.stickerMarkId = other.stickerMarkId == null ? null : other.stickerMarkId.copy();
        this.prodStickerId = other.prodStickerId == null ? null : other.prodStickerId.copy();
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

    public LongFilter getStickerMarkId() {
        return stickerMarkId;
    }

    public LongFilter stickerMarkId() {
        if (stickerMarkId == null) {
            stickerMarkId = new LongFilter();
        }
        return stickerMarkId;
    }

    public void setStickerMarkId(LongFilter stickerMarkId) {
        this.stickerMarkId = stickerMarkId;
    }

    public LongFilter getProdStickerId() {
        return prodStickerId;
    }

    public LongFilter prodStickerId() {
        if (prodStickerId == null) {
            prodStickerId = new LongFilter();
        }
        return prodStickerId;
    }

    public void setProdStickerId(LongFilter prodStickerId) {
        this.prodStickerId = prodStickerId;
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
            Objects.equals(stickerMarkId, that.stickerMarkId) &&
            Objects.equals(prodStickerId, that.prodStickerId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stickerNo, stickerMarkId, prodStickerId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StickerCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (stickerNo != null ? "stickerNo=" + stickerNo + ", " : "") +
            (stickerMarkId != null ? "stickerMarkId=" + stickerMarkId + ", " : "") +
            (prodStickerId != null ? "prodStickerId=" + prodStickerId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
