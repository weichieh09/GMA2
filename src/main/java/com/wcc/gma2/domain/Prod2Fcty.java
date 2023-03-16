package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Prod2Fcty.
 */
@Entity
@Table(name = "prod_2_fcty")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2Fcty implements Serializable {

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

    @Column(name = "fcty_id")
    private String fctyId;

    @Column(name = "inspect_dt")
    private LocalDate inspectDt;

    @Column(name = "discontinue_fg")
    private String discontinueFg;

    @Lob
    @Column(name = "discontinue_desc")
    private String discontinueDesc;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Prod2Fcty id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdId() {
        return this.prodId;
    }

    public Prod2Fcty prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return this.mnfctrId;
    }

    public Prod2Fcty mnfctrId(String mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getFctyId() {
        return this.fctyId;
    }

    public Prod2Fcty fctyId(String fctyId) {
        this.setFctyId(fctyId);
        return this;
    }

    public void setFctyId(String fctyId) {
        this.fctyId = fctyId;
    }

    public LocalDate getInspectDt() {
        return this.inspectDt;
    }

    public Prod2Fcty inspectDt(LocalDate inspectDt) {
        this.setInspectDt(inspectDt);
        return this;
    }

    public void setInspectDt(LocalDate inspectDt) {
        this.inspectDt = inspectDt;
    }

    public String getDiscontinueFg() {
        return this.discontinueFg;
    }

    public Prod2Fcty discontinueFg(String discontinueFg) {
        this.setDiscontinueFg(discontinueFg);
        return this;
    }

    public void setDiscontinueFg(String discontinueFg) {
        this.discontinueFg = discontinueFg;
    }

    public String getDiscontinueDesc() {
        return this.discontinueDesc;
    }

    public Prod2Fcty discontinueDesc(String discontinueDesc) {
        this.setDiscontinueDesc(discontinueDesc);
        return this;
    }

    public void setDiscontinueDesc(String discontinueDesc) {
        this.discontinueDesc = discontinueDesc;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Prod2Fcty lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Prod2Fcty lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Prod2Fcty)) {
            return false;
        }
        return id != null && id.equals(((Prod2Fcty) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2Fcty{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", fctyId='" + getFctyId() + "'" +
            ", inspectDt='" + getInspectDt() + "'" +
            ", discontinueFg='" + getDiscontinueFg() + "'" +
            ", discontinueDesc='" + getDiscontinueDesc() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
