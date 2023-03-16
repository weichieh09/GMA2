package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.FeeDesc} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FeeDescDTO implements Serializable {

    private Long id;

    private String feeCd;

    private String feeDesc;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeeCd() {
        return feeCd;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
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
        if (!(o instanceof FeeDescDTO)) {
            return false;
        }

        FeeDescDTO feeDescDTO = (FeeDescDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, feeDescDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FeeDescDTO{" +
            "id=" + getId() +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDesc='" + getFeeDesc() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
