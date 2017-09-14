package softuni.service.api;

import softuni.dto.import_people_json.ImportPersonJsonDto;
import softuni.entities.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person findOne(Long aLong);
    void delete(Long aLong);
    void delete(Person car);
    void importPeople(ImportPersonJsonDto[] personJsonDtos);
}