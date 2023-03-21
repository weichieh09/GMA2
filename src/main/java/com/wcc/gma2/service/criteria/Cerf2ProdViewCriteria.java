package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Cerf2ProdView} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Cerf2ProdViewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cerf-2-prod-views?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2ProdViewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cerfNo;

    private StringFilter cerfVer;

    private StringFilter prodId;

    private StringFilter prodNmCh;

    private Boolean distinct;

    public Cerf2ProdViewCriteria() {}

    public Cerf2ProdViewCriteria(Cerf2ProdViewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cerfNo = other.cerfNo == null ? null : other.cerfNo.copy();
        this.cerfVer = other.cerfVer == null ? null : other.cerfVer.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.prodNmCh = other.prodNmCh == null ? null : other.prodNmCh.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Cerf2ProdViewCriteria copy() {
        return new Cerf2ProdViewCriteria(this);
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

    public StringFilter getProdId() {
        return prodId;
    }

    public StringFilter prodId() {
        if (prodId == null) {
            prodId = new StringFilter();
        }
        return prodId;
    }

    public void setProdId(StringFilter prodId) {
        this.prodId = prodId;
    }

    public StringFilter getProdNmCh() {
        return prodNmCh;
    }

    public StringFilter prodNmCh() {
        if (prodNmCh == null) {
            prodNmCh = new StringFilter();
        }
        return prodNmCh;
    }

    public void setProdNmCh(StringFilter prodNmCh) {
        this.prodNmCh = prodNmCh;
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
        final Cerf2ProdViewCriteria that = (Cerf2ProdViewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cerfNo, that.cerfNo) &&
            Objects.equals(cerfVer, that.cerfVer) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(prodNmCh, that.prodNmCh) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cerfNo, cerfVer, prodId, prodNmCh, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2ProdViewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cerfNo != null ? "cerfNo=" + cerfNo + ", " : "") +
            (cerfVer != null ? "cerfVer=" + cerfVer + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (prodNmCh != null ? "prodNmCh=" + prodNmCh + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
