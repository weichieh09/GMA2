package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CerfFee} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CerfFeeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-fees?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfFeeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter cerfTag;

    private StringFilter areaCd;

    private StringFilter applId;

    private StringFilter stsCd;

    private StringFilter feeCd;

    private LocalDateFilter feeDt;

    private LongFilter fee;

    private StringFilter curr;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public CerfFeeCriteria() {}

    public CerfFeeCriteria(CerfFeeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.cerfTag = other.cerfTag == null ? null : other.cerfTag.copy();
        this.areaCd = other.areaCd == null ? null : other.areaCd.copy();
        this.applId = other.applId == null ? null : other.applId.copy();
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
    public CerfFeeCriteria copy() {
        return new CerfFeeCriteria(this);
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

    public StringFilter getCerfTag() {
        return cerfTag;
    }

    public StringFilter cerfTag() {
        if (cerfTag == null) {
            cerfTag = new StringFilter();
        }
        return cerfTag;
    }

    public void setCerfTag(StringFilter cerfTag) {
        this.cerfTag = cerfTag;
    }

    public StringFilter getAreaCd() {
        return areaCd;
    }

    public StringFilter areaCd() {
        if (areaCd == null) {
            areaCd = new StringFilter();
        }
        return areaCd;
    }

    public void setAreaCd(StringFilter areaCd) {
        this.areaCd = areaCd;
    }

    public StringFilter getApplId() {
        return applId;
    }

    public StringFilter applId() {
        if (applId == null) {
            applId = new StringFilter();
        }
        return applId;
    }

    public void setApplId(StringFilter applId) {
        this.applId = applId;
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
        final CerfFeeCriteria that = (CerfFeeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(cerfTag, that.cerfTag) &&
            Objects.equals(areaCd, that.areaCd) &&
            Objects.equals(applId, that.applId) &&
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
        return Objects.hash(id, cerfNo, cerfVer, cerfTag, areaCd, applId, stsCd, feeCd, feeDt, fee, curr, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfFeeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (cerfTag != null ? "cerfTag=" + cerfTag + ", " : "") +
            (areaCd != null ? "areaCd=" + areaCd + ", " : "") +
            (applId != null ? "applId=" + applId + ", " : "") +
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
