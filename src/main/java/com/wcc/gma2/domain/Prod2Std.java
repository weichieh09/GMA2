package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Prod2Std.
 */
@Entity
@Table(name = "prod_2_std")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2Std implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceProd2Std")
    @SequenceGenerator(name = "sequenceProd2Std")
    @Column(name = "id")
    private Long id;

    @Column(name = "prod_id")
    private String prodId;

    @Column(name = "mnfctr_id")
    private String mnfctrId;

    @Column(name = "std_no")
    private String stdNo;

    @Column(name = "std_ver")
    private String stdVer;

    @Column(name = "sts_cd")
    private String stsCd;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Prod2Std id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdId() {
        return this.prodId;
    }

    public Prod2Std prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return this.mnfctrId;
    }

    public Prod2Std mnfctrId(String mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getStdNo() {
        return this.stdNo;
    }

    public Prod2Std stdNo(String stdNo) {
        this.setStdNo(stdNo);
        return this;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return this.stdVer;
    }

    public Prod2Std stdVer(String stdVer) {
        this.setStdVer(stdVer);
        return this;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public Prod2Std stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Prod2Std lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Prod2Std lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Prod2Std)) {
            return false;
        }
        return id != null && id.equals(((Prod2Std) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2Std{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
