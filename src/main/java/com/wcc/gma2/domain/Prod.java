package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Prod.
 */
@Entity
@Table(name = "prod")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "prod_no")
    private String prodNo;

    @Column(name = "name")
    private String name;

    @Column(name = "hs_code")
    private String hsCode;

    @Column(name = "ccc_code")
    private String cccCode;

    @ManyToMany
    @JoinTable(
        name = "rel_prod__country",
        joinColumns = @JoinColumn(name = "prod_id"),
        inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "cerfs", "marks", "stds", "prods" }, allowSetters = true)
    private Set<Country> countries = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "rel_prod__std", joinColumns = @JoinColumn(name = "prod_id"), inverseJoinColumns = @JoinColumn(name = "std_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prods", "cerfs", "countries" }, allowSetters = true)
    private Set<Std> stds = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "rel_prod__mark", joinColumns = @JoinColumn(name = "prod_id"), inverseJoinColumns = @JoinColumn(name = "mark_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "country", "prods" }, allowSetters = true)
    private Set<Mark> marks = new HashSet<>();

    @ManyToMany(mappedBy = "prods")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prods", "stds", "country" }, allowSetters = true)
    private Set<Cerf> cerfs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Prod id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdNo() {
        return this.prodNo;
    }

    public Prod prodNo(String prodNo) {
        this.setProdNo(prodNo);
        return this;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getName() {
        return this.name;
    }

    public Prod name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHsCode() {
        return this.hsCode;
    }

    public Prod hsCode(String hsCode) {
        this.setHsCode(hsCode);
        return this;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getCccCode() {
        return this.cccCode;
    }

    public Prod cccCode(String cccCode) {
        this.setCccCode(cccCode);
        return this;
    }

    public void setCccCode(String cccCode) {
        this.cccCode = cccCode;
    }

    public Set<Country> getCountries() {
        return this.countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Prod countries(Set<Country> countries) {
        this.setCountries(countries);
        return this;
    }

    public Prod addCountry(Country country) {
        this.countries.add(country);
        country.getProds().add(this);
        return this;
    }

    public Prod removeCountry(Country country) {
        this.countries.remove(country);
        country.getProds().remove(this);
        return this;
    }

    public Set<Std> getStds() {
        return this.stds;
    }

    public void setStds(Set<Std> stds) {
        this.stds = stds;
    }

    public Prod stds(Set<Std> stds) {
        this.setStds(stds);
        return this;
    }

    public Prod addStd(Std std) {
        this.stds.add(std);
        std.getProds().add(this);
        return this;
    }

    public Prod removeStd(Std std) {
        this.stds.remove(std);
        std.getProds().remove(this);
        return this;
    }

    public Set<Mark> getMarks() {
        return this.marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Prod marks(Set<Mark> marks) {
        this.setMarks(marks);
        return this;
    }

    public Prod addMark(Mark mark) {
        this.marks.add(mark);
        mark.getProds().add(this);
        return this;
    }

    public Prod removeMark(Mark mark) {
        this.marks.remove(mark);
        mark.getProds().remove(this);
        return this;
    }

    public Set<Cerf> getCerfs() {
        return this.cerfs;
    }

    public void setCerfs(Set<Cerf> cerfs) {
        if (this.cerfs != null) {
            this.cerfs.forEach(i -> i.removeProd(this));
        }
        if (cerfs != null) {
            cerfs.forEach(i -> i.addProd(this));
        }
        this.cerfs = cerfs;
    }

    public Prod cerfs(Set<Cerf> cerfs) {
        this.setCerfs(cerfs);
        return this;
    }

    public Prod addCerf(Cerf cerf) {
        this.cerfs.add(cerf);
        cerf.getProds().add(this);
        return this;
    }

    public Prod removeCerf(Cerf cerf) {
        this.cerfs.remove(cerf);
        cerf.getProds().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prod)) {
            return false;
        }
        return id != null && id.equals(((Prod) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prod{" +
            "id=" + getId() +
            ", prodNo='" + getProdNo() + "'" +
            ", name='" + getName() + "'" +
            ", hsCode='" + getHsCode() + "'" +
            ", cccCode='" + getCccCode() + "'" +
            "}";
    }
}
