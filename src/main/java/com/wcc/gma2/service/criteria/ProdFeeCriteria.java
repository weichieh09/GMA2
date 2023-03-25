package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.ProdFee} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.ProdFeeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /prod-fees?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProdFeeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter fee;

    private StringFilter feeType;

    private LocalDateFilter feeDt;

    private LongFilter prodId;

    private Boolean distinct;

    public ProdFeeCriteria() {}

    public ProdFeeCriteria(ProdFeeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.fee = other.fee == null ? null : other.fee.copy();
        this.feeType = other.feeType == null ? null : other.feeType.copy();
        this.feeDt = other.feeDt == null ? null : other.feeDt.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ProdFeeCriteria copy() {
        return new ProdFeeCriteria(this);
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

    public StringFilter getFeeType() {
        return feeType;
    }

    public StringFilter feeType() {
        if (feeType == null) {
            feeType = new StringFilter();
        }
        return feeType;
    }

    public void setFeeType(StringFilter feeType) {
        this.feeType = feeType;
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
        final ProdFeeCriteria that = (ProdFeeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(fee, that.fee) &&
            Objects.equals(feeType, that.feeType) &&
            Objects.equals(feeDt, that.feeDt) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fee, feeType, feeDt, prodId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProdFeeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (fee != null ? "fee=" + fee + ", " : "") +
            (feeType != null ? "feeType=" + feeType + ", " : "") +
            (feeDt != null ? "feeDt=" + feeDt + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
