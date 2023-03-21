package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Cerf2StdView} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Cerf2StdViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-2-std-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2StdViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter stdNo;

    private StringFilter stdVer;

    private Boolean distinct;

    public Cerf2StdViewCriteria() {}

    public Cerf2StdViewCriteria(Cerf2StdViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.stdNo = other.stdNo == null ? null : other.stdNo.copy();
        this.stdVer = other.stdVer == null ? null : other.stdVer.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Cerf2StdViewCriteria copy() {
        return new Cerf2StdViewCriteria(this);
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

    public StringFilter getStdNo() {
        return stdNo;
    }

    public StringFilter stdNo() {
        if (stdNo == null) {
            stdNo = new StringFilter();
        }
        return stdNo;
    }

    public void setStdNo(StringFilter stdNo) {
        this.stdNo = stdNo;
    }

    public StringFilter getStdVer() {
        return stdVer;
    }

    public StringFilter stdVer() {
        if (stdVer == null) {
            stdVer = new StringFilter();
        }
        return stdVer;
    }

    public void setStdVer(StringFilter stdVer) {
        this.stdVer = stdVer;
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
        final Cerf2StdViewCriteria that = (Cerf2StdViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(stdNo, that.stdNo) &&
            Objects.equals(stdVer, that.stdVer) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfNo, cerfVer, stdNo, stdVer, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2StdViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (stdNo != null ? "stdNo=" + stdNo + ", " : "") +
            (stdVer != null ? "stdVer=" + stdVer + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
