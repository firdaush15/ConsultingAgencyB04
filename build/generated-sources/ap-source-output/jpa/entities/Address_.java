package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Client;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2026-01-04T01:27:32")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> postalCode;
    public static volatile SingularAttribute<Address, Client> client;
    public static volatile SingularAttribute<Address, String> region;
    public static volatile SingularAttribute<Address, String> line2;
    public static volatile SingularAttribute<Address, String> line1;
    public static volatile SingularAttribute<Address, Integer> addressId;

}