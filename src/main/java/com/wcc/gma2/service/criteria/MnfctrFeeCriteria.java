package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.MnfctrFee} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.MnfctrFeeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /mnfctr-fees?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MnfctrFeeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter fctyId;

    private StringFilter feeCd;

    private LocalDateFilter feeDt;

    private LongFilter fee;

    private StringFilter curr;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public MnfctrFeeCriteria() {}

    public MnfctrFeeCriteria(MnfctrFeeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.fctyId = other.fctyId == null ? null : other.fctyId.copy();
        this.feeCd = other.feeCd == null ? null : other.feeCd.copy();
        this.feeDt = other.feeDt == null ? null : other.feeDt.copy();
        this.fee = other.fee == null ? null : other.fee.copy();
        this.curr = other.curr == null ? null : other.curr.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public MnfctrFeeCriteria copy() {
        return new MnfctrFeeCriteria(this);
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

    public StringFilter getFctyId() {
        return fctyId;
    }

    public StringFilter fctyId() {
        if (fctyId == null) {
            fctyId = new StringFilter();
        }
        return fctyId;
    }

    public void setFctyId(StringFilter fctyId) {
        this.fctyId = fctyId;
    }

    public StringFilter getFeeCd() {
        return feeCd;
    }

    public StringFilter feeCd() {
        if (feeCd == null) {
            feeCd = new StringFilter();
        }
        return feeCd;
    }

    public void setFeeCd(StringFilter feeCd) {
        this.feeCd = feeCd;
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

    public StringFilter getCurr() {
        return curr;
    }

    public StringFilter curr() {
        if (curr == null) {
            curr = new StringFilter();
        }
        return curr;
    }

    public void setCurr(StringFilter curr) {
        this.curr = curr;
    }

    public StringFilter getLstMtnUsr() {
        return lstMtnUsr;
    }

    public StringFilter lstMtnUsr() {
        if (lstMtnUsr == null) {
            lstMtnUsr = new StringFilter();
        }
        return lstMtnUsr;
    }

    public void setLstMtnUsr(StringFilter lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDateFilter getLstMtnDt() {
        return lstMtnDt;
    }

    public LocalDateFilter lstMtnDt() {
        if (lstMtnDt == null) {
            lstMtnDt = new LocalDateFilter();
        }
        return lstMtnDt;
    }

    public void setLstMtnDt(LocalDateFilter lstMtnDt) {
        this.lstMtnDt = lstMtnDt;
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
        final MnfctrFeeCriteria that = (MnfctrFeeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(fctyId, that.fctyId) &&
            Objects.equals(feeCd, that.feeCd) &&
            Objects.equals(feeDt, that.feeDt) &&
            Objects.equals(fee, that.fee) &&
            Objects.equals(curr, that.curr) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fctyId, feeCd, feeDt, fee, curr, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MnfctrFeeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (fctyId != null ? "fctyId=" + fctyId + ", " : "") +
            (feeCd != null ? "feeCd=" + feeCd + ", " : "") +
            (feeDt != null ? "feeDt=" + feeDt + ", " : "") +
            (fee != null ? "fee=" + fee + ", " : "") +
            (curr != null ? "curr=" + curr + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
