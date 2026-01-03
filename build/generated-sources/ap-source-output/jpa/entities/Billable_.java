package jpa.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Consultant;
import jpa.entities.Project;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(Billable.class)
public class Billable_ { 

    public static volatile SingularAttribute<Billable, Long> billableId;
    public static volatile SingularAttribute<Billable, Short> hours;
    public static volatile SingularAttribute<Billable, Date> endDate;
    public static volatile SingularAttribute<Billable, Consultant> consultantId;
    public static volatile SingularAttribute<Billable, String> description;
    public static volatile SingularAttribute<Billable, Project> project;
    public static volatile SingularAttribute<Billable, BigDecimal> hourlyRate;
    public static volatile SingularAttribute<Billable, Date> startDate;
    public static volatile SingularAttribute<Billable, BigDecimal> billableHourlyRate;
    public static volatile SingularAttribute<Billable, String> artifacts;

}