package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long>{
}