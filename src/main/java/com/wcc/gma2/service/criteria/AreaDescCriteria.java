package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.AreaDesc} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.AreaDescResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /area-descs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AreaDescCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter areaCd;

    private StringFilter areaDesc;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public AreaDescCriteria() {}

    public AreaDescCriteria(AreaDescCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.areaCd = other.areaCd == null ? null : other.areaCd.copy();
        this.areaDesc = other.areaDesc == null ? null : other.areaDesc.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public AreaDescCriteria copy() {
        return new AreaDescCriteria(this);
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

    public StringFilter getAreaCd() {
        return areaCd;
    }

    public StringFilter areaCd() {
        if (areaCd == null) {
            areaCd = new StringFilter();
        }
        return areaCd;
    }

    public void setAreaCd(StringFilter areaCd) {
        this.areaCd = areaCd;
    }

    public StringFilter getAreaDesc() {
        return areaDesc;
    }

    public StringFilter areaDesc() {
        if (areaDesc == null) {
            areaDesc = new StringFilter();
        }
        return areaDesc;
    }

    public void setAreaDesc(StringFilter areaDesc) {
        this.areaDesc = areaDesc;
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
        final AreaDescCriteria that = (AreaDescCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(areaCd, that.areaCd) &&
            Objects.equals(areaDesc, that.areaDesc) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, areaCd, areaDesc, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AreaDescCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (areaCd != null ? "areaCd=" + areaCd + ", " : "") +
            (areaDesc != null ? "areaDesc=" + areaDesc + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
