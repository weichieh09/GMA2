package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CerfFee.
 */
@Entity
@Table(name = "cerf_fee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "cerf_no")
    private String cerfNo;

    @Column(name = "cerf_ver")
    private String cerfVer;

    @Column(name = "cerf_tag")
    private String cerfTag;

    @Column(name = "area_cd")
    private String areaCd;

    @Column(name = "appl_id")
    private String applId;

    @Column(name = "sts_cd")
    private String stsCd;

    @Column(name = "fee_cd")
    private String feeCd;

    @Column(name = "fee_dt")
    private LocalDate feeDt;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "curr")
    private String curr;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CerfFee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public CerfFee cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public CerfFee cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getCerfTag() {
        return this.cerfTag;
    }

    public CerfFee cerfTag(String cerfTag) {
        this.setCerfTag(cerfTag);
        return this;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public String getAreaCd() {
        return this.areaCd;
    }

    public CerfFee areaCd(String areaCd) {
        this.setAreaCd(areaCd);
        return this;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getApplId() {
        return this.applId;
    }

    public CerfFee applId(String applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public CerfFee stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getFeeCd() {
        return this.feeCd;
    }

    public CerfFee feeCd(String feeCd) {
        this.setFeeCd(feeCd);
        return this;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public LocalDate getFeeDt() {
        return this.feeDt;
    }

    public CerfFee feeDt(LocalDate feeDt) {
        this.setFeeDt(feeDt);
        return this;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public Long getFee() {
        return this.fee;
    }

    public CerfFee fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getCurr() {
        return this.curr;
    }

    public CerfFee curr(String curr) {
        this.setCurr(curr);
        return this;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public CerfFee lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public CerfFee lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof CerfFee)) {
            return false;
        }
        return id != null && id.equals(((CerfFee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfFee{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", applId='" + getApplId() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            ", fee=" + getFee() +
            ", curr='" + getCurr() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
