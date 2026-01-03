/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mohd5
 */
@Entity
@Table(name = "CONSULTANT_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultantStatus.findAll", query = "SELECT c FROM ConsultantStatus c"),
    @NamedQuery(name = "ConsultantStatus.findByStatusId", query = "SELECT c FROM ConsultantStatus c WHERE c.statusId = :statusId"),
    @NamedQuery(name = "ConsultantStatus.findByDescription", query = "SELECT c FROM ConsultantStatus c WHERE c.description = :description")})
public class ConsultantStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_ID")
    private String statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private Collection<Consultant> consultantCollection;

    public ConsultantStatus() {
    }

    public ConsultantStatus(String statusId) {
        this.statusId = statusId;
    }

    public ConsultantStatus(String statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Consultant> getConsultantCollection() {
        return consultantCollection;
    }

    public void setConsultantCollection(Collection<Consultant> consultantCollection) {
        this.consultantCollection = consultantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultantStatus)) {
            return false;
        }
        ConsultantStatus other = (ConsultantStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ConsultantStatus[ statusId=" + statusId + " ]";
    }
    
}
