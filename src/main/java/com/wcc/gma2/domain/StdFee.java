package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A StdFee.
 */
@Entity
@Table(name = "std_fee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StdFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceStdFee")
    @SequenceGenerator(name = "sequenceStdFee")
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

    public StdFee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdId() {
        return this.prodId;
    }

    public StdFee prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return this.mnfctrId;
    }

    public StdFee mnfctrId(String mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getStdNo() {
        return this.stdNo;
    }

    public StdFee stdNo(String stdNo) {
        this.setStdNo(stdNo);
        return this;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return this.stdVer;
    }

    public StdFee stdVer(String stdVer) {
        this.setStdVer(stdVer);
        return this;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public StdFee stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getFeeCd() {
        return this.feeCd;
    }

    public StdFee feeCd(String feeCd) {
        this.setFeeCd(feeCd);
        return this;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public LocalDate getFeeDt() {
        return this.feeDt;
    }

    public StdFee feeDt(LocalDate feeDt) {
        this.setFeeDt(feeDt);
        return this;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public Long getFee() {
        return this.fee;
    }

    public StdFee fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getCurr() {
        return this.curr;
    }

    public StdFee curr(String curr) {
        this.setCurr(curr);
        return this;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public StdFee lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public StdFee lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof StdFee)) {
            return false;
        }
        return id != null && id.equals(((StdFee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StdFee{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
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
