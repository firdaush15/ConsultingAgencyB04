package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Billable;
import jpa.entities.Client;
import jpa.entities.Consultant;
import jpa.entities.ProjectPK;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, String> contactEmail;
    public static volatile CollectionAttribute<Project, Consultant> consultantCollection;
    public static volatile SingularAttribute<Project, Client> client;
    public static volatile CollectionAttribute<Project, Billable> billableCollection;
    public static volatile SingularAttribute<Project, ProjectPK> projectPK;
    public static volatile SingularAttribute<Project, String> contactPassword;

}