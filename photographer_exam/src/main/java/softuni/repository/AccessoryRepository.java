package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory,Long>{
}
