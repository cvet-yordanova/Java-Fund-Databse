package photography.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import photography.entities.Camera;

import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Long>{

    @Query(value = "SELECT c.*\n" +
            "FROM cameras c\n" +
            "WHERE c.id NOT in (SELECT p.primary_camera_id FROM photographers p) \n" +
            "&& c.id NOT IN (SELECT p.secondary_camera_id FROM photographers p)", nativeQuery = true)
    List<Camera> getIdsOfUnusedCameras();
}