package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.StdFee} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.StdFeeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /std-fees?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StdFeeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter prodId;

    private StringFilter mnfctrId;

    private StringFilter stdNo;

    private StringFilter stdVer;

    private StringFilter stsCd;

    private StringFilter feeCd;

    private LocalDateFilter feeDt;

    private LongFilter fee;

    private StringFilter curr;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public StdFeeCriteria() {}

    public StdFeeCriteria(StdFeeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.mnfctrId = other.mnfctrId == null ? null : other.mnfctrId.copy();
        this.stdNo = other.stdNo == null ? null : other.stdNo.copy();
        this.stdVer = other.stdVer == null ? null : other.stdVer.copy();
        this.stsCd = other.stsCd == null ? null : other.stsCd.copy();
        this.feeCd = other.feeCd == null ? null : other.feeCd.copy();
        this.feeDt = other.feeDt == null ? null : other.feeDt.copy();
        this.fee = other.fee == null ? null : other.fee.copy();
        this.curr = other.curr == null ? null : other.curr.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public StdFeeCriteria copy() {
        return new StdFeeCriteria(this);
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

    public StringFilter getProdId() {
        return prodId;
    }

    public StringFilter prodId() {
        if (prodId == null) {
            prodId = new StringFilter();
        }
        return prodId;
    }

    public void setProdId(StringFilter prodId) {
        this.prodId = prodId;
    }

    public StringFilter getMnfctrId() {
        return mnfctrId;
    }

    public StringFilter mnfctrId() {
        if (mnfctrId == null) {
            mnfctrId = new StringFilter();
        }
        return mnfctrId;
    }

    public void setMnfctrId(StringFilter mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public StringFilter getStdNo() {
        return stdNo;
    }

    public StringFilter stdNo() {
        if (stdNo == null) {
            stdNo = new StringFilter();
        }
        return stdNo;
    }

    public void setStdNo(StringFilter stdNo) {
        this.stdNo = stdNo;
    }

    public StringFilter getStdVer() {
        return stdVer;
    }

    public StringFilter stdVer() {
        if (stdVer == null) {
            stdVer = new StringFilter();
        }
        return stdVer;
    }

    public void setStdVer(StringFilter stdVer) {
        this.stdVer = stdVer;
    }

    public StringFilter getStsCd() {
        return stsCd;
    }

    public StringFilter stsCd() {
        if (stsCd == null) {
            stsCd = new StringFilter();
        }
        return stsCd;
    }

    public void setStsCd(StringFilter stsCd) {
        this.stsCd = stsCd;
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
        final StdFeeCriteria that = (StdFeeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(mnfctrId, that.mnfctrId) &&
            Objects.equals(stdNo, that.stdNo) &&
            Objects.equals(stdVer, that.stdVer) &&
            Objects.equals(stsCd, that.stsCd) &&
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
        return Objects.hash(id, prodId, mnfctrId, stdNo, stdVer, stsCd, feeCd, feeDt, fee, curr, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StdFeeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (mnfctrId != null ? "mnfctrId=" + mnfctrId + ", " : "") +
            (stdNo != null ? "stdNo=" + stdNo + ", " : "") +
            (stdVer != null ? "stdVer=" + stdVer + ", " : "") +
            (stsCd != null ? "stsCd=" + stsCd + ", " : "") +
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
