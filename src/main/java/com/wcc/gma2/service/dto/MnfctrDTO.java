package com.wcc.gma2.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.wcc.gma2.domain.Mnfctr} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MnfctrDTO implements Serializable {

    private Long id;

    private String uniNo;

    private String mnfctrNmEn;

    private String mnfctrNmCh;

    private String contact;

    private String eamil;

    private String addr;

    private String tel;

    private String lstMtnUsr;

    private LocalDate lstMtnDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniNo() {
        return uniNo;
    }

    public void setUniNo(String uniNo) {
        this.uniNo = uniNo;
    }

    public String getMnfctrNmEn() {
        return mnfctrNmEn;
    }

    public void setMnfctrNmEn(String mnfctrNmEn) {
        this.mnfctrNmEn = mnfctrNmEn;
    }

    public String getMnfctrNmCh() {
        return mnfctrNmCh;
    }

    public void setMnfctrNmCh(String mnfctrNmCh) {
        this.mnfctrNmCh = mnfctrNmCh;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        if (!(o instanceof MnfctrDTO)) {
            return false;
        }

        MnfctrDTO mnfctrDTO = (MnfctrDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, mnfctrDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MnfctrDTO{" +
            "id=" + getId() +
            ", uniNo='" + getUniNo() + "'" +
            ", mnfctrNmEn='" + getMnfctrNmEn() + "'" +
            ", mnfctrNmCh='" + getMnfctrNmCh() + "'" +
            ", contact='" + getContact() + "'" +
            ", eamil='" + getEamil() + "'" +
            ", addr='" + getAddr() + "'" +
            ", tel='" + getTel() + "'" +
            ", lstMtnUsr='" + getLstMtnUsr() + "'" +
            ", lstMtnDt='" + getLstMtnDt() + "'" +
            "}";
    }
}
