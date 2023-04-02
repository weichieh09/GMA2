package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CountryStd.
 */
@Entity
@Table(name = "country_std")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CountryStd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Size(max = 100)
    @Column(name = "rel_type", length = 100)
    private String relType;

    @ManyToOne
    @JsonIgnoreProperties(value = { "prodCountries", "countryStds", "countryCerts", "countryMarks" }, allowSetters = true)
    private Country country;

    @ManyToOne
    @JsonIgnoreProperties(value = { "prodStds", "cerfStds", "countryStds" }, allowSetters = true)
    private Std std;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CountryStd id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelType() {
        return this.relType;
    }

    public CountryStd relType(String relType) {
        this.setRelType(relType);
        return this;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryStd country(Country country) {
        this.setCountry(country);
        return this;
    }

    public Std getStd() {
        return this.std;
    }

    public void setStd(Std std) {
        this.std = std;
    }

    public CountryStd std(Std std) {
        this.setStd(std);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CountryStd)) {
            return false;
        }
        return id != null && id.equals(((CountryStd) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryStd{" +
            "id=" + getId() +
            ", relType='" + getRelType() + "'" +
            "}";
    }
}
