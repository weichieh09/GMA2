package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CerfSearchView} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CerfSearchViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-search-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfSearchViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter feeCd;

    private LongFilter fee;

    private StringFilter areaCd;

    private StringFilter stsCd;

    private StringFilter applId;

    private StringFilter mnfctrNmCh;

    private StringFilter prodId;

    private StringFilter mnfctrId;

    private StringFilter fctyId;

    private Boolean distinct;

    public CerfSearchViewCriteria() {}

    public CerfSearchViewCriteria(CerfSearchViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.feeCd = other.feeCd == null ? null : other.feeCd.copy();
        this.fee = other.fee == null ? null : other.fee.copy();
        this.areaCd = other.areaCd == null ? null : other.areaCd.copy();
        this.stsCd = other.stsCd == null ? null : other.stsCd.copy();
        this.applId = other.applId == null ? null : other.applId.copy();
        this.mnfctrNmCh = other.mnfctrNmCh == null ? null : other.mnfctrNmCh.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.mnfctrId = other.mnfctrId == null ? null : other.mnfctrId.copy();
        this.fctyId = other.fctyId == null ? null : other.fctyId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CerfSearchViewCriteria copy() {
        return new CerfSearchViewCriteria(this);
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

    public StringFilter getMnfctrNmCh() {
        return mnfctrNmCh;
    }

    public StringFilter mnfctrNmCh() {
        if (mnfctrNmCh == null) {
            mnfctrNmCh = new StringFilter();
        }
        return mnfctrNmCh;
    }

    public void setMnfctrNmCh(StringFilter mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
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
        final CerfSearchViewCriteria that = (CerfSearchViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(feeCd, that.feeCd) &&
            Objects.equals(fee, that.fee) &&
            Objects.equals(areaCd, that.areaCd) &&
            Objects.equals(stsCd, that.stsCd) &&
            Objects.equals(applId, that.applId) &&
            Objects.equals(mnfctrNmCh, that.mnfctrNmCh) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(mnfctrId, that.mnfctrId) &&
            Objects.equals(fctyId, that.fctyId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfNo, cerfVer, feeCd, fee, areaCd, stsCd, applId, mnfctrNmCh, prodId, mnfctrId, fctyId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfSearchViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (feeCd != null ? "feeCd=" + feeCd + ", " : "") +
            (fee != null ? "fee=" + fee + ", " : "") +
            (areaCd != null ? "areaCd=" + areaCd + ", " : "") +
            (stsCd != null ? "stsCd=" + stsCd + ", " : "") +
            (applId != null ? "applId=" + applId + ", " : "") +
            (mnfctrNmCh != null ? "mnfctrNmCh=" + mnfctrNmCh + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (mnfctrId != null ? "mnfctrId=" + mnfctrId + ", " : "") +
            (fctyId != null ? "fctyId=" + fctyId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
