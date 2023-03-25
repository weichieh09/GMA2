package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Cerf} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    private String cerfNo;

    @Size(max = 20)
    private String cerfVer;

    @Size(max = 10)
    private String status;

    @Lob
    private byte[] pdf;

    private String pdfContentType;
    private Long applId;

    private Long fctyId;

    private Long mnfctrId;

    private LocalDate issuDt;

    private LocalDate expDt;

    private Set<ProdDTO> prods = new HashSet<>();

    private Set<StdDTO> stds = new HashSet<>();

    private CountryDTO country;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getPdfContentType() {
        return pdfContentType;
    }

    public void setPdfContentType(String pdfContentType) {
        this.pdfContentType = pdfContentType;
    }

    public Long getApplId() {
        return applId;
    }

    public void setApplId(Long applId) {
        this.applId = applId;
    }

    public Long getFctyId() {
        return fctyId;
    }

    public void setFctyId(Long fctyId) {
        this.fctyId = fctyId;
    }

    public Long getMnfctrId() {
        return mnfctrId;
    }

    public void setMnfctrId(Long mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public LocalDate getIssuDt() {
        return issuDt;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public LocalDate getExpDt() {
        return expDt;
    }

    public void setExpDt(LocalDate expDt) {
        this.expDt = expDt;
    }

    public Set<ProdDTO> getProds() {
        return prods;
    }

    public void setProds(Set<ProdDTO> prods) {
        this.prods = prods;
    }

    public Set<StdDTO> getStds() {
        return stds;
    }

    public void setStds(Set<StdDTO> stds) {
        this.stds = stds;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CerfDTO)) {
            return false;
        }

        CerfDTO cerfDTO = (CerfDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerfDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", status='" + getStatus() + "'" +
            ", pdf='" + getPdf() + "'" +
            ", applId=" + getApplId() +
            ", fctyId=" + getFctyId() +
            ", mnfctrId=" + getMnfctrId() +
            ", issuDt='" + getIssuDt() + "'" +
            ", expDt='" + getExpDt() + "'" +
            ", prods=" + getProds() +
            ", stds=" + getStds() +
            ", country=" + getCountry() +
            "}";
    }
}
