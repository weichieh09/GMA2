package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Cerf.
 */
@Entity
@Table(name = "cerf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCerf")
    @SequenceGenerator(name = "sequenceCerf")
    @Column(name = "id")
    private Long id;

    @Column(name = "cerf_no")
    private String cerfNo;

    @Column(name = "cerf_ver")
    private String cerfVer;

    @Column(name = "area_cd")
    private String areaCd;

    @Column(name = "sts_cd")
    private String stsCd;

    @Column(name = "appl_id")
    private String applId;

    @Column(name = "cerf_tag")
    private String cerfTag;

    @Column(name = "issu_dt")
    private LocalDate issuDt;

    @Column(name = "cerf_exp_dt")
    private LocalDate cerfExpDt;

    @Column(name = "remain_days")
    private Long remainDays;

    @Lob
    @Column(name = "upld_file")
    private byte[] upldFile;

    @Column(name = "upld_file_content_type")
    private String upldFileContentType;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cerf id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public Cerf cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public Cerf cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getAreaCd() {
        return this.areaCd;
    }

    public Cerf areaCd(String areaCd) {
        this.setAreaCd(areaCd);
        return this;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public Cerf stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getApplId() {
        return this.applId;
    }

    public Cerf applId(String applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getCerfTag() {
        return this.cerfTag;
    }

    public Cerf cerfTag(String cerfTag) {
        this.setCerfTag(cerfTag);
        return this;
    }

    public void setCerfTag(String cerfTag) {
        this.cerfTag = cerfTag;
    }

    public LocalDate getIssuDt() {
        return this.issuDt;
    }

    public Cerf issuDt(LocalDate issuDt) {
        this.setIssuDt(issuDt);
        return this;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public LocalDate getCerfExpDt() {
        return this.cerfExpDt;
    }

    public Cerf cerfExpDt(LocalDate cerfExpDt) {
        this.setCerfExpDt(cerfExpDt);
        return this;
    }

    public void setCerfExpDt(LocalDate cerfExpDt) {
        this.cerfExpDt = cerfExpDt;
    }

    public Long getRemainDays() {
        return this.remainDays;
    }

    public Cerf remainDays(Long remainDays) {
        this.setRemainDays(remainDays);
        return this;
    }

    public void setRemainDays(Long remainDays) {
        this.remainDays = remainDays;
    }

    public byte[] getUpldFile() {
        return this.upldFile;
    }

    public Cerf upldFile(byte[] upldFile) {
        this.setUpldFile(upldFile);
        return this;
    }

    public void setUpldFile(byte[] upldFile) {
        this.upldFile = upldFile;
    }

    public String getUpldFileContentType() {
        return this.upldFileContentType;
    }

    public Cerf upldFileContentType(String upldFileContentType) {
        this.upldFileContentType = upldFileContentType;
        return this;
    }

    public void setUpldFileContentType(String upldFileContentType) {
        this.upldFileContentType = upldFileContentType;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Cerf lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Cerf lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Cerf)) {
            return false;
        }
        return id != null && id.equals(((Cerf) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", areaCd='" + getAreaCd() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", applId='" + getApplId() + "'" +
            ", cerfTag='" + getCerfTag() + "'" +
            ", issuDt='" + getIssuDt() + "'" +
            ", cerfExpDt='" + getCerfExpDt() + "'" +
            ", remainDays=" + getRemainDays() +
            ", upldFile='" + getUpldFile() + "'" +
            ", upldFileContentType='" + getUpldFileContentType() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
