package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Std.
 */
@Entity
@Table(name = "std")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Std implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStd")
    @SequenceGenerator(name = "seqStd")
    @Column(name = "id")
    private Long id;

    @Size(max = 20)
    @Column(name = "std_no", length = 20)
    private String stdNo;

    @Size(max = 20)
    @Column(name = "std_ver", length = 20)
    private String stdVer;

    @Size(max = 100)
    @Column(name = "en_name", length = 100)
    private String enName;

    @Size(max = 100)
    @Column(name = "ch_name", length = 100)
    private String chName;

    @Size(max = 10)
    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "issu_dt")
    private LocalDate issuDt;

    @Column(name = "exp_dt")
    private LocalDate expDt;

    @ManyToMany(mappedBy = "stds")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "fees", "stickers", "countries", "stds", "cerfs" }, allowSetters = true)
    private Set<Prod> prods = new HashSet<>();

    @ManyToMany(mappedBy = "stds")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "cerfCompanies", "fees", "prods", "stds", "marks", "country" }, allowSetters = true)
    private Set<Cerf> cerfs = new HashSet<>();

    @ManyToMany(mappedBy = "stds")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "cerfs", "marks", "stds", "prods" }, allowSetters = true)
    private Set<Country> countries = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Std id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStdNo() {
        return this.stdNo;
    }

    public Std stdNo(String stdNo) {
        this.setStdNo(stdNo);
        return this;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdVer() {
        return this.stdVer;
    }

    public Std stdVer(String stdVer) {
        this.setStdVer(stdVer);
        return this;
    }

    public void setStdVer(String stdVer) {
        this.stdVer = stdVer;
    }

    public String getEnName() {
        return this.enName;
    }

    public Std enName(String enName) {
        this.setEnName(enName);
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getChName() {
        return this.chName;
    }

    public Std chName(String chName) {
        this.setChName(chName);
        return this;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getStatus() {
        return this.status;
    }

    public Std status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getIssuDt() {
        return this.issuDt;
    }

    public Std issuDt(LocalDate issuDt) {
        this.setIssuDt(issuDt);
        return this;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public LocalDate getExpDt() {
        return this.expDt;
    }

    public Std expDt(LocalDate expDt) {
        this.setExpDt(expDt);
        return this;
    }

    public void setExpDt(LocalDate expDt) {
        this.expDt = expDt;
    }

    public Set<Prod> getProds() {
        return this.prods;
    }

    public void setProds(Set<Prod> prods) {
        if (this.prods != null) {
            this.prods.forEach(i -> i.removeStd(this));
        }
        if (prods != null) {
            prods.forEach(i -> i.addStd(this));
        }
        this.prods = prods;
    }

    public Std prods(Set<Prod> prods) {
        this.setProds(prods);
        return this;
    }

    public Std addProd(Prod prod) {
        this.prods.add(prod);
        prod.getStds().add(this);
        return this;
    }

    public Std removeProd(Prod prod) {
        this.prods.remove(prod);
        prod.getStds().remove(this);
        return this;
    }

    public Set<Cerf> getCerfs() {
        return this.cerfs;
    }

    public void setCerfs(Set<Cerf> cerfs) {
        if (this.cerfs != null) {
            this.cerfs.forEach(i -> i.removeStd(this));
        }
        if (cerfs != null) {
            cerfs.forEach(i -> i.addStd(this));
        }
        this.cerfs = cerfs;
    }

    public Std cerfs(Set<Cerf> cerfs) {
        this.setCerfs(cerfs);
        return this;
    }

    public Std addCerf(Cerf cerf) {
        this.cerfs.add(cerf);
        cerf.getStds().add(this);
        return this;
    }

    public Std removeCerf(Cerf cerf) {
        this.cerfs.remove(cerf);
        cerf.getStds().remove(this);
        return this;
    }

    public Set<Country> getCountries() {
        return this.countries;
    }

    public void setCountries(Set<Country> countries) {
        if (this.countries != null) {
            this.countries.forEach(i -> i.removeStd(this));
        }
        if (countries != null) {
            countries.forEach(i -> i.addStd(this));
        }
        this.countries = countries;
    }

    public Std countries(Set<Country> countries) {
        this.setCountries(countries);
        return this;
    }

    public Std addCountry(Country country) {
        this.countries.add(country);
        country.getStds().add(this);
        return this;
    }

    public Std removeCountry(Country country) {
        this.countries.remove(country);
        country.getStds().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Std)) {
            return false;
        }
        return id != null && id.equals(((Std) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Std{" +
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
