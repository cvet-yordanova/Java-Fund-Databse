package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Accessory;
import softuni.entities.DSLRCamera;

@Repository
public interface DSLRCameraRepository extends JpaRepository<DSLRCamera,Long>{
}
