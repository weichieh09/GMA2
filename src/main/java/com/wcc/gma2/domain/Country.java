package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Country.
 */
@Entity
@Table(name = "country")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prods", "stds", "country" }, allowSetters = true)
    private Set<Cerf> cerfs = new HashSet<>();

    @OneToMany(mappedBy = "country")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "country", "prods" }, allowSetters = true)
    private Set<Mark> marks = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "rel_country__std", joinColumns = @JoinColumn(name = "country_id"), inverseJoinColumns = @JoinColumn(name = "std_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prods", "cerfs", "countries" }, allowSetters = true)
    private Set<Std> stds = new HashSet<>();

    @ManyToMany(mappedBy = "countries")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "countries", "stds", "marks", "cerfs" }, allowSetters = true)
    private Set<Prod> prods = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Country id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Country name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cerf> getCerfs() {
        return this.cerfs;
    }

    public void setCerfs(Set<Cerf> cerfs) {
        if (this.cerfs != null) {
            this.cerfs.forEach(i -> i.setCountry(null));
        }
        if (cerfs != null) {
            cerfs.forEach(i -> i.setCountry(this));
        }
        this.cerfs = cerfs;
    }

    public Country cerfs(Set<Cerf> cerfs) {
        this.setCerfs(cerfs);
        return this;
    }

    public Country addCerf(Cerf cerf) {
        this.cerfs.add(cerf);
        cerf.setCountry(this);
        return this;
    }

    public Country removeCerf(Cerf cerf) {
        this.cerfs.remove(cerf);
        cerf.setCountry(null);
        return this;
    }

    public Set<Mark> getMarks() {
        return this.marks;
    }

    public void setMarks(Set<Mark> marks) {
        if (this.marks != null) {
            this.marks.forEach(i -> i.setCountry(null));
        }
        if (marks != null) {
            marks.forEach(i -> i.setCountry(this));
        }
        this.marks = marks;
    }

    public Country marks(Set<Mark> marks) {
        this.setMarks(marks);
        return this;
    }

    public Country addMark(Mark mark) {
        this.marks.add(mark);
        mark.setCountry(this);
        return this;
    }

    public Country removeMark(Mark mark) {
        this.marks.remove(mark);
        mark.setCountry(null);
        return this;
    }

    public Set<Std> getStds() {
        return this.stds;
    }

    public void setStds(Set<Std> stds) {
        this.stds = stds;
    }

    public Country stds(Set<Std> stds) {
        this.setStds(stds);
        return this;
    }

    public Country addStd(Std std) {
        this.stds.add(std);
        std.getCountries().add(this);
        return this;
    }

    public Country removeStd(Std std) {
        this.stds.remove(std);
        std.getCountries().remove(this);
        return this;
    }

    public Set<Prod> getProds() {
        return this.prods;
    }

    public void setProds(Set<Prod> prods) {
        if (this.prods != null) {
            this.prods.forEach(i -> i.removeCountry(this));
        }
        if (prods != null) {
            prods.forEach(i -> i.addCountry(this));
        }
        this.prods = prods;
    }

    public Country prods(Set<Prod> prods) {
        this.setProds(prods);
        return this;
    }

    public Country addProd(Prod prod) {
        this.prods.add(prod);
        prod.getCountries().add(this);
        return this;
    }

    public Country removeProd(Prod prod) {
        this.prods.remove(prod);
        prod.getCountries().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        return id != null && id.equals(((Country) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Country{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
