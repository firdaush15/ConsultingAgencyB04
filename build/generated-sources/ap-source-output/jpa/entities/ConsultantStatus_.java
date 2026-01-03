package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Consultant;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(ConsultantStatus.class)
public class ConsultantStatus_ { 

    public static volatile SingularAttribute<ConsultantStatus, String> statusId;
    public static volatile CollectionAttribute<ConsultantStatus, Consultant> consultantCollection;
    public static volatile SingularAttribute<ConsultantStatus, String> description;

}