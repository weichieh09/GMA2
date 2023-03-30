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
 * A Sticker.
 */
@Entity
@Table(name = "sticker")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Sticker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Size(max = 20)
    @Column(name = "sticker_no", length = 20)
    private String stickerNo;

    @Lob
    @Column(name = "img")
    private byte[] img;

    @Column(name = "img_content_type")
    private String imgContentType;

    @OneToMany(mappedBy = "sticker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "fees", "countries", "stds", "sticker", "cerfs" }, allowSetters = true)
    private Set<Prod> prods = new HashSet<>();

    @OneToMany(mappedBy = "sticker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "country", "cerf", "sticker" }, allowSetters = true)
    private Set<Mark> marks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Sticker id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStickerNo() {
        return this.stickerNo;
    }

    public Sticker stickerNo(String stickerNo) {
        this.setStickerNo(stickerNo);
        return this;
    }

    public void setStickerNo(String stickerNo) {
        this.stickerNo = stickerNo;
    }

    public byte[] getImg() {
        return this.img;
    }

    public Sticker img(byte[] img) {
        this.setImg(img);
        return this;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getImgContentType() {
        return this.imgContentType;
    }

    public Sticker imgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
        return this;
    }

    public void setImgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
    }

    public Set<Prod> getProds() {
        return this.prods;
    }

    public void setProds(Set<Prod> prods) {
        if (this.prods != null) {
            this.prods.forEach(i -> i.setSticker(null));
        }
        if (prods != null) {
            prods.forEach(i -> i.setSticker(this));
        }
        this.prods = prods;
    }

    public Sticker prods(Set<Prod> prods) {
        this.setProds(prods);
        return this;
    }

    public Sticker addProd(Prod prod) {
        this.prods.add(prod);
        prod.setSticker(this);
        return this;
    }

    public Sticker removeProd(Prod prod) {
        this.prods.remove(prod);
        prod.setSticker(null);
        return this;
    }

    public Set<Mark> getMarks() {
        return this.marks;
    }

    public void setMarks(Set<Mark> marks) {
        if (this.marks != null) {
            this.marks.forEach(i -> i.setSticker(null));
        }
        if (marks != null) {
            marks.forEach(i -> i.setSticker(this));
        }
        this.marks = marks;
    }

    public Sticker marks(Set<Mark> marks) {
        this.setMarks(marks);
        return this;
    }

    public Sticker addMark(Mark mark) {
        this.marks.add(mark);
        mark.setSticker(this);
        return this;
    }

    public Sticker removeMark(Mark mark) {
        this.marks.remove(mark);
        mark.setSticker(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sticker)) {
            return false;
        }
        return id != null && id.equals(((Sticker) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Sticker{" +
            "id=" + getId() +
            ", stickerNo='" + getStickerNo() + "'" +
            ", img='" + getImg() + "'" +
            ", imgContentType='" + getImgContentType() + "'" +
            "}";
    }
}
