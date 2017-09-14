package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Person;
import softuni.enums.Gender;
import softuni.repositories.PersonRepository;
import softuni.service.api.PersonService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final DTOValidator validator;

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
    public Person findByName(String firstName, String middleNameInitial, String lastName) {
        return this.personRepository.findByFirstNameAndMiddleNameInitialAndLastName(firstName, middleNameInitial, lastName);
    }

    @Override
    public void save(Person person) {
        if(validator.isValid(person)){

            if(person.getGender() == null ){
                person.setGender(Gender.NOT_SPECIFIED);
            }

            this.personRepository.save(person);

            System.out.println("Successfully imported "+person.getFirstName()+" "+person.getLastName());
        }

        else {
            System.out.println("Invalid data provided");
        }
    }
}