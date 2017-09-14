package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Accessory;
import softuni.entities.MirrorlessCamera;

@Repository
public interface MirrolessCameraRepository extends JpaRepository<MirrorlessCamera,Long>{
}
