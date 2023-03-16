package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Std} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.StdResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /stds?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StdCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter stdNo;

    private StringFilter stdVer;

    private StringFilter stsCd;

    private StringFilter stdCd;

    private StringFilter stdNm;

    private LocalDateFilter stdExpDt;

    private LongFilter remainDays;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public StdCriteria() {}

    public StdCriteria(StdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.stdNo = other.stdNo == null ? null : other.stdNo.copy();
        this.stdVer = other.stdVer == null ? null : other.stdVer.copy();
        this.stsCd = other.stsCd == null ? null : other.stsCd.copy();
        this.stdCd = other.stdCd == null ? null : other.stdCd.copy();
        this.stdNm = other.stdNm == null ? null : other.stdNm.copy();
        this.stdExpDt = other.stdExpDt == null ? null : other.stdExpDt.copy();
        this.remainDays = other.remainDays == null ? null : other.remainDays.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public StdCriteria copy() {
        return new StdCriteria(this);
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

    public StringFilter getStdCd() {
        return stdCd;
    }

    public StringFilter stdCd() {
        if (stdCd == null) {
            stdCd = new StringFilter();
        }
        return stdCd;
    }

    public void setStdCd(StringFilter stdCd) {
        this.stdCd = stdCd;
    }

    public StringFilter getStdNm() {
        return stdNm;
    }

    public StringFilter stdNm() {
        if (stdNm == null) {
            stdNm = new StringFilter();
        }
        return stdNm;
    }

    public void setStdNm(StringFilter stdNm) {
        this.stdNm = stdNm;
    }

    public LocalDateFilter getStdExpDt() {
        return stdExpDt;
    }

    public LocalDateFilter stdExpDt() {
        if (stdExpDt == null) {
            stdExpDt = new LocalDateFilter();
        }
        return stdExpDt;
    }

    public void setStdExpDt(LocalDateFilter stdExpDt) {
        this.stdExpDt = stdExpDt;
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
        final StdCriteria that = (StdCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(stdNo, that.stdNo) &&
            Objects.equals(stdVer, that.stdVer) &&
            Objects.equals(stsCd, that.stsCd) &&
            Objects.equals(stdCd, that.stdCd) &&
            Objects.equals(stdNm, that.stdNm) &&
            Objects.equals(stdExpDt, that.stdExpDt) &&
            Objects.equals(remainDays, that.remainDays) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stdNo, stdVer, stsCd, stdCd, stdNm, stdExpDt, remainDays, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (stdNo != null ? "stdNo=" + stdNo + ", " : "") +
            (stdVer != null ? "stdVer=" + stdVer + ", " : "") +
            (stsCd != null ? "stsCd=" + stsCd + ", " : "") +
            (stdCd != null ? "stdCd=" + stdCd + ", " : "") +
            (stdNm != null ? "stdNm=" + stdNm + ", " : "") +
            (stdExpDt != null ? "stdExpDt=" + stdExpDt + ", " : "") +
            (remainDays != null ? "remainDays=" + remainDays + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
