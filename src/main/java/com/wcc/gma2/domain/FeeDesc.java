package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A FeeDesc.
 */
@Entity
@Table(name = "fee_desc")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FeeDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "fee_cd")
    private String feeCd;

    @Column(name = "fee_desc")
    private String feeDesc;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FeeDesc id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeeCd() {
        return this.feeCd;
    }

    public FeeDesc feeCd(String feeCd) {
        this.setFeeCd(feeCd);
        return this;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public String getFeeDesc() {
        return this.feeDesc;
    }

    public FeeDesc feeDesc(String feeDesc) {
        this.setFeeDesc(feeDesc);
        return this;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public FeeDesc lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public FeeDesc lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof FeeDesc)) {
            return false;
        }
        return id != null && id.equals(((FeeDesc) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FeeDesc{" +
            "id=" + getId() +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDesc='" + getFeeDesc() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
