package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Fee} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FeeDTO implements Serializable {

    private Long id;

    private Long fee;

    @Size(max = 10)
    private String feeType;

    private LocalDate feeDt;

    private ProdDTO prod;

    private CerfDTO cerf;

    private CompanyDTO company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public LocalDate getFeeDt() {
        return feeDt;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public ProdDTO getProd() {
        return prod;
    }

    public void setProd(ProdDTO prod) {
        this.prod = prod;
    }

    public CerfDTO getCerf() {
        return cerf;
    }

    public void setCerf(CerfDTO cerf) {
        this.cerf = cerf;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FeeDTO)) {
            return false;
        }

        FeeDTO feeDTO = (FeeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, feeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FeeDTO{" +
            "id=" + getId() +
            ", fee=" + getFee() +
            ", feeType='" + getFeeType() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            ", prod=" + getProd() +
            ", cerf=" + getCerf() +
            ", company=" + getCompany() +
            "}";
    }
}
