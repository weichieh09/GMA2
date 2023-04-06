package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CountryCert} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CountryCertResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /country-certs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CountryCertCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter relType;

    private LongFilter countryId;

    private LongFilter cerfId;

    private Boolean distinct;

    private StringFilter cerfNo;

    private StringFilter status;

    public CountryCertCriteria() {}

    public CountryCertCriteria(CountryCertCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.relType = other.relType == null ? null : other.relType.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.distinct = other.distinct;
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.status = other.status == null ? null : other.status.copy();
    }

    @Override
    public CountryCertCriteria copy() {
        return new CountryCertCriteria(this);
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

    public StringFilter getRelType() {
        return relType;
    }

    public StringFilter relType() {
        if (relType == null) {
            relType = new StringFilter();
        }
        return relType;
    }

    public void setRelType(StringFilter relType) {
        this.relType = relType;
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

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CountryCertCriteria that = (CountryCertCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(relType, that.relType) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, relType, countryId, cerfId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryCertCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (relType != null ? "relType=" + relType + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            "}";
    }
}
