package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entites.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long>{

    Picture findByPath(String path);
}