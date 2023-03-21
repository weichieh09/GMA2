package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CerfView} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CerfViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private LocalDateFilter feeDt;

    private LongFilter fee;

    private Boolean distinct;

    public CerfViewCriteria() {}

    public CerfViewCriteria(CerfViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.feeDt = other.feeDt == null ? null : other.feeDt.copy();
        this.fee = other.fee == null ? null : other.fee.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CerfViewCriteria copy() {
        return new CerfViewCriteria(this);
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

    public StringFilter getCerfNo() {
        return cerfNo;
    }

    public StringFilter cerfNo() {
        if (cerfNo == null) {
            cerfNo = new StringFilter();
        }
        return cerfNo;
    }

    public void setCerfNo(StringFilter cerfNo) {
        this.cerfNo = cerfNo;
    }

    public StringFilter getCerfVer() {
        return cerfVer;
    }

    public StringFilter cerfVer() {
        if (cerfVer == null) {
            cerfVer = new StringFilter();
        }
        return cerfVer;
    }

    public void setCerfVer(StringFilter cerfVer) {
        this.cerfVer = cerfVer;
    }

    public LocalDateFilter getFeeDt() {
        return feeDt;
    }

    public LocalDateFilter feeDt() {
        if (feeDt == null) {
            feeDt = new LocalDateFilter();
        }
        return feeDt;
    }

    public void setFeeDt(LocalDateFilter feeDt) {
        this.feeDt = feeDt;
    }

    public LongFilter getFee() {
        return fee;
    }

    public LongFilter fee() {
        if (fee == null) {
            fee = new LongFilter();
        }
        return fee;
    }

    public void setFee(LongFilter fee) {
        this.fee = fee;
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
        final CerfViewCriteria that = (CerfViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(feeDt, that.feeDt) &&
            Objects.equals(fee, that.fee) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfNo, cerfVer, feeDt, fee, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (feeDt != null ? "feeDt=" + feeDt + ", " : "") +
            (fee != null ? "fee=" + fee + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
