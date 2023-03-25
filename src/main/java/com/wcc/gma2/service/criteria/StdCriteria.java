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

    private StringFilter enName;

    private StringFilter chName;

    private StringFilter status;

    private LocalDateFilter issuDt;

    private LocalDateFilter expDt;

    private LongFilter prodId;

    private LongFilter cerfId;

    private LongFilter countryId;

    private Boolean distinct;

    public StdCriteria() {}

    public StdCriteria(StdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.stdNo = other.stdNo == null ? null : other.stdNo.copy();
        this.stdVer = other.stdVer == null ? null : other.stdVer.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.chName = other.chName == null ? null : other.chName.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.issuDt = other.issuDt == null ? null : other.issuDt.copy();
        this.expDt = other.expDt == null ? null : other.expDt.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
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

    public StringFilter getEnName() {
        return enName;
    }

    public StringFilter enName() {
        if (enName == null) {
            enName = new StringFilter();
        }
        return enName;
    }

    public void setEnName(StringFilter enName) {
        this.enName = enName;
    }

    public StringFilter getChName() {
        return chName;
    }

    public StringFilter chName() {
        if (chName == null) {
            chName = new StringFilter();
        }
        return chName;
    }

    public void setChName(StringFilter chName) {
        this.chName = chName;
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

    public LongFilter getCerfId() {
        return cerfId;
    }

    public LongFilter cerfId() {
        if (cerfId == null) {
            cerfId = new LongFilter();
        }
        return cerfId;
    }

    public void setCerfId(LongFilter cerfId) {
        this.cerfId = cerfId;
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
        final StdCriteria that = (StdCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(stdNo, that.stdNo) &&
            Objects.equals(stdVer, that.stdVer) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(chName, that.chName) &&
            Objects.equals(status, that.status) &&
            Objects.equals(issuDt, that.issuDt) &&
            Objects.equals(expDt, that.expDt) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stdNo, stdVer, enName, chName, status, issuDt, expDt, prodId, cerfId, countryId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (stdNo != null ? "stdNo=" + stdNo + ", " : "") +
            (stdVer != null ? "stdVer=" + stdVer + ", " : "") +
            (enName != null ? "enName=" + enName + ", " : "") +
            (chName != null ? "chName=" + chName + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            (issuDt != null ? "issuDt=" + issuDt + ", " : "") +
            (expDt != null ? "expDt=" + expDt + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
