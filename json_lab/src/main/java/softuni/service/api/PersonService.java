package softuni.service.api;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import softuni.model.Person;

import java.util.List;

public interface PersonService {
    public void createPerson(Person person);
    public List<Person> findByCountry(String country);
}
