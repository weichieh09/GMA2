package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Prod2Std} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Prod2StdResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /prod-2-stds?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2StdCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter prodId;

    private StringFilter mnfctrId;

    private StringFilter stdNo;

    private StringFilter stdVer;

    private StringFilter stsCd;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public Prod2StdCriteria() {}

    public Prod2StdCriteria(Prod2StdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.mnfctrId = other.mnfctrId == null ? null : other.mnfctrId.copy();
        this.stdNo = other.stdNo == null ? null : other.stdNo.copy();
        this.stdVer = other.stdVer == null ? null : other.stdVer.copy();
        this.stsCd = other.stsCd == null ? null : other.stsCd.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Prod2StdCriteria copy() {
        return new Prod2StdCriteria(this);
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
        final Prod2StdCriteria that = (Prod2StdCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(mnfctrId, that.mnfctrId) &&
            Objects.equals(stdNo, that.stdNo) &&
            Objects.equals(stdVer, that.stdVer) &&
            Objects.equals(stsCd, that.stsCd) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prodId, mnfctrId, stdNo, stdVer, stsCd, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2StdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (mnfctrId != null ? "mnfctrId=" + mnfctrId + ", " : "") +
            (stdNo != null ? "stdNo=" + stdNo + ", " : "") +
            (stdVer != null ? "stdVer=" + stdVer + ", " : "") +
            (stsCd != null ? "stsCd=" + stsCd + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
