package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Accessory;
import softuni.entities.Camera;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Long>{
}
