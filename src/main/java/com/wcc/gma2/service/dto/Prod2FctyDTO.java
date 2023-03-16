package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Prod2Fcty} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod2FctyDTO implements Serializable {

    private Long id;

    private String prodId;

    private String mnfctrId;

    private String fctyId;

    private LocalDate inspectDt;

    private String discontinueFg;

    private String discontinueDesc;

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

    public String getFctyId() {
        return fctyId;
    }

    public void setFctyId(String fctyId) {
        this.fctyId = fctyId;
    }

    public LocalDate getInspectDt() {
        return inspectDt;
    }

    public void setInspectDt(LocalDate inspectDt) {
        this.inspectDt = inspectDt;
    }

    public String getDiscontinueFg() {
        return discontinueFg;
    }

    public void setDiscontinueFg(String discontinueFg) {
        this.discontinueFg = discontinueFg;
    }

    public String getDiscontinueDesc() {
        return discontinueDesc;
    }

    public void setDiscontinueDesc(String discontinueDesc) {
        this.discontinueDesc = discontinueDesc;
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
        if (!(o instanceof Prod2FctyDTO)) {
            return false;
        }

        Prod2FctyDTO prod2FctyDTO = (Prod2FctyDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, prod2FctyDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod2FctyDTO{" +
            "id=" + getId() +
            ", prodId='" + getProdId() + "'" +
            ", mnfctrId='" + getMnfctrId() + "'" +
            ", fctyId='" + getFctyId() + "'" +
            ", inspectDt='" + getInspectDt() + "'" +
            ", discontinueFg='" + getDiscontinueFg() + "'" +
            ", discontinueDesc='" + getDiscontinueDesc() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
