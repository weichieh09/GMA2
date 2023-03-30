package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Prod} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProdDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    private String prodNo;

    @Size(max = 100)
    private String enName;

    @Size(max = 100)
    private String chName;

    @Size(max = 20)
    private String hsCode;

    @Size(max = 20)
    private String cccCode;

    private Set<CountryDTO> countries = new HashSet<>();

    private Set<StdDTO> stds = new HashSet<>();

    private StickerDTO sticker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getCccCode() {
        return cccCode;
    }

    public void setCccCode(String cccCode) {
        this.cccCode = cccCode;
    }

    public Set<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(Set<CountryDTO> countries) {
        this.countries = countries;
    }

    public Set<StdDTO> getStds() {
        return stds;
    }

    public void setStds(Set<StdDTO> stds) {
        this.stds = stds;
    }

    public StickerDTO getSticker() {
        return sticker;
    }

    public void setSticker(StickerDTO sticker) {
        this.sticker = sticker;
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
            ", prodNo='" + getProdNo() + "'" +
            ", enName='" + getEnName() + "'" +
            ", chName='" + getChName() + "'" +
            ", hsCode='" + getHsCode() + "'" +
            ", cccCode='" + getCccCode() + "'" +
            ", countries=" + getCountries() +
            ", stds=" + getStds() +
            ", sticker=" + getSticker() +
            "}";
    }
}
