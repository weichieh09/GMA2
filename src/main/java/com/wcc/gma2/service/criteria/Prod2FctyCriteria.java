package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Prod2Fcty} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.Prod2FctyResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /prod-2-fcties?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2FctyCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter prodId;

    private StringFilter mnfctrId;

    private StringFilter fctyId;

    private LocalDateFilter inspectDt;

    private StringFilter discontinueFg;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public Prod2FctyCriteria() {}

    public Prod2FctyCriteria(Prod2FctyCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.prodId = other.prodId == null ? null : other.prodId.copy();
        this.mnfctrId = other.mnfctrId == null ? null : other.mnfctrId.copy();
        this.fctyId = other.fctyId == null ? null : other.fctyId.copy();
        this.inspectDt = other.inspectDt == null ? null : other.inspectDt.copy();
        this.discontinueFg = other.discontinueFg == null ? null : other.discontinueFg.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public Prod2FctyCriteria copy() {
        return new Prod2FctyCriteria(this);
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

    public StringFilter getFctyId() {
        return fctyId;
    }

    public StringFilter fctyId() {
        if (fctyId == null) {
            fctyId = new StringFilter();
        }
        return fctyId;
    }

    public void setFctyId(StringFilter fctyId) {
        this.fctyId = fctyId;
    }

    public LocalDateFilter getInspectDt() {
        return inspectDt;
    }

    public LocalDateFilter inspectDt() {
        if (inspectDt == null) {
            inspectDt = new LocalDateFilter();
        }
        return inspectDt;
    }

    public void setInspectDt(LocalDateFilter inspectDt) {
        this.inspectDt = inspectDt;
    }

    public StringFilter getDiscontinueFg() {
        return discontinueFg;
    }

    public StringFilter discontinueFg() {
        if (discontinueFg == null) {
            discontinueFg = new StringFilter();
        }
        return discontinueFg;
    }

    public void setDiscontinueFg(StringFilter discontinueFg) {
        this.discontinueFg = discontinueFg;
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
        final Prod2FctyCriteria that = (Prod2FctyCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(prodId, that.prodId) &&
            Objects.equals(mnfctrId, that.mnfctrId) &&
            Objects.equals(fctyId, that.fctyId) &&
            Objects.equals(inspectDt, that.inspectDt) &&
            Objects.equals(discontinueFg, that.discontinueFg) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prodId, mnfctrId, fctyId, inspectDt, discontinueFg, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2FctyCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (prodId != null ? "prodId=" + prodId + ", " : "") +
            (mnfctrId != null ? "mnfctrId=" + mnfctrId + ", " : "") +
            (fctyId != null ? "fctyId=" + fctyId + ", " : "") +
            (inspectDt != null ? "inspectDt=" + inspectDt + ", " : "") +
            (discontinueFg != null ? "discontinueFg=" + discontinueFg + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
