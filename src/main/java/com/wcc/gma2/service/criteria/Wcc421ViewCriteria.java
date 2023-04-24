package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Wcc421View} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Wcc421ViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /wcc-421-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Wcc421ViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter cerfId;

    private StringFilter countryChName;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter cerfStatus;

    private StringFilter companyChName;

    private StringFilter relType;

    private Boolean distinct;

    public Wcc421ViewCriteria() {}

    public Wcc421ViewCriteria(Wcc421ViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.countryChName = other.countryChName == null ? null : other.countryChName.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.cerfStatus = other.cerfStatus == null ? null : other.cerfStatus.copy();
        this.companyChName = other.companyChName == null ? null : other.companyChName.copy();
        this.relType = other.relType == null ? null : other.relType.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Wcc421ViewCriteria copy() {
        return new Wcc421ViewCriteria(this);
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

    public StringFilter getCompanyChName() {
        return companyChName;
    }

    public StringFilter companyChName() {
        if (companyChName == null) {
            companyChName = new StringFilter();
        }
        return companyChName;
    }

    public void setCompanyChName(StringFilter companyChName) {
        this.companyChName = companyChName;
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
        final Wcc421ViewCriteria that = (Wcc421ViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(countryChName, that.countryChName) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(cerfStatus, that.cerfStatus) &&
            Objects.equals(companyChName, that.companyChName) &&
            Objects.equals(relType, that.relType) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfId, countryChName, cerfNo, cerfVer, cerfStatus, companyChName, relType, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Wcc421ViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (countryChName != null ? "countryChName=" + countryChName + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (cerfStatus != null ? "cerfStatus=" + cerfStatus + ", " : "") +
            (companyChName != null ? "companyChName=" + companyChName + ", " : "") +
            (relType != null ? "relType=" + relType + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
