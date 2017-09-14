package softuni.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Cash;

@Repository
public interface CashRepository extends JpaRepository<Cash,Long>{
}