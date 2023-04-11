package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Wcc412View} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Wcc412ViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /wcc-412-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Wcc412ViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter cerfId;

    private StringFilter countryChName;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter cerfStatus;

    private LongFilter countryId;

    private StringFilter prodNo;

    private StringFilter prodChName;

    private Boolean distinct;

    public Wcc412ViewCriteria() {}

    public Wcc412ViewCriteria(Wcc412ViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.countryChName = other.countryChName == null ? null : other.countryChName.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.cerfStatus = other.cerfStatus == null ? null : other.cerfStatus.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
        this.prodNo = other.prodNo == null ? null : other.prodNo.copy();
        this.prodChName = other.prodChName == null ? null : other.prodChName.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Wcc412ViewCriteria copy() {
        return new Wcc412ViewCriteria(this);
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

    public StringFilter getCountryChName() {
        return countryChName;
    }

    public StringFilter countryChName() {
        if (countryChName == null) {
            countryChName = new StringFilter();
        }
        return countryChName;
    }

    public void setCountryChName(StringFilter countryChName) {
        this.countryChName = countryChName;
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

    public StringFilter getCerfStatus() {
        return cerfStatus;
    }

    public StringFilter cerfStatus() {
        if (cerfStatus == null) {
            cerfStatus = new StringFilter();
        }
        return cerfStatus;
    }

    public void setCerfStatus(StringFilter cerfStatus) {
        this.cerfStatus = cerfStatus;
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

    public StringFilter getProdNo() {
        return prodNo;
    }

    public StringFilter prodNo() {
        if (prodNo == null) {
            prodNo = new StringFilter();
        }
        return prodNo;
    }

    public void setProdNo(StringFilter prodNo) {
        this.prodNo = prodNo;
    }

    public StringFilter getProdChName() {
        return prodChName;
    }

    public StringFilter prodChName() {
        if (prodChName == null) {
            prodChName = new StringFilter();
        }
        return prodChName;
    }

    public void setProdChName(StringFilter prodChName) {
        this.prodChName = prodChName;
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
        final Wcc412ViewCriteria that = (Wcc412ViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(countryChName, that.countryChName) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(cerfStatus, that.cerfStatus) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(prodNo, that.prodNo) &&
            Objects.equals(prodChName, that.prodChName) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfId, countryChName, cerfNo, cerfVer, cerfStatus, countryId, prodNo, prodChName, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Wcc412ViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (countryChName != null ? "countryChName=" + countryChName + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (cerfStatus != null ? "cerfStatus=" + cerfStatus + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (prodNo != null ? "prodNo=" + prodNo + ", " : "") +
            (prodChName != null ? "prodChName=" + prodChName + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
