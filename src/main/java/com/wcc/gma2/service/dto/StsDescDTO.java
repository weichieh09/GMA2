package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.StsDesc} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StsDescDTO implements Serializable {

    private Long id;

    private String stsCd;

    private String stsDesc;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getStsDesc() {
        return stsDesc;
    }

    public void setStsDesc(String stsDesc) {
        this.stsDesc = stsDesc;
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
        if (!(o instanceof StsDescDTO)) {
            return false;
        }

        StsDescDTO stsDescDTO = (StsDescDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, stsDescDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StsDescDTO{" +
            "id=" + getId() +
            ", stsCd='" + getStsCd() + "'" +
            ", stsDesc='" + getStsDesc() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
