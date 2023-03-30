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

    private LongFilter cerfId;

    private LongFilter markId;

    private LongFilter stdId;

    private LongFilter prodId;

    private Boolean distinct;

    public CountryCriteria() {}

    public CountryCriteria(CountryCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.countryNo = other.countryNo == null ? null : other.countryNo.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.chName = other.chName == null ? null : other.chName.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.markId = other.markId == null ? null : other.markId.copy();
        this.stdId = other.stdId == null ? null : other.stdId.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
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
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(markId, that.markId) &&
            Objects.equals(stdId, that.stdId) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryNo, enName, chName, cerfId, markId, stdId, prodId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (countryNo != null ? "countryNo=" + countryNo + ", " : "") +
            (enName != null ? "enName=" + enName + ", " : "") +
            (chName != null ? "chName=" + chName + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (markId != null ? "markId=" + markId + ", " : "") +
            (stdId != null ? "stdId=" + stdId + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
