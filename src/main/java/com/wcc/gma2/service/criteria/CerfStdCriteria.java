package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.CerfStd} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.CerfStdResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-stds?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfStdCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter relType;

    private LongFilter cerfId;

    private LongFilter stdId;

    private Boolean distinct;

    public CerfStdCriteria() {}

    public CerfStdCriteria(CerfStdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.relType = other.relType == null ? null : other.relType.copy();
        this.cerfId = other.cerfId == null ? null : other.cerfId.copy();
        this.stdId = other.stdId == null ? null : other.stdId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CerfStdCriteria copy() {
        return new CerfStdCriteria(this);
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
        final CerfStdCriteria that = (CerfStdCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(relType, that.relType) &&
            Objects.equals(cerfId, that.cerfId) &&
            Objects.equals(stdId, that.stdId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, relType, cerfId, stdId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfStdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (relType != null ? "relType=" + relType + ", " : "") +
            (cerfId != null ? "cerfId=" + cerfId + ", " : "") +
            (stdId != null ? "stdId=" + stdId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
