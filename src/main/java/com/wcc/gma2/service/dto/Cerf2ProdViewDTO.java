package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Cerf2ProdView} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2ProdViewDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String prodId;

    private String prodNmCh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return cerfNo;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return cerfVer;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdNmCh() {
        return prodNmCh;
    }

    public void setProdNmCh(String prodNmCh) {
        this.prodNmCh = prodNmCh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cerf2ProdViewDTO)) {
            return false;
        }

        Cerf2ProdViewDTO cerf2ProdViewDTO = (Cerf2ProdViewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerf2ProdViewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2ProdViewDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", prodId='" + getProdId() + "'" +
            ", prodNmCh='" + getProdNmCh() + "'" +
            "}";
    }
}
