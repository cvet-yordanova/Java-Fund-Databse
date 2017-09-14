package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.import_people_json.ImportPersonJsonDto;
import softuni.entities.Gender;
import softuni.entities.Person;
import softuni.io.DtoMappingUtil;
import softuni.resources.repositories.PersonRepository;
import softuni.service.api.PersonService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final DTOValidator validator;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, DTOValidator validator) {
        this.personRepository = personRepository;
        this.validator = validator;
    }

    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findOne(Long aLong) {
        return this.personRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.personRepository.delete(aLong);
    }

    @Override
    public void delete(Person entity) {
            this.personRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importPeople(ImportPersonJsonDto[] personJsonDtos) {
        for (ImportPersonJsonDto personJsonDto : personJsonDtos) {

            Person person = DtoMappingUtil.convert(personJsonDto, Person.class);
            if(personJsonDto.getGender() != null){
                setGender(personJsonDto, person);
            }
            if(validator.isValid(person)){
                this.personRepository.saveAndFlush(person);
                System.out.println("Successully imported "+person.getFirstName()+" "+person.getLastName());
            } else {
                System.out.println("Error. Invalid data provided.");
            }
        }
    }

    public void setGender(ImportPersonJsonDto personDto, Person person){

            String gender = personDto.getGender().toLowerCase();
            switch (gender){
                case "female" : person.setGender(Gender.valueOf("FEMALE"));
                break;
                case "male" : person.setGender(Gender.valueOf("MALE"));
                break;
                default: person.setGender(Gender.valueOf("NOT_SPECIFIED"));
                break;
            }
        }

}