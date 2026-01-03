/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mohd5
 */
@Entity
@Table(name = "CONSULTANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultant.findAll", query = "SELECT c FROM Consultant c"),
    @NamedQuery(name = "Consultant.findByConsultantId", query = "SELECT c FROM Consultant c WHERE c.consultantId = :consultantId"),
    @NamedQuery(name = "Consultant.findByEmail", query = "SELECT c FROM Consultant c WHERE c.email = :email"),
    @NamedQuery(name = "Consultant.findByPassword", query = "SELECT c FROM Consultant c WHERE c.password = :password"),
    @NamedQuery(name = "Consultant.findByHourlyRate", query = "SELECT c FROM Consultant c WHERE c.hourlyRate = :hourlyRate"),
    @NamedQuery(name = "Consultant.findByBillableHourlyRate", query = "SELECT c FROM Consultant c WHERE c.billableHourlyRate = :billableHourlyRate"),
    @NamedQuery(name = "Consultant.findByHireDate", query = "SELECT c FROM Consultant c WHERE c.hireDate = :hireDate")})
public class Consultant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONSULTANT_ID")
    private Integer consultantId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOURLY_RATE")
    private BigDecimal hourlyRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BILLABLE_HOURLY_RATE")
    private BigDecimal billableHourlyRate;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Lob
    @Size(max = 32700)
    @Column(name = "RESUME")
    private String resume;
    @JoinTable(name = "PROJECT_CONSULTANT", joinColumns = {
        @JoinColumn(name = "CONSULTANT_ID", referencedColumnName = "CONSULTANT_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CLIENT_NAME", referencedColumnName = "CLIENT_NAME"),
        @JoinColumn(name = "CLIENT_DEPARTMENT_NUMBER", referencedColumnName = "CLIENT_DEPARTMENT_NUMBER"),
        @JoinColumn(name = "PROJECT_NAME", referencedColumnName = "PROJECT_NAME")})
    @ManyToMany
    private Collection<Project> projectCollection;
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID")
    @ManyToOne(optional = false)
    private ConsultantStatus statusId;
    @JoinColumn(name = "RECRUITER_ID", referencedColumnName = "RECRUITER_ID")
    @ManyToOne
    private Recruiter recruiterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultantId")
    private Collection<Billable> billableCollection;

    public Consultant() {
    }

    public Consultant(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Consultant(Integer consultantId, String email, String password, BigDecimal hourlyRate, BigDecimal billableHourlyRate) {
        this.consultantId = consultantId;
        this.email = email;
        this.password = password;
        this.hourlyRate = hourlyRate;
        this.billableHourlyRate = billableHourlyRate;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getBillableHourlyRate() {
        return billableHourlyRate;
    }

    public void setBillableHourlyRate(BigDecimal billableHourlyRate) {
        this.billableHourlyRate = billableHourlyRate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public ConsultantStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(ConsultantStatus statusId) {
        this.statusId = statusId;
    }

    public Recruiter getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Recruiter recruiterId) {
        this.recruiterId = recruiterId;
    }

    @XmlTransient
    public Collection<Billable> getBillableCollection() {
        return billableCollection;
    }

    public void setBillableCollection(Collection<Billable> billableCollection) {
        this.billableCollection = billableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultantId != null ? consultantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultant)) {
            return false;
        }
        Consultant other = (Consultant) object;
        if ((this.consultantId == null && other.consultantId != null) || (this.consultantId != null && !this.consultantId.equals(other.consultantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Consultant[ consultantId=" + consultantId + " ]";
    }
    
}
