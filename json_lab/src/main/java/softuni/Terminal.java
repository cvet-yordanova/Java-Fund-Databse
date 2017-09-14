package softuni;


import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.DtoMappingUtil;
import softuni.dto.PersonDto;
import softuni.dto.PersonsDto;
import softuni.model.Person;
import softuni.serialize.Serializer;
import softuni.service.impl.PersonServiceImpl;
import softuni.test.PersonT;
import softuni.test.PersonT2;
import softuni.test.Telephone;
import softuni.test.TelephoneT;

import java.util.ArrayList;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    private static final String PERSON_INPUT_JSON = "/files/input/json/person.json";
    private static final String PERSON_INPUT_XML = "/files/input/xml/person.xml";
    private static final String PERSONS_INPUT_XML = "/files/input/xml/persons.xml";
    private static final String PERSONS_OUTPUT_XML = "src/main/resources/files/output/xml/personsByCountry.xml";

    @Autowired
    private final PersonServiceImpl personService;

    @Autowired
    @Qualifier(value = "JSonSerializer")
    private Serializer serializer;

    @Autowired
    @Qualifier(value = "XMLSerializer")
    private Serializer serializerXml;

    public Terminal(PersonServiceImpl personService) {
        this.personService = personService;
    }


    @Override
    public void run(String... strings) throws Exception {
        //importPerson();
        //ModelMapper modelMapper = new ModelMapper();

        importPersonXml();

      //  Converter<String, String> tr = ctx -> ctx.getSource().concat();
          //  importPersonXml();
      //  importPersons();
       // exportPersonsXml();



    }

    private void importPersonXml() {
        PersonDto personDto = serializerXml.deserialize(PersonDto.class, PERSON_INPUT_XML);
        Person person = DtoMappingUtil.convert(personDto, Person.class);
        personService.createPerson(person);
    }

    private void importPerson() {

        PersonDto personDto = serializer.deserialize(PersonDto.class, PERSON_INPUT_JSON);
        Person person = DtoMappingUtil.convert(personDto,Person.class);
        personService.createPerson(person);
    }

    private void importPersons(){

        PersonsDto personDto = serializerXml.deserialize(PersonsDto.class,PERSONS_INPUT_XML );
        List<Person> people = DtoMappingUtil.convert(personDto.getPersonDtos(), Person.class);

        for (Person person : people) {
            this.personService.createPerson(person);
        }
    }


    private void exportPersonsXml(){
        List<Person> bulgarians = this.personService.findByCountry("Bulgaria");
        List<PersonDto> personDtos = DtoMappingUtil.convert(bulgarians, PersonDto.class);

        PersonsDto personsDto = new PersonsDto();
        personsDto.setPersonDtos(personDtos);
        serializerXml.serialize(personsDto, PERSONS_OUTPUT_XML);

    }
}
