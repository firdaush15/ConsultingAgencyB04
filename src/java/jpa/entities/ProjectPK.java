/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mohd5
 */
@Embeddable
public class ProjectPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_DEPARTMENT_NUMBER")
    private short clientDepartmentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROJECT_NAME")
    private String projectName;

    public ProjectPK() {
    }

    public ProjectPK(String clientName, short clientDepartmentNumber, String projectName) {
        this.clientName = clientName;
        this.clientDepartmentNumber = clientDepartmentNumber;
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public short getClientDepartmentNumber() {
        return clientDepartmentNumber;
    }

    public void setClientDepartmentNumber(short clientDepartmentNumber) {
        this.clientDepartmentNumber = clientDepartmentNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientName != null ? clientName.hashCode() : 0);
        hash += (int) clientDepartmentNumber;
        hash += (projectName != null ? projectName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectPK)) {
            return false;
        }
        ProjectPK other = (ProjectPK) object;
        if ((this.clientName == null && other.clientName != null) || (this.clientName != null && !this.clientName.equals(other.clientName))) {
            return false;
        }
        if (this.clientDepartmentNumber != other.clientDepartmentNumber) {
            return false;
        }
        if ((this.projectName == null && other.projectName != null) || (this.projectName != null && !this.projectName.equals(other.projectName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProjectPK[ clientName=" + clientName + ", clientDepartmentNumber=" + clientDepartmentNumber + ", projectName=" + projectName + " ]";
    }
    
}
