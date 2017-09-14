package softuni.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long>{
}