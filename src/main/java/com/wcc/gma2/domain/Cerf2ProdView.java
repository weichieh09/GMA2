package com.wcc.gma2.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Cerf2ProdView.
 */
@Entity
@Table(name = "cerf_2_prod_view")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf2ProdView implements Serializable {

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

    @Column(name = "prod_id")
    private String prodId;

    @Column(name = "prod_nm_ch")
    private String prodNmCh;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cerf2ProdView id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public Cerf2ProdView cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public Cerf2ProdView cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getProdId() {
        return this.prodId;
    }

    public Cerf2ProdView prodId(String prodId) {
        this.setProdId(prodId);
        return this;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdNmCh() {
        return this.prodNmCh;
    }

    public Cerf2ProdView prodNmCh(String prodNmCh) {
        this.setProdNmCh(prodNmCh);
        return this;
    }

    public void setProdNmCh(String prodNmCh) {
        this.prodNmCh = prodNmCh;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cerf2ProdView)) {
            return false;
        }
        return id != null && id.equals(((Cerf2ProdView) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf2ProdView{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", prodId='" + getProdId() + "'" +
            ", prodNmCh='" + getProdNmCh() + "'" +
            "}";
    }
}
