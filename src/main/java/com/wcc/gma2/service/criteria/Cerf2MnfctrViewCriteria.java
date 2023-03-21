package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Cerf2MnfctrView} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Cerf2MnfctrViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-2-mnfctr-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2MnfctrViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter area;

    private StringFilter sts;

    private LocalDateFilter issuDt;

    private LongFilter remainDays;

    private StringFilter applId;

    private StringFilter mnfctrNmCh;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public Cerf2MnfctrViewCriteria() {}

    public Cerf2MnfctrViewCriteria(Cerf2MnfctrViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.area = other.area == null ? null : other.area.copy();
        this.sts = other.sts == null ? null : other.sts.copy();
        this.issuDt = other.issuDt == null ? null : other.issuDt.copy();
        this.remainDays = other.remainDays == null ? null : other.remainDays.copy();
        this.applId = other.applId == null ? null : other.applId.copy();
        this.mnfctrNmCh = other.mnfctrNmCh == null ? null : other.mnfctrNmCh.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Cerf2MnfctrViewCriteria copy() {
        return new Cerf2MnfctrViewCriteria(this);
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

    public StringFilter getArea() {
        return area;
    }

    public StringFilter area() {
        if (area == null) {
            area = new StringFilter();
        }
        return area;
    }

    public void setArea(StringFilter area) {
        this.area = area;
    }

    public StringFilter getSts() {
        return sts;
    }

    public StringFilter sts() {
        if (sts == null) {
            sts = new StringFilter();
        }
        return sts;
    }

    public void setSts(StringFilter sts) {
        this.sts = sts;
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
        final Cerf2MnfctrViewCriteria that = (Cerf2MnfctrViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(area, that.area) &&
            Objects.equals(sts, that.sts) &&
            Objects.equals(issuDt, that.issuDt) &&
            Objects.equals(remainDays, that.remainDays) &&
            Objects.equals(applId, that.applId) &&
            Objects.equals(mnfctrNmCh, that.mnfctrNmCh) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfNo, cerfVer, area, sts, issuDt, remainDays, applId, mnfctrNmCh, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2MnfctrViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (area != null ? "area=" + area + ", " : "") +
            (sts != null ? "sts=" + sts + ", " : "") +
            (issuDt != null ? "issuDt=" + issuDt + ", " : "") +
            (remainDays != null ? "remainDays=" + remainDays + ", " : "") +
            (applId != null ? "applId=" + applId + ", " : "") +
            (mnfctrNmCh != null ? "mnfctrNmCh=" + mnfctrNmCh + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
