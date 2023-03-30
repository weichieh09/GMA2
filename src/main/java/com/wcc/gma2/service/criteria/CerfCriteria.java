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

    private StringFilter status;

    private LocalDateFilter issuDt;

    private LocalDateFilter expDt;

    private LongFilter cerfCompanyId;

    private LongFilter feeId;

    private LongFilter markId;

    private LongFilter prodId;

    private LongFilter stdId;

    private LongFilter countryId;

    private Boolean distinct;

    public CerfCriteria() {}

    public CerfCriteria(CerfCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.issuDt = other.issuDt == null ? null : other.issuDt.copy();
        this.expDt = other.expDt == null ? null : other.expDt.copy();
        this.cerfCompanyId = other.cerfCompanyId == null ? null : other.cerfCompanyId.copy();
        this.feeId = other.feeId == null ? null : other.feeId.copy();
        this.markId = other.markId == null ? null : other.markId.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.stdId = other.stdId == null ? null : other.stdId.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
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

    public StringFilter getStatus() {
        return status;
    }

    public StringFilter status() {
        if (status == null) {
            status = new StringFilter();
        }
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
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

    public LocalDateFilter getExpDt() {
        return expDt;
    }

    public LocalDateFilter expDt() {
        if (expDt == null) {
            expDt = new LocalDateFilter();
        }
        return expDt;
    }

    public void setExpDt(LocalDateFilter expDt) {
        this.expDt = expDt;
    }

    public LongFilter getCerfCompanyId() {
        return cerfCompanyId;
    }

    public LongFilter cerfCompanyId() {
        if (cerfCompanyId == null) {
            cerfCompanyId = new LongFilter();
        }
        return cerfCompanyId;
    }

    public void setCerfCompanyId(LongFilter cerfCompanyId) {
        this.cerfCompanyId = cerfCompanyId;
    }

    public LongFilter getFeeId() {
        return feeId;
    }

    public LongFilter feeId() {
        if (feeId == null) {
            feeId = new LongFilter();
        }
        return feeId;
    }

    public void setFeeId(LongFilter feeId) {
        this.feeId = feeId;
    }

    public LongFilter getMarkId() {
        return markId;
    }

    public LongFilter markId() {
        if (markId == null) {
            markId = new LongFilter();
        }
        return markId;
    }

    public void setMarkId(LongFilter markId) {
        this.markId = markId;
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

    public LongFilter getStdId() {
        return stdId;
    }

    public LongFilter stdId() {
        if (stdId == null) {
            stdId = new LongFilter();
        }
        return stdId;
    }

    public void setStdId(LongFilter stdId) {
        this.stdId = stdId;
    }

    public LongFilter getCountryId() {
        return countryId;
    }

    public LongFilter countryId() {
        if (countryId == null) {
            countryId = new LongFilter();
        }
        return countryId;
    }

    public void setCountryId(LongFilter countryId) {
        this.countryId = countryId;
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
            Objects.equals(status, that.status) &&
            Objects.equals(issuDt, that.issuDt) &&
            Objects.equals(expDt, that.expDt) &&
            Objects.equals(cerfCompanyId, that.cerfCompanyId) &&
            Objects.equals(feeId, that.feeId) &&
            Objects.equals(markId, that.markId) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(stdId, that.stdId) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfNo, cerfVer, status, issuDt, expDt, cerfCompanyId, feeId, markId, prodId, stdId, countryId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            (issuDt != null ? "issuDt=" + issuDt + ", " : "") +
            (expDt != null ? "expDt=" + expDt + ", " : "") +
            (cerfCompanyId != null ? "cerfCompanyId=" + cerfCompanyId + ", " : "") +
            (feeId != null ? "feeId=" + feeId + ", " : "") +
            (markId != null ? "markId=" + markId + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (stdId != null ? "stdId=" + stdId + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
