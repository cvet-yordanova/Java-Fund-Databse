package softuni.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.model.Person;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{
    List<Person> findAllByAddressCountry(String address_country);
}
