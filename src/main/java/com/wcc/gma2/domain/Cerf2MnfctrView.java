package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Cerf2MnfctrView.
 */
@Entity
@Table(name = "cerf_2_mnfctr_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2MnfctrView implements Serializable {

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

    @Column(name = "area")
    private String area;

    @Column(name = "sts")
    private String sts;

    @Column(name = "issu_dt")
    private LocalDate issuDt;

    @Column(name = "remain_days")
    private Long remainDays;

    @Column(name = "appl_id")
    private String applId;

    @Column(name = "mnfctr_nm_ch")
    private String mnfctrNmCh;

    @Lob
    @Column(name = "upld_file")
    private byte[] upldFile;

    @Column(name = "upld_file_content_type")
    private String upldFileContentType;

    @Lob
    @Column(name = "image_file")
    private byte[] imageFile;

    @Column(name = "image_file_content_type")
    private String imageFileContentType;

    @Column(name = "lst_mtn_usr")
    private String lstMtnUsr;

    @Column(name = "lst_mtn_dt")
    private LocalDate lstMtnDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cerf2MnfctrView id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public Cerf2MnfctrView cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public Cerf2MnfctrView cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getArea() {
        return this.area;
    }

    public Cerf2MnfctrView area(String area) {
        this.setArea(area);
        return this;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSts() {
        return this.sts;
    }

    public Cerf2MnfctrView sts(String sts) {
        this.setSts(sts);
        return this;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public LocalDate getIssuDt() {
        return this.issuDt;
    }

    public Cerf2MnfctrView issuDt(LocalDate issuDt) {
        this.setIssuDt(issuDt);
        return this;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public Long getRemainDays() {
        return this.remainDays;
    }

    public Cerf2MnfctrView remainDays(Long remainDays) {
        this.setRemainDays(remainDays);
        return this;
    }

    public void setRemainDays(Long remainDays) {
        this.remainDays = remainDays;
    }

    public String getApplId() {
        return this.applId;
    }

    public Cerf2MnfctrView applId(String applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getMnfctrNmCh() {
        return this.mnfctrNmCh;
    }

    public Cerf2MnfctrView mnfctrNmCh(String mnfctrNmCh) {
        this.setMnfctrNmCh(mnfctrNmCh);
        return this;
    }

    public void setMnfctrNmCh(String mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
    }

    public byte[] getUpldFile() {
        return this.upldFile;
    }

    public Cerf2MnfctrView upldFile(byte[] upldFile) {
        this.setUpldFile(upldFile);
        return this;
    }

    public void setUpldFile(byte[] upldFile) {
        this.upldFile = upldFile;
    }

    public String getUpldFileContentType() {
        return this.upldFileContentType;
    }

    public Cerf2MnfctrView upldFileContentType(String upldFileContentType) {
        this.upldFileContentType = upldFileContentType;
        return this;
    }

    public void setUpldFileContentType(String upldFileContentType) {
        this.upldFileContentType = upldFileContentType;
    }

    public byte[] getImageFile() {
        return this.imageFile;
    }

    public Cerf2MnfctrView imageFile(byte[] imageFile) {
        this.setImageFile(imageFile);
        return this;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageFileContentType() {
        return this.imageFileContentType;
    }

    public Cerf2MnfctrView imageFileContentType(String imageFileContentType) {
        this.imageFileContentType = imageFileContentType;
        return this;
    }

    public void setImageFileContentType(String imageFileContentType) {
        this.imageFileContentType = imageFileContentType;
    }

    public String getLstMtnUsr() {
        return this.lstMtnUsr;
    }

    public Cerf2MnfctrView lstMtnUsr(String lstMtnUsr) {
        this.setLstMtnUsr(lstMtnUsr);
        return this;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return this.lstMtnDt;
    }

    public Cerf2MnfctrView lstMtnDt(LocalDate lstMtnDt) {
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
        if (!(o instanceof Cerf2MnfctrView)) {
            return false;
        }
        return id != null && id.equals(((Cerf2MnfctrView) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2MnfctrView{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", area='" + getArea() + "'" +
            ", sts='" + getSts() + "'" +
            ", issuDt='" + getIssuDt() + "'" +
            ", remainDays=" + getRemainDays() +
            ", applId='" + getApplId() + "'" +
            ", mnfctrNmCh='" + getMnfctrNmCh() + "'" +
            ", upldFile='" + getUpldFile() + "'" +
            ", upldFileContentType='" + getUpldFileContentType() + "'" +
            ", imageFile='" + getImageFile() + "'" +
            ", imageFileContentType='" + getImageFileContentType() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
