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

    private StringFilter prodId;

    private StringFilter mnfctrId;

    private StringFilter prodNmCh;

    private StringFilter prodNmEn;

    private StringFilter hsCd;

    private StringFilter cccCd;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public ProdCriteria() {}

    public ProdCriteria(ProdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.mnfctrId = other.mnfctrId == null ? null : other.mnfctrId.copy();
        this.prodNmCh = other.prodNmCh == null ? null : other.prodNmCh.copy();
        this.prodNmEn = other.prodNmEn == null ? null : other.prodNmEn.copy();
        this.hsCd = other.hsCd == null ? null : other.hsCd.copy();
        this.cccCd = other.cccCd == null ? null : other.cccCd.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
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

    public StringFilter getMnfctrId() {
        return mnfctrId;
    }

    public StringFilter mnfctrId() {
        if (mnfctrId == null) {
            mnfctrId = new StringFilter();
        }
        return mnfctrId;
    }

    public void setMnfctrId(StringFilter mnfctrId) {
        this.mnfctrId = mnfctrId;
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

    public StringFilter getProdNmEn() {
        return prodNmEn;
    }

    public StringFilter prodNmEn() {
        if (prodNmEn == null) {
            prodNmEn = new StringFilter();
        }
        return prodNmEn;
    }

    public void setProdNmEn(StringFilter prodNmEn) {
        this.prodNmEn = prodNmEn;
    }

    public StringFilter getHsCd() {
        return hsCd;
    }

    public StringFilter hsCd() {
        if (hsCd == null) {
            hsCd = new StringFilter();
        }
        return hsCd;
    }

    public void setHsCd(StringFilter hsCd) {
        this.hsCd = hsCd;
    }

    public StringFilter getCccCd() {
        return cccCd;
    }

    public StringFilter cccCd() {
        if (cccCd == null) {
            cccCd = new StringFilter();
        }
        return cccCd;
    }

    public void setCccCd(StringFilter cccCd) {
        this.cccCd = cccCd;
    }

    public StringFilter getLstMtnUsr() {
        return lstMtnUsr;
    }

    public StringFilter lstMtnUsr() {
        if (lstMtnUsr == null) {
            lstMtnUsr = new StringFilter();
        }
        return lstMtnUsr;
    }

    public void setLstMtnUsr(StringFilter lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDateFilter getLstMtnDt() {
        return lstMtnDt;
    }

    public LocalDateFilter lstMtnDt() {
        if (lstMtnDt == null) {
            lstMtnDt = new LocalDateFilter();
        }
        return lstMtnDt;
    }

    public void setLstMtnDt(LocalDateFilter lstMtnDt) {
        this.lstMtnDt = lstMtnDt;
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
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(mnfctrId, that.mnfctrId) &&
            Objects.equals(prodNmCh, that.prodNmCh) &&
            Objects.equals(prodNmEn, that.prodNmEn) &&
            Objects.equals(hsCd, that.hsCd) &&
            Objects.equals(cccCd, that.cccCd) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prodId, mnfctrId, prodNmCh, prodNmEn, hsCd, cccCd, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProdCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (mnfctrId != null ? "mnfctrId=" + mnfctrId + ", " : "") +
            (prodNmCh != null ? "prodNmCh=" + prodNmCh + ", " : "") +
            (prodNmEn != null ? "prodNmEn=" + prodNmEn + ", " : "") +
            (hsCd != null ? "hsCd=" + hsCd + ", " : "") +
            (cccCd != null ? "cccCd=" + cccCd + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
