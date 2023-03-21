package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.wcc.gma2.domain.CerfView} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfViewDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private LocalDate feeDt;

    @Lob
    private String feeDesc;

    private Long fee;

    @Lob
    private String msg01;

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

    public LocalDate getFeeDt() {
        return feeDt;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getMsg01() {
        return msg01;
    }

    public void setMsg01(String msg01) {
        this.msg01 = msg01;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CerfViewDTO)) {
            return false;
        }

        CerfViewDTO cerfViewDTO = (CerfViewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerfViewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfViewDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            ", feeDesc='" + getFeeDesc() + "'" +
            ", fee=" + getFee() +
            ", msg01='" + getMsg01() + "'" +
            "}";
    }
}
