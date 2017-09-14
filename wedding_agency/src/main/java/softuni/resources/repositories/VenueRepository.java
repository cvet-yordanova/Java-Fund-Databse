package softuni.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Venue;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Long>{

    @Query("SELECT v FROM Venue v WHERE v.town = 'Sofia' and v.weddings.size >=0 " +
            "ORDER BY v.capacity")
    List<Venue> exportVenuesInSofia();
}