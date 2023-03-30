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
 * A Company.
 */
@Entity
@Table(name = "company")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompany")
    @SequenceGenerator(name = "seqCompany")
    @Column(name = "id")
    private Long id;

    @Size(max = 20)
    @Column(name = "company_no", length = 20)
    private String companyNo;

    @Size(max = 100)
    @Column(name = "en_name", length = 100)
    private String enName;

    @Size(max = 100)
    @Column(name = "ch_name", length = 100)
    private String chName;

    @Size(max = 20)
    @Column(name = "tel", length = 20)
    private String tel;

    @Size(max = 100)
    @Column(name = "addr", length = 100)
    private String addr;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @OneToMany(mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "cerf", "company" }, allowSetters = true)
    private Set<CerfCompany> cerfCompanies = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "prod", "cerf", "company" }, allowSetters = true)
    private Set<Fee> fees = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Company id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyNo() {
        return this.companyNo;
    }

    public Company companyNo(String companyNo) {
        this.setCompanyNo(companyNo);
        return this;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getEnName() {
        return this.enName;
    }

    public Company enName(String enName) {
        this.setEnName(enName);
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getChName() {
        return this.chName;
    }

    public Company chName(String chName) {
        this.setChName(chName);
        return this;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getTel() {
        return this.tel;
    }

    public Company tel(String tel) {
        this.setTel(tel);
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return this.addr;
    }

    public Company addr(String addr) {
        this.setAddr(addr);
        return this;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return this.email;
    }

    public Company email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<CerfCompany> getCerfCompanies() {
        return this.cerfCompanies;
    }

    public void setCerfCompanies(Set<CerfCompany> cerfCompanies) {
        if (this.cerfCompanies != null) {
            this.cerfCompanies.forEach(i -> i.setCompany(null));
        }
        if (cerfCompanies != null) {
            cerfCompanies.forEach(i -> i.setCompany(this));
        }
        this.cerfCompanies = cerfCompanies;
    }

    public Company cerfCompanies(Set<CerfCompany> cerfCompanies) {
        this.setCerfCompanies(cerfCompanies);
        return this;
    }

    public Company addCerfCompany(CerfCompany cerfCompany) {
        this.cerfCompanies.add(cerfCompany);
        cerfCompany.setCompany(this);
        return this;
    }

    public Company removeCerfCompany(CerfCompany cerfCompany) {
        this.cerfCompanies.remove(cerfCompany);
        cerfCompany.setCompany(null);
        return this;
    }

    public Set<Fee> getFees() {
        return this.fees;
    }

    public void setFees(Set<Fee> fees) {
        if (this.fees != null) {
            this.fees.forEach(i -> i.setCompany(null));
        }
        if (fees != null) {
            fees.forEach(i -> i.setCompany(this));
        }
        this.fees = fees;
    }

    public Company fees(Set<Fee> fees) {
        this.setFees(fees);
        return this;
    }

    public Company addFee(Fee fee) {
        this.fees.add(fee);
        fee.setCompany(this);
        return this;
    }

    public Company removeFee(Fee fee) {
        this.fees.remove(fee);
        fee.setCompany(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Company)) {
            return false;
        }
        return id != null && id.equals(((Company) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Company{" +
            "id=" + getId() +
            ", companyNo='" + getCompanyNo() + "'" +
            ", enName='" + getEnName() + "'" +
            ", chName='" + getChName() + "'" +
            ", tel='" + getTel() + "'" +
            ", addr='" + getAddr() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
