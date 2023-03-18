package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A StsDesc.
 */
@Entity
@Table(name = "sts_desc")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StsDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceStsDesc")
    @SequenceGenerator(name = "sequenceStsDesc")
    @Column(name = "id")
    private Long id;

    @Column(name = "sts_cd")
    private String stsCd;

    @Lob
    @Column(name = "sts_desc")
    private String stsDesc;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public StsDesc id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public StsDesc stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getStsDesc() {
        return this.stsDesc;
    }

    public StsDesc stsDesc(String stsDesc) {
        this.setStsDesc(stsDesc);
        return this;
    }

    public void setStsDesc(String stsDesc) {
        this.stsDesc = stsDesc;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public StsDesc lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public StsDesc lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof StsDesc)) {
            return false;
        }
        return id != null && id.equals(((StsDesc) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StsDesc{" +
            "id=" + getId() +
            ", stsCd='" + getStsCd() + "'" +
            ", stsDesc='" + getStsDesc() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
