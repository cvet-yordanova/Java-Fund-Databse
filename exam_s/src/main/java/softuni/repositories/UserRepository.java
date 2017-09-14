package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entites.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByUsername(String username);

    @Query("SELECT DISTINCT u FROM User u INNER JOIN u.posts p " +
            "WHERE p.comments.size > 0 " +
            "ORDER BY u.id DESC")
    List<User> findUsersWithCommentedPosts();

    @Query(value = "SELECT u.username, p.caption, count(c.id)\n" +
            "FROM users AS u\n" +
            "LEFT OUTER JOIN posts AS p\n" +
            "ON u.id = p.user\n" +
            "LEFT OUTER JOIN comments as c\n" +
            "ON p.id = c.post\n" +
            "GROUP BY u.username, p.caption", nativeQuery = true)
    List<Object[]> findUsersWithMostCommentedPost();
}