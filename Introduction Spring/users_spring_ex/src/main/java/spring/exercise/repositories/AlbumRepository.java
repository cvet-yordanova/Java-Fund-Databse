package spring.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exercise.entites.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{
}
