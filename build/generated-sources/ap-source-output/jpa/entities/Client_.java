package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Address;
import jpa.entities.ClientPK;
import jpa.entities.Project;
import jpa.entities.Recruiter;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, ClientPK> clientPK;
    public static volatile SingularAttribute<Client, String> contactEmail;
    public static volatile SingularAttribute<Client, Address> billingAddress;
    public static volatile CollectionAttribute<Client, Project> projectCollection;
    public static volatile SingularAttribute<Client, String> contactPassword;
    public static volatile CollectionAttribute<Client, Recruiter> recruiterCollection;

}