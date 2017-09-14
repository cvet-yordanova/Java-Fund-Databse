package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entites.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
}