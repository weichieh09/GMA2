package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Mnfctr.
 */
@Entity
@Table(name = "mnfctr")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Mnfctr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "uni_no")
    private String uniNo;

    @Column(name = "mnfctr_nm_en")
    private String mnfctrNmEn;

    @Column(name = "mnfctr_nm_ch")
    private String mnfctrNmCh;

    @Column(name = "contact")
    private String contact;

    @Column(name = "eamil")
    private String eamil;

    @Column(name = "addr")
    private String addr;

    @Column(name = "tel")
    private String tel;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Mnfctr id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniNo() {
        return this.uniNo;
    }

    public Mnfctr uniNo(String uniNo) {
        this.setUniNo(uniNo);
        return this;
    }

    public void setUniNo(String uniNo) {
        this.uniNo = uniNo;
    }

    public String getMnfctrNmEn() {
        return this.mnfctrNmEn;
    }

    public Mnfctr mnfctrNmEn(String mnfctrNmEn) {
        this.setMnfctrNmEn(mnfctrNmEn);
        return this;
    }

    public void setMnfctrNmEn(String mnfctrNmEn) {
        this.mnfctrNmEn = mnfctrNmEn;
    }

    public String getMnfctrNmCh() {
        return this.mnfctrNmCh;
    }

    public Mnfctr mnfctrNmCh(String mnfctrNmCh) {
        this.setMnfctrNmCh(mnfctrNmCh);
        return this;
    }

    public void setMnfctrNmCh(String mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
    }

    public String getContact() {
        return this.contact;
    }

    public Mnfctr contact(String contact) {
        this.setContact(contact);
        return this;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEamil() {
        return this.eamil;
    }

    public Mnfctr eamil(String eamil) {
        this.setEamil(eamil);
        return this;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getAddr() {
        return this.addr;
    }

    public Mnfctr addr(String addr) {
        this.setAddr(addr);
        return this;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return this.tel;
    }

    public Mnfctr tel(String tel) {
        this.setTel(tel);
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Mnfctr lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Mnfctr lstMtnDt(LocalDate lstMtnDt) {
        this.setLstMtnDt(lstMtnDt);
        return this;
    }

    public void setLstMtnDt(LocalDate lstMtnDt) {
        this.lstMtnDt = lstMtnDt;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mnfctr)) {
            return false;
        }
        return id != null && id.equals(((Mnfctr) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Mnfctr{" +
            "id=" + getId() +
            ", uniNo='" + getUniNo() + "'" +
            ", mnfctrNmEn='" + getMnfctrNmEn() + "'" +
            ", mnfctrNmCh='" + getMnfctrNmCh() + "'" +
            ", contact='" + getContact() + "'" +
            ", eamil='" + getEamil() + "'" +
            ", addr='" + getAddr() + "'" +
            ", tel='" + getTel() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
