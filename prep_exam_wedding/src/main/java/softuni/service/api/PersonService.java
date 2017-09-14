package softuni.service.api;

import softuni.entities.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person findOne(Long aLong);
    void delete(Long aLong);
    void delete(Person car);
    void save(Person person);
    Person findByName(String firstName, String middleNameInitial, String lastName);

}