package com.wcc.gma2.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.wcc.gma2.domain.Mnfctr} entity. This class is used
 * in {@link com.wcc.gma2.web.rest.MnfctrResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /mnfctrs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MnfctrCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter uniNo;

    private StringFilter mnfctrNmEn;

    private StringFilter mnfctrNmCh;

    private StringFilter contact;

    private StringFilter eamil;

    private StringFilter addr;

    private StringFilter tel;

    private StringFilter lstMtnUsr;

    private LocalDateFilter lstMtnDt;

    private Boolean distinct;

    public MnfctrCriteria() {}

    public MnfctrCriteria(MnfctrCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.uniNo = other.uniNo == null ? null : other.uniNo.copy();
        this.mnfctrNmEn = other.mnfctrNmEn == null ? null : other.mnfctrNmEn.copy();
        this.mnfctrNmCh = other.mnfctrNmCh == null ? null : other.mnfctrNmCh.copy();
        this.contact = other.contact == null ? null : other.contact.copy();
        this.eamil = other.eamil == null ? null : other.eamil.copy();
        this.addr = other.addr == null ? null : other.addr.copy();
        this.tel = other.tel == null ? null : other.tel.copy();
        this.lstMtnUsr = other.lstMtnUsr == null ? null : other.lstMtnUsr.copy();
        this.lstMtnDt = other.lstMtnDt == null ? null : other.lstMtnDt.copy();
        this.distinct = other.distinct;
    }

    @Override
    public MnfctrCriteria copy() {
        return new MnfctrCriteria(this);
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

    public StringFilter getUniNo() {
        return uniNo;
    }

    public StringFilter uniNo() {
        if (uniNo == null) {
            uniNo = new StringFilter();
        }
        return uniNo;
    }

    public void setUniNo(StringFilter uniNo) {
        this.uniNo = uniNo;
    }

    public StringFilter getMnfctrNmEn() {
        return mnfctrNmEn;
    }

    public StringFilter mnfctrNmEn() {
        if (mnfctrNmEn == null) {
            mnfctrNmEn = new StringFilter();
        }
        return mnfctrNmEn;
    }

    public void setMnfctrNmEn(StringFilter mnfctrNmEn) {
        this.mnfctrNmEn = mnfctrNmEn;
    }

    public StringFilter getMnfctrNmCh() {
        return mnfctrNmCh;
    }

    public StringFilter mnfctrNmCh() {
        if (mnfctrNmCh == null) {
            mnfctrNmCh = new StringFilter();
        }
        return mnfctrNmCh;
    }

    public void setMnfctrNmCh(StringFilter mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
    }

    public StringFilter getContact() {
        return contact;
    }

    public StringFilter contact() {
        if (contact == null) {
            contact = new StringFilter();
        }
        return contact;
    }

    public void setContact(StringFilter contact) {
        this.contact = contact;
    }

    public StringFilter getEamil() {
        return eamil;
    }

    public StringFilter eamil() {
        if (eamil == null) {
            eamil = new StringFilter();
        }
        return eamil;
    }

    public void setEamil(StringFilter eamil) {
        this.eamil = eamil;
    }

    public StringFilter getAddr() {
        return addr;
    }

    public StringFilter addr() {
        if (addr == null) {
            addr = new StringFilter();
        }
        return addr;
    }

    public void setAddr(StringFilter addr) {
        this.addr = addr;
    }

    public StringFilter getTel() {
        return tel;
    }

    public StringFilter tel() {
        if (tel == null) {
            tel = new StringFilter();
        }
        return tel;
    }

    public void setTel(StringFilter tel) {
        this.tel = tel;
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
        final MnfctrCriteria that = (MnfctrCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(uniNo, that.uniNo) &&
            Objects.equals(mnfctrNmEn, that.mnfctrNmEn) &&
            Objects.equals(mnfctrNmCh, that.mnfctrNmCh) &&
            Objects.equals(contact, that.contact) &&
            Objects.equals(eamil, that.eamil) &&
            Objects.equals(addr, that.addr) &&
            Objects.equals(tel, that.tel) &&
            Objects.equals(lstMtnUsr, that.lstMtnUsr) &&
            Objects.equals(lstMtnDt, that.lstMtnDt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uniNo, mnfctrNmEn, mnfctrNmCh, contact, eamil, addr, tel, lstMtnUsr, lstMtnDt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MnfctrCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (uniNo != null ? "uniNo=" + uniNo + ", " : "") +
            (mnfctrNmEn != null ? "mnfctrNmEn=" + mnfctrNmEn + ", " : "") +
            (mnfctrNmCh != null ? "mnfctrNmCh=" + mnfctrNmCh + ", " : "") +
            (contact != null ? "contact=" + contact + ", " : "") +
            (eamil != null ? "eamil=" + eamil + ", " : "") +
            (addr != null ? "addr=" + addr + ", " : "") +
            (tel != null ? "tel=" + tel + ", " : "") +
            (lstMtnUsr != null ? "lstMtnUsr=" + lstMtnUsr + ", " : "") +
            (lstMtnDt != null ? "lstMtnDt=" + lstMtnDt + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
