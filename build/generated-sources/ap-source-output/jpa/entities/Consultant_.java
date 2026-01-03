package jpa.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Billable;
import jpa.entities.ConsultantStatus;
import jpa.entities.Project;
import jpa.entities.Recruiter;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(Consultant.class)
public class Consultant_ { 

    public static volatile SingularAttribute<Consultant, String> resume;
    public static volatile SingularAttribute<Consultant, Recruiter> recruiterId;
    public static volatile SingularAttribute<Consultant, String> password;
    public static volatile SingularAttribute<Consultant, Date> hireDate;
    public static volatile SingularAttribute<Consultant, ConsultantStatus> statusId;
    public static volatile SingularAttribute<Consultant, Integer> consultantId;
    public static volatile CollectionAttribute<Consultant, Billable> billableCollection;
    public static volatile SingularAttribute<Consultant, BigDecimal> hourlyRate;
    public static volatile CollectionAttribute<Consultant, Project> projectCollection;
    public static volatile SingularAttribute<Consultant, String> email;
    public static volatile SingularAttribute<Consultant, BigDecimal> billableHourlyRate;

}