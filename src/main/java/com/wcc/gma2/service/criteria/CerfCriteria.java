package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Cerf} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CerfResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerfs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter areaCd;

    private StringFilter stsCd;

    private StringFilter applId;

    private StringFilter cerfTag;

    private LocalDateFilter issuDt;

    private LocalDateFilter cerfExpDt;

    private LongFilter remainDays;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public CerfCriteria() {}

    public CerfCriteria(CerfCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.areaCd = other.areaCd == null ? null : other.areaCd.copy();
        this.stsCd = other.stsCd == null ? null : other.stsCd.copy();
        this.applId = other.applId == null ? null : other.applId.copy();
        this.cerfTag = other.cerfTag == null ? null : other.cerfTag.copy();
        this.issuDt = other.issuDt == null ? null : other.issuDt.copy();
        this.cerfExpDt = other.cerfExpDt == null ? null : other.cerfExpDt.copy();
        this.remainDays = other.remainDays == null ? null : other.remainDays.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CerfCriteria copy() {
        return new CerfCriteria(this);
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

    public LocalDateFilter getIssuDt() {
        return issuDt;
    }

    public LocalDateFilter issuDt() {
        if (issuDt == null) {
            issuDt = new LocalDateFilter();
        }
        return issuDt;
    }

    public void setIssuDt(LocalDateFilter issuDt) {
        this.issuDt = issuDt;
    }

    public LocalDateFilter getCerfExpDt() {
        return cerfExpDt;
    }

    public LocalDateFilter cerfExpDt() {
        if (cerfExpDt == null) {
            cerfExpDt = new LocalDateFilter();
        }
        return cerfExpDt;
    }

    public void setCerfExpDt(LocalDateFilter cerfExpDt) {
        this.cerfExpDt = cerfExpDt;
    }

    public LongFilter getRemainDays() {
        return remainDays;
    }

    public LongFilter remainDays() {
        if (remainDays == null) {
            remainDays = new LongFilter();
        }
        return remainDays;
    }

    public void setRemainDays(LongFilter remainDays) {
        this.remainDays = remainDays;
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
        final CerfCriteria that = (CerfCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(areaCd, that.areaCd) &&
            Objects.equals(stsCd, that.stsCd) &&
            Objects.equals(applId, that.applId) &&
            Objects.equals(cerfTag, that.cerfTag) &&
            Objects.equals(issuDt, that.issuDt) &&
            Objects.equals(cerfExpDt, that.cerfExpDt) &&
            Objects.equals(remainDays, that.remainDays) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            cerfNo,
            cerfVer,
            areaCd,
            stsCd,
            applId,
            cerfTag,
            issuDt,
            cerfExpDt,
            remainDays,
            lstMtnUsr,
            lstMtnDt,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (areaCd != null ? "areaCd=" + areaCd + ", " : "") +
            (stsCd != null ? "stsCd=" + stsCd + ", " : "") +
            (applId != null ? "applId=" + applId + ", " : "") +
            (cerfTag != null ? "cerfTag=" + cerfTag + ", " : "") +
            (issuDt != null ? "issuDt=" + issuDt + ", " : "") +
            (cerfExpDt != null ? "cerfExpDt=" + cerfExpDt + ", " : "") +
            (remainDays != null ? "remainDays=" + remainDays + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
