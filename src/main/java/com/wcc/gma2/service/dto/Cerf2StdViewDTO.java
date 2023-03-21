package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Cerf2StdView} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2StdViewDTO implements Serializable {

    private Long id;

    private String cerfNo;

    private String cerfVer;

    private String stdNo;

    private String stdVer;

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

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return stdVer;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cerf2StdViewDTO)) {
            return false;
        }

        Cerf2StdViewDTO cerf2StdViewDTO = (Cerf2StdViewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cerf2StdViewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2StdViewDTO{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
            "}";
    }
}
