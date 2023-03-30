package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Fee.
 */
@Entity
@Table(name = "fee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFee")
    @SequenceGenerator(name = "seqFee")
    @Column(name = "id")
    private Long id;

    @Column(name = "fee")
    private Long fee;

    @Size(max = 10)
    @Column(name = "fee_type", length = 10)
    private String feeType;

    @Column(name = "fee_dt")
    private LocalDate feeDt;

    @ManyToOne
    @JsonIgnoreProperties(value = { "fees", "stickers", "countries", "stds", "cerfs" }, allowSetters = true)
    private Prod prod;

    @ManyToOne
    @JsonIgnoreProperties(value = { "cerfCompanies", "fees", "prods", "stds", "marks", "country" }, allowSetters = true)
    private Cerf cerf;

    @ManyToOne
    @JsonIgnoreProperties(value = { "cerfCompanies", "fees" }, allowSetters = true)
    private Company company;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Fee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFee() {
        return this.fee;
    }

    public Fee fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return this.feeType;
    }

    public Fee feeType(String feeType) {
        this.setFeeType(feeType);
        return this;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public LocalDate getFeeDt() {
        return this.feeDt;
    }

    public Fee feeDt(LocalDate feeDt) {
        this.setFeeDt(feeDt);
        return this;
    }

    public void setFeeDt(LocalDate feeDt) {
        this.feeDt = feeDt;
    }

    public Prod getProd() {
        return this.prod;
    }

    public void setProd(Prod prod) {
        this.prod = prod;
    }

    public Fee prod(Prod prod) {
        this.setProd(prod);
        return this;
    }

    public Cerf getCerf() {
        return this.cerf;
    }

    public void setCerf(Cerf cerf) {
        this.cerf = cerf;
    }

    public Fee cerf(Cerf cerf) {
        this.setCerf(cerf);
        return this;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Fee company(Company company) {
        this.setCompany(company);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fee)) {
            return false;
        }
        return id != null && id.equals(((Fee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Fee{" +
            "id=" + getId() +
            ", fee=" + getFee() +
            ", feeType='" + getFeeType() + "'" +
            ", feeDt='" + getFeeDt() + "'" +
            "}";
    }
}
