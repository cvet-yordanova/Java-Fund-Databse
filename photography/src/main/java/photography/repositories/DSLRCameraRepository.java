package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photography.entities.DSLRCamera;

@Repository
public interface DSLRCameraRepository extends JpaRepository<DSLRCamera,Long>{
}