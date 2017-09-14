package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.model.Person;
import softuni.respository.PersonRepo;
import softuni.service.api.PersonService;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public void createPerson(Person person) {
        this.personRepo.save(person);
    }

    @Override
    public List<Person> findByCountry(String country) {
        return this.personRepo.findAllByAddressCountry(country);
    }
}
