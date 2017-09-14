package softuni.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{

    @Query("SELECT p FROM Person p WHERE CONCAT(p.firstName,' ',p.middleNameInitial,' ',p.lastName) = :fullname ")
    Person findPersonByFullName(@Param(value = "fullname") String fullName);
}