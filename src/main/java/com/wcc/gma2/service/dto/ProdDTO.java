package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Prod} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProdDTO implements Serializable {

    private Long id;

    private String prodId;

    private String mnfctrId;

    private String prodNmCh;

    private String prodNmEn;

    private String hsCd;

    private String cccCd;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getMnfctrId() {
        return mnfctrId;
    }

    public void setMnfctrId(String mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public String getProdNmCh() {
        return prodNmCh;
    }

    public void setProdNmCh(String prodNmCh) {
        this.prodNmCh = prodNmCh;
    }

    public String getProdNmEn() {
        return prodNmEn;
    }

    public void setProdNmEn(String prodNmEn) {
        this.prodNmEn = prodNmEn;
    }

    public String getHsCd() {
        return hsCd;
    }

    public void setHsCd(String hsCd) {
        this.hsCd = hsCd;
    }

    public String getCccCd() {
        return cccCd;
    }

    public void setCccCd(String cccCd) {
        this.cccCd = cccCd;
    }

    public String getLstMtnUsr() {
        return lstMtnUsr;
    }

    public void setLstMtnUsr(String lstMtnUsr) {
        this.lstMtnUsr = lstMtnUsr;
    }

    public LocalDate getLstMtnDt() {
        return lstMtnDt;
    }

    public void setLstMtnDt(LocalDate lstMtnDt) {
        this.lstMtnDt = lstMtnDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProdDTO)) {
            return false;
        }

        ProdDTO prodDTO = (ProdDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, prodDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProdDTO{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", prodNmCh='" + getProdNmCh() + "'" +
            ", prodNmEn='" + getProdNmEn() + "'" +
            ", hsCd='" + getHsCd() + "'" +
            ", cccCd='" + getCccCd() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
