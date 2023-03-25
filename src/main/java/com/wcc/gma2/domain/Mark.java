package com.wcc.gma2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Mark.
 */
@Entity
@Table(name = "mark")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMark")
    @SequenceGenerator(name = "seqMark")
    @Column(name = "id")
    private Long id;

    @Size(max = 20)
    @Column(name = "mark_no", length = 20)
    private String markNo;

    @Size(max = 100)
    @Column(name = "en_name", length = 100)
    private String enName;

    @Size(max = 100)
    @Column(name = "ch_name", length = 100)
    private String chName;

    @Lob
    @Column(name = "img")
    private byte[] img;

    @Column(name = "img_content_type")
    private String imgContentType;

    @ManyToOne
    @JsonIgnoreProperties(value = { "cerfs", "marks", "stds", "prods" }, allowSetters = true)
    private Country country;

    @ManyToMany(mappedBy = "marks")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prodFees", "countries", "stds", "marks", "cerfs" }, allowSetters = true)
    private Set<Prod> prods = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Mark id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarkNo() {
        return this.markNo;
    }

    public Mark markNo(String markNo) {
        this.setMarkNo(markNo);
        return this;
    }

    public void setMarkNo(String markNo) {
        this.markNo = markNo;
    }

    public String getEnName() {
        return this.enName;
    }

    public Mark enName(String enName) {
        this.setEnName(enName);
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getChName() {
        return this.chName;
    }

    public Mark chName(String chName) {
        this.setChName(chName);
        return this;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public byte[] getImg() {
        return this.img;
    }

    public Mark img(byte[] img) {
        this.setImg(img);
        return this;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getImgContentType() {
        return this.imgContentType;
    }

    public Mark imgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
        return this;
    }

    public void setImgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Mark country(Country country) {
        this.setCountry(country);
        return this;
    }

    public Set<Prod> getProds() {
        return this.prods;
    }

    public void setProds(Set<Prod> prods) {
        if (this.prods != null) {
            this.prods.forEach(i -> i.removeMark(this));
        }
        if (prods != null) {
            prods.forEach(i -> i.addMark(this));
        }
        this.prods = prods;
    }

    public Mark prods(Set<Prod> prods) {
        this.setProds(prods);
        return this;
    }

    public Mark addProd(Prod prod) {
        this.prods.add(prod);
        prod.getMarks().add(this);
        return this;
    }

    public Mark removeProd(Prod prod) {
        this.prods.remove(prod);
        prod.getMarks().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mark)) {
            return false;
        }
        return id != null && id.equals(((Mark) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Mark{" +
            "id=" + getId() +
            ", markNo='" + getMarkNo() + "'" +
            ", enName='" + getEnName() + "'" +
            ", chName='" + getChName() + "'" +
            ", img='" + getImg() + "'" +
            ", imgContentType='" + getImgContentType() + "'" +
            "}";
    }
}
