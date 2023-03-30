package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Std} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StdDTO implements Serializable {

    private Long id;

    @Size(max = 20)
    private String stdNo;

    @Size(max = 20)
    private String stdVer;

    @Size(max = 100)
    private String enName;

    @Size(max = 100)
    private String chName;

    @Size(max = 10)
    private String status;

    private LocalDate issuDt;

    private LocalDate expDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StdDTO)) {
            return false;
        }

        StdDTO stdDTO = (StdDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, stdDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StdDTO{" +
            "id=" + getId() +
            ", stdNo='" + getStdNo() + "'" +
            ", stdVer='" + getStdVer() + "'" +
            ", enName='" + getEnName() + "'" +
            ", chName='" + getChName() + "'" +
            ", status='" + getStatus() + "'" +
            ", issuDt='" + getIssuDt() + "'" +
            ", expDt='" + getExpDt() + "'" +
            "}";
    }
}
