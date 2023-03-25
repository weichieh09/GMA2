package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Mark} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.MarkResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /marks?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MarkCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter markNo;

    private StringFilter enName;

    private StringFilter chName;

    private LongFilter countryId;

    private LongFilter prodId;

    private Boolean distinct;

    public MarkCriteria() {}

    public MarkCriteria(MarkCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.markNo = other.markNo == null ? null : other.markNo.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.chName = other.chName == null ? null : other.chName.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public MarkCriteria copy() {
        return new MarkCriteria(this);
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

    public StringFilter getMarkNo() {
        return markNo;
    }

    public StringFilter markNo() {
        if (markNo == null) {
            markNo = new StringFilter();
        }
        return markNo;
    }

    public void setMarkNo(StringFilter markNo) {
        this.markNo = markNo;
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
        final MarkCriteria that = (MarkCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(markNo, that.markNo) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(chName, that.chName) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, markNo, enName, chName, countryId, prodId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MarkCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (markNo != null ? "markNo=" + markNo + ", " : "") +
            (enName != null ? "enName=" + enName + ", " : "") +
            (chName != null ? "chName=" + chName + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
