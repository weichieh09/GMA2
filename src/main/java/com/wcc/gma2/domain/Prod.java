package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Prod.
 */
@Entity
@Table(name = "prod")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "prod_id")
    private String prodId;

    @Column(name = "mnfctr_id")
    private String mnfctrId;

    @Column(name = "prod_nm_ch")
    private String prodNmCh;

    @Column(name = "prod_nm_en")
    private String prodNmEn;

    @Column(name = "hs_cd")
    private String hsCd;

    @Column(name = "ccc_cd")
    private String cccCd;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Prod id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdId() {
        return this.prodId;
    }

    public Prod prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return this.mnfctrId;
    }

    public Prod mnfctrId(String mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getProdNmCh() {
        return this.prodNmCh;
    }

    public Prod prodNmCh(String prodNmCh) {
        this.setProdNmCh(prodNmCh);
        return this;
    }

    public void setProdNmCh(String prodNmCh) {
        this.prodNmCh = prodNmCh;
    }

    public String getProdNmEn() {
        return this.prodNmEn;
    }

    public Prod prodNmEn(String prodNmEn) {
        this.setProdNmEn(prodNmEn);
        return this;
    }

    public void setProdNmEn(String prodNmEn) {
        this.prodNmEn = prodNmEn;
    }

    public String getHsCd() {
        return this.hsCd;
    }

    public Prod hsCd(String hsCd) {
        this.setHsCd(hsCd);
        return this;
    }

    public void setHsCd(String hsCd) {
        this.hsCd = hsCd;
    }

    public String getCccCd() {
        return this.cccCd;
    }

    public Prod cccCd(String cccCd) {
        this.setCccCd(cccCd);
        return this;
    }

    public void setCccCd(String cccCd) {
        this.cccCd = cccCd;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Prod lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Prod lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Prod)) {
            return false;
        }
        return id != null && id.equals(((Prod) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", prodNmCh='" + getProdNmCh() + "'" +
            ", prodNmEn='" + getProdNmEn() + "'" +
            ", hsCd='" + getHsCd() + "'" +
            ", cccCd='" + getCccCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
