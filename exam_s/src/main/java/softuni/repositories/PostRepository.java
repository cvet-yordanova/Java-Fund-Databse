package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entites.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

    Post findPostById(Integer id);

    @Query(value = "SELECT p.* \n" +
            "FROM posts AS p \n" +
            "LEFT OUTER JOIN comments AS C\n" +
            "ON p.id = c.post\n" +
            "WHERE c.id is null\n" +
            "ORDER BY p.id", nativeQuery = true)
    List<Post> getAllPostsWithoutComments();
}