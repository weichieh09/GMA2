package com.wcc.gma2.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CerfSearchView.
 */
@Entity
@Table(name = "cerf_search_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfSearchView implements Serializable {

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

    @Column(name = "fee_cd")
    private String feeCd;

    @Lob
    @Column(name = "fee_desc")
    private String feeDesc;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "area_cd")
    private String areaCd;

    @Lob
    @Column(name = "area_desc")
    private String areaDesc;

    @Column(name = "sts_cd")
    private String stsCd;

    @Lob
    @Column(name = "sts_desc")
    private String stsDesc;

    @Column(name = "appl_id")
    private String applId;

    @Column(name = "mnfctr_nm_ch")
    private String mnfctrNmCh;

    @Column(name = "prod_id")
    private String prodId;

    @Column(name = "mnfctr_id")
    private String mnfctrId;

    @Column(name = "fcty_id")
    private String fctyId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CerfSearchView id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public CerfSearchView cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public CerfSearchView cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getFeeCd() {
        return this.feeCd;
    }

    public CerfSearchView feeCd(String feeCd) {
        this.setFeeCd(feeCd);
        return this;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public String getFeeDesc() {
        return this.feeDesc;
    }

    public CerfSearchView feeDesc(String feeDesc) {
        this.setFeeDesc(feeDesc);
        return this;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

    public Long getFee() {
        return this.fee;
    }

    public CerfSearchView fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getAreaCd() {
        return this.areaCd;
    }

    public CerfSearchView areaCd(String areaCd) {
        this.setAreaCd(areaCd);
        return this;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public String getAreaDesc() {
        return this.areaDesc;
    }

    public CerfSearchView areaDesc(String areaDesc) {
        this.setAreaDesc(areaDesc);
        return this;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }

    public String getStsCd() {
        return this.stsCd;
    }

    public CerfSearchView stsCd(String stsCd) {
        this.setStsCd(stsCd);
        return this;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getStsDesc() {
        return this.stsDesc;
    }

    public CerfSearchView stsDesc(String stsDesc) {
        this.setStsDesc(stsDesc);
        return this;
    }

    public void setStsDesc(String stsDesc) {
        this.stsDesc = stsDesc;
    }

    public String getApplId() {
        return this.applId;
    }

    public CerfSearchView applId(String applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(String applId) {
        this.applId = applId;
    }

    public String getMnfctrNmCh() {
        return this.mnfctrNmCh;
    }

    public CerfSearchView mnfctrNmCh(String mnfctrNmCh) {
        this.setMnfctrNmCh(mnfctrNmCh);
        return this;
    }

    public void setMnfctrNmCh(String mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
    }

    public String getProdId() {
        return this.prodId;
    }

    public CerfSearchView prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return this.mnfctrId;
    }

    public CerfSearchView mnfctrId(String mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getFctyId() {
        return this.fctyId;
    }

    public CerfSearchView fctyId(String fctyId) {
        this.setFctyId(fctyId);
        return this;
    }

    public void setFctyId(String fctyId) {
        this.fctyId = fctyId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CerfSearchView)) {
            return false;
        }
        return id != null && id.equals(((CerfSearchView) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfSearchView{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDesc='" + getFeeDesc() + "'" +
            ", fee=" + getFee() +
            ", areaCd='" + getAreaCd() + "'" +
            ", areaDesc='" + getAreaDesc() + "'" +
            ", stsCd='" + getStsCd() + "'" +
            ", stsDesc='" + getStsDesc() + "'" +
            ", applId='" + getApplId() + "'" +
            ", mnfctrNmCh='" + getMnfctrNmCh() + "'" +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", fctyId='" + getFctyId() + "'" +
            "}";
    }
}
