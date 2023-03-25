package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Prod} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.ProdResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /prods?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProdCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter prodNo;

    private StringFilter enName;

    private StringFilter chName;

    private StringFilter hsCode;

    private StringFilter cccCode;

    private LongFilter countryId;

    private LongFilter stdId;

    private LongFilter markId;

    private LongFilter cerfId;

    private Boolean distinct;

    public ProdCriteria() {}

    public ProdCriteria(ProdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.prodNo = other.prodNo == null ? null : other.prodNo.copy();
        this.enName = other.enName == null ? null : other.enName.copy();
        this.chName = other.chName == null ? null : other.chName.copy();
        this.hsCode = other.hsCode == null ? null : other.hsCode.copy();
        this.cccCode = other.cccCode == null ? null : other.cccCode.copy();
        this.countryId = other.countryId == null ? null : other.countryId.copy();
        this.stdId = other.stdId == null ? null : other.stdId.copy();
        this.markId = other.markId == null ? null : other.markId.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ProdCriteria copy() {
        return new ProdCriteria(this);
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

    public StringFilter getHsCode() {
        return hsCode;
    }

    public StringFilter hsCode() {
        if (hsCode == null) {
            hsCode = new StringFilter();
        }
        return hsCode;
    }

    public void setHsCode(StringFilter hsCode) {
        this.hsCode = hsCode;
    }

    public StringFilter getCccCode() {
        return cccCode;
    }

    public StringFilter cccCode() {
        if (cccCode == null) {
            cccCode = new StringFilter();
        }
        return cccCode;
    }

    public void setCccCode(StringFilter cccCode) {
        this.cccCode = cccCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProdCriteria that = (ProdCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(prodNo, that.prodNo) &&
            Objects.equals(enName, that.enName) &&
            Objects.equals(chName, that.chName) &&
            Objects.equals(hsCode, that.hsCode) &&
            Objects.equals(cccCode, that.cccCode) &&
            Objects.equals(countryId, that.countryId) &&
            Objects.equals(stdId, that.stdId) &&
            Objects.equals(markId, that.markId) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prodNo, enName, chName, hsCode, cccCode, countryId, stdId, markId, cerfId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (prodNo != null ? "prodNo=" + prodNo + ", " : "") +
            (enName != null ? "enName=" + enName + ", " : "") +
            (chName != null ? "chName=" + chName + ", " : "") +
            (hsCode != null ? "hsCode=" + hsCode + ", " : "") +
            (cccCode != null ? "cccCode=" + cccCode + ", " : "") +
            (countryId != null ? "countryId=" + countryId + ", " : "") +
            (stdId != null ? "stdId=" + stdId + ", " : "") +
            (markId != null ? "markId=" + markId + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
