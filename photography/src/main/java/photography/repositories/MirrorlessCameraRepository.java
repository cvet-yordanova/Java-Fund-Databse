package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photography.entities.MirrorlessCamera;

@Repository
public interface MirrorlessCameraRepository extends JpaRepository<MirrorlessCamera,Long>{
}