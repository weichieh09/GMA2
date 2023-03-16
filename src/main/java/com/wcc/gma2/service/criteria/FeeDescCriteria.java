package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.FeeDesc} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.FeeDescResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /fee-descs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FeeDescCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter feeCd;

    private StringFilter feeDesc;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public FeeDescCriteria() {}

    public FeeDescCriteria(FeeDescCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.feeCd = other.feeCd == null ? null : other.feeCd.copy();
        this.feeDesc = other.feeDesc == null ? null : other.feeDesc.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public FeeDescCriteria copy() {
        return new FeeDescCriteria(this);
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

    public StringFilter getFeeDesc() {
        return feeDesc;
    }

    public StringFilter feeDesc() {
        if (feeDesc == null) {
            feeDesc = new StringFilter();
        }
        return feeDesc;
    }

    public void setFeeDesc(StringFilter feeDesc) {
        this.feeDesc = feeDesc;
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
        final FeeDescCriteria that = (FeeDescCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(feeCd, that.feeCd) &&
            Objects.equals(feeDesc, that.feeDesc) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feeCd, feeDesc, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FeeDescCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (feeCd != null ? "feeCd=" + feeCd + ", " : "") +
            (feeDesc != null ? "feeDesc=" + feeDesc + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
