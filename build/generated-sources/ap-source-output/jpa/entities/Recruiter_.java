package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Client;
import jpa.entities.Consultant;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(Recruiter.class)
public class Recruiter_ { 

    public static volatile SingularAttribute<Recruiter, Integer> recruiterId;
    public static volatile SingularAttribute<Recruiter, String> password;
    public static volatile CollectionAttribute<Recruiter, Consultant> consultantCollection;
    public static volatile SingularAttribute<Recruiter, Client> client;
    public static volatile SingularAttribute<Recruiter, String> email;

}