package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A MnfctrFee.
 */
@Entity
@Table(name = "mnfctr_fee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MnfctrFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "fcty_id")
    private String fctyId;

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

    public MnfctrFee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFctyId() {
        return this.fctyId;
    }

    public MnfctrFee fctyId(String fctyId) {
        this.setFctyId(fctyId);
        return this;
    }

    public void setFctyId(String fctyId) {
        this.fctyId = fctyId;
    }

    public String getFeeCd() {
        return this.feeCd;
    }

    public MnfctrFee feeCd(String feeCd) {
        this.setFeeCd(feeCd);
        return this;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public LocalDate getFeeDt() {
        return this.feeDt;
    }

    public MnfctrFee feeDt(LocalDate feeDt) {
        this.setFeeDt(feeDt);
        return this;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public Long getFee() {
        return this.fee;
    }

    public MnfctrFee fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getCurr() {
        return this.curr;
    }

    public MnfctrFee curr(String curr) {
        this.setCurr(curr);
        return this;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public MnfctrFee lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public MnfctrFee lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof MnfctrFee)) {
            return false;
        }
        return id != null && id.equals(((MnfctrFee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MnfctrFee{" +
            "id=" + getId() +
            ", fctyId='" + getFctyId() + "'" +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            ", fee=" + getFee() +
            ", curr='" + getCurr() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
