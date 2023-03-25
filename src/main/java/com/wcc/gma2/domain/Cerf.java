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
 * A Cerf.
 */
@Entity
@Table(name = "cerf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cerf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCerf")
    @SequenceGenerator(name = "seqCerf")
    @Column(name = "id")
    private Long id;

    @Size(max = 30)
    @Column(name = "cerf_no", length = 30)
    private String cerfNo;

    @Size(max = 20)
    @Column(name = "cerf_ver", length = 20)
    private String cerfVer;

    @Size(max = 10)
    @Column(name = "status", length = 10)
    private String status;

    @Lob
    @Column(name = "pdf")
    private byte[] pdf;

    @Column(name = "pdf_content_type")
    private String pdfContentType;

    @Column(name = "appl_id")
    private Long applId;

    @Column(name = "fcty_id")
    private Long fctyId;

    @Column(name = "mnfctr_id")
    private Long mnfctrId;

    @Column(name = "issu_dt")
    private LocalDate issuDt;

    @Column(name = "exp_dt")
    private LocalDate expDt;

    @ManyToMany
    @JoinTable(name = "rel_cerf__prod", joinColumns = @JoinColumn(name = "cerf_id"), inverseJoinColumns = @JoinColumn(name = "prod_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prodFees", "countries", "stds", "marks", "cerfs" }, allowSetters = true)
    private Set<Prod> prods = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "rel_cerf__std", joinColumns = @JoinColumn(name = "cerf_id"), inverseJoinColumns = @JoinColumn(name = "std_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prods", "cerfs", "countries" }, allowSetters = true)
    private Set<Std> stds = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "cerfs", "marks", "stds", "prods" }, allowSetters = true)
    private Country country;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cerf id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCerfNo() {
        return this.cerfNo;
    }

    public Cerf cerfNo(String cerfNo) {
        this.setCerfNo(cerfNo);
        return this;
    }

    public void setCerfNo(String cerfNo) {
        this.cerfNo = cerfNo;
    }

    public String getCerfVer() {
        return this.cerfVer;
    }

    public Cerf cerfVer(String cerfVer) {
        this.setCerfVer(cerfVer);
        return this;
    }

    public void setCerfVer(String cerfVer) {
        this.cerfVer = cerfVer;
    }

    public String getStatus() {
        return this.status;
    }

    public Cerf status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getPdf() {
        return this.pdf;
    }

    public Cerf pdf(byte[] pdf) {
        this.setPdf(pdf);
        return this;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getPdfContentType() {
        return this.pdfContentType;
    }

    public Cerf pdfContentType(String pdfContentType) {
        this.pdfContentType = pdfContentType;
        return this;
    }

    public void setPdfContentType(String pdfContentType) {
        this.pdfContentType = pdfContentType;
    }

    public Long getApplId() {
        return this.applId;
    }

    public Cerf applId(Long applId) {
        this.setApplId(applId);
        return this;
    }

    public void setApplId(Long applId) {
        this.applId = applId;
    }

    public Long getFctyId() {
        return this.fctyId;
    }

    public Cerf fctyId(Long fctyId) {
        this.setFctyId(fctyId);
        return this;
    }

    public void setFctyId(Long fctyId) {
        this.fctyId = fctyId;
    }

    public Long getMnfctrId() {
        return this.mnfctrId;
    }

    public Cerf mnfctrId(Long mnfctrId) {
        this.setMnfctrId(mnfctrId);
        return this;
    }

    public void setMnfctrId(Long mnfctrId) {
        this.mnfctrId = mnfctrId;
    }

    public LocalDate getIssuDt() {
        return this.issuDt;
    }

    public Cerf issuDt(LocalDate issuDt) {
        this.setIssuDt(issuDt);
        return this;
    }

    public void setIssuDt(LocalDate issuDt) {
        this.issuDt = issuDt;
    }

    public LocalDate getExpDt() {
        return this.expDt;
    }

    public Cerf expDt(LocalDate expDt) {
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
        this.prods = prods;
    }

    public Cerf prods(Set<Prod> prods) {
        this.setProds(prods);
        return this;
    }

    public Cerf addProd(Prod prod) {
        this.prods.add(prod);
        prod.getCerfs().add(this);
        return this;
    }

    public Cerf removeProd(Prod prod) {
        this.prods.remove(prod);
        prod.getCerfs().remove(this);
        return this;
    }

    public Set<Std> getStds() {
        return this.stds;
    }

    public void setStds(Set<Std> stds) {
        this.stds = stds;
    }

    public Cerf stds(Set<Std> stds) {
        this.setStds(stds);
        return this;
    }

    public Cerf addStd(Std std) {
        this.stds.add(std);
        std.getCerfs().add(this);
        return this;
    }

    public Cerf removeStd(Std std) {
        this.stds.remove(std);
        std.getCerfs().remove(this);
        return this;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Cerf country(Country country) {
        this.setCountry(country);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cerf)) {
            return false;
        }
        return id != null && id.equals(((Cerf) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cerf{" +
            "id=" + getId() +
            ", cerfNo='" + getCerfNo() + "'" +
            ", cerfVer='" + getCerfVer() + "'" +
            ", status='" + getStatus() + "'" +
            ", pdf='" + getPdf() + "'" +
            ", pdfContentType='" + getPdfContentType() + "'" +
            ", applId=" + getApplId() +
            ", fctyId=" + getFctyId() +
            ", mnfctrId=" + getMnfctrId() +
            ", issuDt='" + getIssuDt() + "'" +
            ", expDt='" + getExpDt() + "'" +
            "}";
    }
}
