package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Prod2Cerf.
 */
@Entity
@Table(name = "prod_2_cerf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2Cerf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceProd2Cerf")
    @SequenceGenerator(name = "sequenceProd2Cerf")
    @Column(name = "id")
    private Long id;

    @Column(name = "prod_id")
    private String prodId;

    @Column(name = "mnfctr_id")
    private String mnfctrId;

    @Column(name = "cerf_no")
    private String cerfNo;

    @Column(name = "cerf_ver")
    private String cerfVer;

    @Column(name = "appl_id")
    private String applId;

    @Column(name = "area_cd")
    private String areaCd;

    @Column(name = "cerf_tag")
    private String cerfTag;

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

    public Prod2Cerf id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdId() {
        return this.prodId;
    }

    public Prod2Cerf prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return this.mnfctrId;
    }

    public Prod2Cerf mnfctrId(String mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public Prod2Cerf cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public Prod2Cerf cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getApplId() {
        return this.applId;
    }

    public Prod2Cerf applId(String applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getAreaCd() {
        return this.areaCd;
    }

    public Prod2Cerf areaCd(String areaCd) {
        this.setAreaCd(areaCd);
        return this;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getCerfTag() {
        return this.cerfTag;
    }

    public Prod2Cerf cerfTag(String cerfTag) {
        this.setCerfTag(cerfTag);
        return this;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public Prod2Cerf stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Prod2Cerf lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Prod2Cerf lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Prod2Cerf)) {
            return false;
        }
        return id != null && id.equals(((Prod2Cerf) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2Cerf{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", applId='" + getApplId() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
