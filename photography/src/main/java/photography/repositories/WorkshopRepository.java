package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import photography.entities.Workshop;

import java.util.Collection;
import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop,Long>{

    @Query("SELECT w FROM Workshop w WHERE w.participants.size >= 5 AND w.location = :location")
    List<Workshop> getWorkshopsNoLess5Partipants(@Param(value = "location") String location);

    List<Workshop> findByLocation(String name);

    @Query("SELECT DISTINCT w.location FROM Workshop w")
    List<String> getAllLocations();
}