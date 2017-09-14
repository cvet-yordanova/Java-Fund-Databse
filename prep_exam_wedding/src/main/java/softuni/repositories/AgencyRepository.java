package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency,Long>{

    Agency findByName(String name);

}