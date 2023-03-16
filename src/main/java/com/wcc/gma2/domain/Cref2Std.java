package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Cref2Std.
 */
@Entity
@Table(name = "cref_2_std")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cref2Std implements Serializable {

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

    @Column(name = "area_cd")
    private String areaCd;

    @Column(name = "appl_id")
    private String applId;

    @Column(name = "cerf_tag")
    private String cerfTag;

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

    public Cref2Std id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public Cref2Std cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public Cref2Std cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getAreaCd() {
        return this.areaCd;
    }

    public Cref2Std areaCd(String areaCd) {
        this.setAreaCd(areaCd);
        return this;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getApplId() {
        return this.applId;
    }

    public Cref2Std applId(String applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getCerfTag() {
        return this.cerfTag;
    }

    public Cref2Std cerfTag(String cerfTag) {
        this.setCerfTag(cerfTag);
        return this;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public String getStdNo() {
        return this.stdNo;
    }

    public Cref2Std stdNo(String stdNo) {
        this.setStdNo(stdNo);
        return this;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return this.stdVer;
    }

    public Cref2Std stdVer(String stdVer) {
        this.setStdVer(stdVer);
        return this;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public Cref2Std stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Cref2Std lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Cref2Std lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Cref2Std)) {
            return false;
        }
        return id != null && id.equals(((Cref2Std) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cref2Std{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", applId='" + getApplId() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
