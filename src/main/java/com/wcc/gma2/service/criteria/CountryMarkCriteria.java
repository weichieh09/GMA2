package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CountryMark} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CountryMarkResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /country-marks?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CountryMarkCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter relType;

    private LongFilter countryId;

    private LongFilter markId;

    private Boolean distinct;

    public CountryMarkCriteria() {}

    public CountryMarkCriteria(CountryMarkCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.relType = other.relType == null ? null : other.relType.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
        this.markId = other.markId == null ? null : other.markId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CountryMarkCriteria copy() {
        return new CountryMarkCriteria(this);
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
        final CountryMarkCriteria that = (CountryMarkCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(relType, that.relType) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(markId, that.markId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, relType, countryId, markId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryMarkCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (relType != null ? "relType=" + relType + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (markId != null ? "markId=" + markId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
