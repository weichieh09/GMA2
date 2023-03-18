package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Std.
 */
@Entity
@Table(name = "std")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Std implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceStd")
    @SequenceGenerator(name = "sequenceStd")
    @Column(name = "id")
    private Long id;

    @Column(name = "std_no")
    private String stdNo;

    @Column(name = "std_ver")
    private String stdVer;

    @Column(name = "sts_cd")
    private String stsCd;

    @Column(name = "std_cd")
    private String stdCd;

    @Column(name = "std_nm")
    private String stdNm;

    @Column(name = "std_exp_dt")
    private LocalDate stdExpDt;

    @Column(name = "remain_days")
    private Long remainDays;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Std id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStdNo() {
        return this.stdNo;
    }

    public Std stdNo(String stdNo) {
        this.setStdNo(stdNo);
        return this;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return this.stdVer;
    }

    public Std stdVer(String stdVer) {
        this.setStdVer(stdVer);
        return this;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public Std stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getStdCd() {
        return this.stdCd;
    }

    public Std stdCd(String stdCd) {
        this.setStdCd(stdCd);
        return this;
    }

    public void setStdCd(String stdCd) {
        this.stdCd = stdCd;
    }

    public String getStdNm() {
        return this.stdNm;
    }

    public Std stdNm(String stdNm) {
        this.setStdNm(stdNm);
        return this;
    }

    public void setStdNm(String stdNm) {
        this.stdNm = stdNm;
    }

    public LocalDate getStdExpDt() {
        return this.stdExpDt;
    }

    public Std stdExpDt(LocalDate stdExpDt) {
        this.setStdExpDt(stdExpDt);
        return this;
    }

    public void setStdExpDt(LocalDate stdExpDt) {
        this.stdExpDt = stdExpDt;
    }

    public Long getRemainDays() {
        return this.remainDays;
    }

    public Std remainDays(Long remainDays) {
        this.setRemainDays(remainDays);
        return this;
    }

    public void setRemainDays(Long remainDays) {
        this.remainDays = remainDays;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Std lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Std lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Std)) {
            return false;
        }
        return id != null && id.equals(((Std) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Std{" +
            "id=" + getId() +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", stdCd='" + getStdCd() + "'" +
            ", stdNm='" + getStdNm() + "'" +
            ", stdExpDt='" + getStdExpDt() + "'" +
            ", remainDays=" + getRemainDays() +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
