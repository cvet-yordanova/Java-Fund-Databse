package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import photography.entities.Photographer;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long>{
        Photographer findByFirstNameAndLastName(String firstName, String lastName);

        @Query("SELECT p FROM Photographer AS p ORDER BY p.firstName, p.lastName DESC ")
        List<Photographer> getPhotographersOrdered();

        @Query("SELECT p FROM Photographer p WHERE p.primaryCamera.make = p.secondaryCamera.make")
        List<Photographer> getPhotographersWithSameCameras();

        @Query(" SELECT DISTINCT p FROM Photographer p " +
                "INNER JOIN p.lenses l  " +
                "WHERE l.focalLength <= 30 AND " +
                "p.primaryCamera.class = 'DSLR' " +
                "ORDER BY p.firstName")
        List<Photographer> getLandscapePhotographers();
}