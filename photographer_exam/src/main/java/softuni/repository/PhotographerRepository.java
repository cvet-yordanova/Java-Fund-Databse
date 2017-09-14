package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Accessory;
import softuni.entities.Photographer;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long>{
}
