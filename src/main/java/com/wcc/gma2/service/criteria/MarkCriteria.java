package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Mark} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.MarkResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /marks?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MarkCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter markNo;

    private StringFilter enName;

    private StringFilter chName;

    private LongFilter cerfMarkId;

    private LongFilter stickerMarkId;

    private LongFilter countryMarkId;

    private Boolean distinct;

    public MarkCriteria() {}

    public MarkCriteria(MarkCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.markNo = other.markNo == null ? null : other.markNo.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.chName = other.chName == null ? null : other.chName.copy();
        this.cerfMarkId = other.cerfMarkId == null ? null : other.cerfMarkId.copy();
        this.stickerMarkId = other.stickerMarkId == null ? null : other.stickerMarkId.copy();
        this.countryMarkId = other.countryMarkId == null ? null : other.countryMarkId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public MarkCriteria copy() {
        return new MarkCriteria(this);
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

    public StringFilter getMarkNo() {
        return markNo;
    }

    public StringFilter markNo() {
        if (markNo == null) {
            markNo = new StringFilter();
        }
        return markNo;
    }

    public void setMarkNo(StringFilter markNo) {
        this.markNo = markNo;
    }

    public StringFilter getEnName() {
        return enName;
    }

    public StringFilter enName() {
        if (enName == null) {
            enName = new StringFilter();
        }
        return enName;
    }

    public void setEnName(StringFilter enName) {
        this.enName = enName;
    }

    public StringFilter getChName() {
        return chName;
    }

    public StringFilter chName() {
        if (chName == null) {
            chName = new StringFilter();
        }
        return chName;
    }

    public void setChName(StringFilter chName) {
        this.chName = chName;
    }

    public LongFilter getCerfMarkId() {
        return cerfMarkId;
    }

    public LongFilter cerfMarkId() {
        if (cerfMarkId == null) {
            cerfMarkId = new LongFilter();
        }
        return cerfMarkId;
    }

    public void setCerfMarkId(LongFilter cerfMarkId) {
        this.cerfMarkId = cerfMarkId;
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

    public LongFilter getCountryMarkId() {
        return countryMarkId;
    }

    public LongFilter countryMarkId() {
        if (countryMarkId == null) {
            countryMarkId = new LongFilter();
        }
        return countryMarkId;
    }

    public void setCountryMarkId(LongFilter countryMarkId) {
        this.countryMarkId = countryMarkId;
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
        final MarkCriteria that = (MarkCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(markNo, that.markNo) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(chName, that.chName) &&
            Objects.equals(cerfMarkId, that.cerfMarkId) &&
            Objects.equals(stickerMarkId, that.stickerMarkId) &&
            Objects.equals(countryMarkId, that.countryMarkId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, markNo, enName, chName, cerfMarkId, stickerMarkId, countryMarkId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MarkCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (markNo != null ? "markNo=" + markNo + ", " : "") +
            (enName != null ? "enName=" + enName + ", " : "") +
            (chName != null ? "chName=" + chName + ", " : "") +
            (cerfMarkId != null ? "cerfMarkId=" + cerfMarkId + ", " : "") +
            (stickerMarkId != null ? "stickerMarkId=" + stickerMarkId + ", " : "") +
            (countryMarkId != null ? "countryMarkId=" + countryMarkId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
