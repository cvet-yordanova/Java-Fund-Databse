package softuni.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Wedding;

import java.util.List;

@Repository
public interface WeddingRepository extends JpaRepository<Wedding,Long>{

    @Query("SELECT w FROM Wedding w INNER JOIN w.invitations i " +
            "GROUP BY w ORDER BY COUNT(i) DESC")
    List<Wedding> allWeddingsOrderByGuests();

    @Query("SELECT DISTINCT a.town FROM Agency a " +
            "WHERE LENGTH(a.town) >=6 ")
    List<String> AllTownsWithAtLeast6Symbols();

    @Query("SELECT DISTINCT w FROM Wedding as w WHERE w.agency.name = :name")
    List<Wedding> findWeddingsByAgencyName(@Param("name") String name);
}