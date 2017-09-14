package spring.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exercise.entites.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long>{
}
