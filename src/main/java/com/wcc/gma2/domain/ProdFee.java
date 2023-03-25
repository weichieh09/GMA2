package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ProdFee.
 */
@Entity
@Table(name = "prod_fee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProdFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProdFee")
    @SequenceGenerator(name = "seqProdFee")
    @Column(name = "id")
    private Long id;

    @Column(name = "fee")
    private Long fee;

    @Size(max = 10)
    @Column(name = "fee_type", length = 10)
    private String feeType;

    @ManyToOne
    @JsonIgnoreProperties(value = { "prodFees", "countries", "stds", "marks", "cerfs" }, allowSetters = true)
    private Prod prod;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ProdFee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFee() {
        return this.fee;
    }

    public ProdFee fee(Long fee) {
        this.setFee(fee);
        return this;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return this.feeType;
    }

    public ProdFee feeType(String feeType) {
        this.setFeeType(feeType);
        return this;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Prod getProd() {
        return this.prod;
    }

    public void setProd(Prod prod) {
        this.prod = prod;
    }

    public ProdFee prod(Prod prod) {
        this.setProd(prod);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProdFee)) {
            return false;
        }
        return id != null && id.equals(((ProdFee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProdFee{" +
            "id=" + getId() +
            ", fee=" + getFee() +
            ", feeType='" + getFeeType() + "'" +
            "}";
    }
}
