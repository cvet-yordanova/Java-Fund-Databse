package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Long>{
}