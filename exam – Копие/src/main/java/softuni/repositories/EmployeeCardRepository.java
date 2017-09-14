package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.EmployeeCard;

import java.util.List;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Long>{

    EmployeeCard findEmployeeCardByNumber(String number);

    @Query("SELECT c FROM EmployeeCard  AS c WHERE c.employee IS NULL ORDER BY c.id")
    List<EmployeeCard> findEmployeeCardsWithoutOwner();
}