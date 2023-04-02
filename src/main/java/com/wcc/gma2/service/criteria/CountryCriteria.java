package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Country} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CountryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /countries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CountryCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter countryNo;

    private StringFilter enName;

    private StringFilter chName;

    private LongFilter prodCountryId;

    private LongFilter countryStdId;

    private LongFilter countryCertId;

    private LongFilter countryMarkId;

    private Boolean distinct;

    public CountryCriteria() {}

    public CountryCriteria(CountryCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.countryNo = other.countryNo == null ? null : other.countryNo.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.chName = other.chName == null ? null : other.chName.copy();
        this.prodCountryId = other.prodCountryId == null ? null : other.prodCountryId.copy();
        this.countryStdId = other.countryStdId == null ? null : other.countryStdId.copy();
        this.countryCertId = other.countryCertId == null ? null : other.countryCertId.copy();
        this.countryMarkId = other.countryMarkId == null ? null : other.countryMarkId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CountryCriteria copy() {
        return new CountryCriteria(this);
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

    public StringFilter getCountryNo() {
        return countryNo;
    }

    public StringFilter countryNo() {
        if (countryNo == null) {
            countryNo = new StringFilter();
        }
        return countryNo;
    }

    public void setCountryNo(StringFilter countryNo) {
        this.countryNo = countryNo;
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

    public LongFilter getProdCountryId() {
        return prodCountryId;
    }

    public LongFilter prodCountryId() {
        if (prodCountryId == null) {
            prodCountryId = new LongFilter();
        }
        return prodCountryId;
    }

    public void setProdCountryId(LongFilter prodCountryId) {
        this.prodCountryId = prodCountryId;
    }

    public LongFilter getCountryStdId() {
        return countryStdId;
    }

    public LongFilter countryStdId() {
        if (countryStdId == null) {
            countryStdId = new LongFilter();
        }
        return countryStdId;
    }

    public void setCountryStdId(LongFilter countryStdId) {
        this.countryStdId = countryStdId;
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

    public LongFilter getCountryMarkId() {
        return countryMarkId;
    }

    public LongFilter countryMarkId() {
        if (countryMarkId == null) {
            countryMarkId = new LongFilter();
        }
        return countryMarkId;
    }

    public void setCountryMarkId(LongFilter countryMarkId) {
        this.countryMarkId = countryMarkId;
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
        final CountryCriteria that = (CountryCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(countryNo, that.countryNo) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(chName, that.chName) &&
            Objects.equals(prodCountryId, that.prodCountryId) &&
            Objects.equals(countryStdId, that.countryStdId) &&
            Objects.equals(countryCertId, that.countryCertId) &&
            Objects.equals(countryMarkId, that.countryMarkId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryNo, enName, chName, prodCountryId, countryStdId, countryCertId, countryMarkId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (countryNo != null ? "countryNo=" + countryNo + ", " : "") +
            (enName != null ? "enName=" + enName + ", " : "") +
            (chName != null ? "chName=" + chName + ", " : "") +
            (prodCountryId != null ? "prodCountryId=" + prodCountryId + ", " : "") +
            (countryStdId != null ? "countryStdId=" + countryStdId + ", " : "") +
            (countryCertId != null ? "countryCertId=" + countryCertId + ", " : "") +
            (countryMarkId != null ? "countryMarkId=" + countryMarkId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
