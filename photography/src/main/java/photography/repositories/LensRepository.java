package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photography.entities.Lens;

@Repository
public interface LensRepository extends JpaRepository<Lens,Long>{
}