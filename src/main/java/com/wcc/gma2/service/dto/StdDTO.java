package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Std} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StdDTO implements Serializable {

    private Long id;

    private String stdNo;

    private String stdVer;

    private String stsCd;

    private String stdCd;

    private String stdNm;

    private LocalDate stdExpDt;

    private Long remainDays;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

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

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public String getStdCd() {
        return stdCd;
    }

    public void setStdCd(String stdCd) {
        this.stdCd = stdCd;
    }

    public String getStdNm() {
        return stdNm;
    }

    public void setStdNm(String stdNm) {
        this.stdNm = stdNm;
    }

    public LocalDate getStdExpDt() {
        return stdExpDt;
    }

    public void setStdExpDt(LocalDate stdExpDt) {
        this.stdExpDt = stdExpDt;
    }

    public Long getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(Long remainDays) {
        this.remainDays = remainDays;
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
            ", stsCd='" + getStsCd() + "'" +
            ", stdCd='" + getStdCd() + "'" +
            ", stdNm='" + getStdNm() + "'" +
            ", stdExpDt='" + getStdExpDt() + "'" +
            ", remainDays=" + getRemainDays() +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
