package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CerfProd} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CerfProdResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-prods?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfProdCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter relType;

    private LongFilter cerfId;

    private LongFilter prodId;

    private Boolean distinct;

    public CerfProdCriteria() {}

    public CerfProdCriteria(CerfProdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.relType = other.relType == null ? null : other.relType.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CerfProdCriteria copy() {
        return new CerfProdCriteria(this);
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
        final CerfProdCriteria that = (CerfProdCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(relType, that.relType) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, relType, cerfId, prodId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfProdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (relType != null ? "relType=" + relType + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
