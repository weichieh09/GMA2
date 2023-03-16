package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.MnfctrFee} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MnfctrFeeDTO implements Serializable {

    private Long id;

    private String fctyId;

    private String feeCd;

    private LocalDate feeDt;

    private Long fee;

    private String curr;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFctyId() {
        return fctyId;
    }

    public void setFctyId(String fctyId) {
        this.fctyId = fctyId;
    }

    public String getFeeCd() {
        return feeCd;
    }

    public void setFeeCd(String feeCd) {
        this.feeCd = feeCd;
    }

    public LocalDate getFeeDt() {
        return feeDt;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
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
        if (!(o instanceof MnfctrFeeDTO)) {
            return false;
        }

        MnfctrFeeDTO mnfctrFeeDTO = (MnfctrFeeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, mnfctrFeeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MnfctrFeeDTO{" +
            "id=" + getId() +
            ", fctyId='" + getFctyId() + "'" +
            ", feeCd='" + getFeeCd() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            ", fee=" + getFee() +
            ", curr='" + getCurr() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
