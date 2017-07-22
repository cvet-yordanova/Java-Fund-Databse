package entities;

import javax.persistence.Entity;


public interface Person {

    Long getId();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();

}
