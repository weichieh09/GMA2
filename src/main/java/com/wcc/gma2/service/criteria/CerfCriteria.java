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

    private LongFilter cerfProdId;

    private LongFilter cerfStdId;

    private LongFilter cerfMarkId;

    private LongFilter cerfCompanyId;

    private LongFilter feeProdCerfCompanyId;

    private LongFilter countryCertId;

    private Boolean distinct;

    public CerfCriteria() {}

    public CerfCriteria(CerfCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.issuDt = other.issuDt == null ? null : other.issuDt.copy();
        this.expDt = other.expDt == null ? null : other.expDt.copy();
        this.cerfProdId = other.cerfProdId == null ? null : other.cerfProdId.copy();
        this.cerfStdId = other.cerfStdId == null ? null : other.cerfStdId.copy();
        this.cerfMarkId = other.cerfMarkId == null ? null : other.cerfMarkId.copy();
        this.cerfCompanyId = other.cerfCompanyId == null ? null : other.cerfCompanyId.copy();
        this.feeProdCerfCompanyId = other.feeProdCerfCompanyId == null ? null : other.feeProdCerfCompanyId.copy();
        this.countryCertId = other.countryCertId == null ? null : other.countryCertId.copy();
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

    public LongFilter getCerfProdId() {
        return cerfProdId;
    }

    public LongFilter cerfProdId() {
        if (cerfProdId == null) {
            cerfProdId = new LongFilter();
        }
        return cerfProdId;
    }

    public void setCerfProdId(LongFilter cerfProdId) {
        this.cerfProdId = cerfProdId;
    }

    public LongFilter getCerfStdId() {
        return cerfStdId;
    }

    public LongFilter cerfStdId() {
        if (cerfStdId == null) {
            cerfStdId = new LongFilter();
        }
        return cerfStdId;
    }

    public void setCerfStdId(LongFilter cerfStdId) {
        this.cerfStdId = cerfStdId;
    }

    public LongFilter getCerfMarkId() {
        return cerfMarkId;
    }

    public LongFilter cerfMarkId() {
        if (cerfMarkId == null) {
            cerfMarkId = new LongFilter();
        }
        return cerfMarkId;
    }

    public void setCerfMarkId(LongFilter cerfMarkId) {
        this.cerfMarkId = cerfMarkId;
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

    public LongFilter getFeeProdCerfCompanyId() {
        return feeProdCerfCompanyId;
    }

    public LongFilter feeProdCerfCompanyId() {
        if (feeProdCerfCompanyId == null) {
            feeProdCerfCompanyId = new LongFilter();
        }
        return feeProdCerfCompanyId;
    }

    public void setFeeProdCerfCompanyId(LongFilter feeProdCerfCompanyId) {
        this.feeProdCerfCompanyId = feeProdCerfCompanyId;
    }

    public LongFilter getCountryCertId() {
        return countryCertId;
    }

    public LongFilter countryCertId() {
        if (countryCertId == null) {
            countryCertId = new LongFilter();
        }
        return countryCertId;
    }

    public void setCountryCertId(LongFilter countryCertId) {
        this.countryCertId = countryCertId;
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
            Objects.equals(cerfProdId, that.cerfProdId) &&
            Objects.equals(cerfStdId, that.cerfStdId) &&
            Objects.equals(cerfMarkId, that.cerfMarkId) &&
            Objects.equals(cerfCompanyId, that.cerfCompanyId) &&
            Objects.equals(feeProdCerfCompanyId, that.feeProdCerfCompanyId) &&
            Objects.equals(countryCertId, that.countryCertId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            cerfNo,
            cerfVer,
            status,
            issuDt,
            expDt,
            cerfProdId,
            cerfStdId,
            cerfMarkId,
            cerfCompanyId,
            feeProdCerfCompanyId,
            countryCertId,
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
            (status != null ? "status=" + status + ", " : "") +
            (issuDt != null ? "issuDt=" + issuDt + ", " : "") +
            (expDt != null ? "expDt=" + expDt + ", " : "") +
            (cerfProdId != null ? "cerfProdId=" + cerfProdId + ", " : "") +
            (cerfStdId != null ? "cerfStdId=" + cerfStdId + ", " : "") +
            (cerfMarkId != null ? "cerfMarkId=" + cerfMarkId + ", " : "") +
            (cerfCompanyId != null ? "cerfCompanyId=" + cerfCompanyId + ", " : "") +
            (feeProdCerfCompanyId != null ? "feeProdCerfCompanyId=" + feeProdCerfCompanyId + ", " : "") +
            (countryCertId != null ? "countryCertId=" + countryCertId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
