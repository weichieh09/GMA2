package com.wcc.gma2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CerfView.
 */
@Entity
@Table(name = "cerf_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CerfView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "cerf_no")
    private String cerfNo;

    @Column(name = "cerf_ver")
    private String cerfVer;

    @Column(name = "fee_dt")
    private LocalDate feeDt;

    @Lob
    @Column(name = "fee_desc")
    private String feeDesc;

    @Column(name = "fee")
    private Long fee;

    @Lob
    @Column(name = "msg_01")
    private String msg01;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CerfView id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public CerfView cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public CerfView cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public LocalDate getFeeDt() {
        return this.feeDt;
    }

    public CerfView feeDt(LocalDate feeDt) {
        this.setFeeDt(feeDt);
        return this;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public String getFeeDesc() {
        return this.feeDesc;
    }

    public CerfView feeDesc(String feeDesc) {
        this.setFeeDesc(feeDesc);
        return this;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

    public Long getFee() {
        return this.fee;
    }

    public CerfView fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getMsg01() {
        return this.msg01;
    }

    public CerfView msg01(String msg01) {
        this.setMsg01(msg01);
        return this;
    }

    public void setMsg01(String msg01) {
        this.msg01 = msg01;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CerfView)) {
            return false;
        }
        return id != null && id.equals(((CerfView) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CerfView{" +
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
