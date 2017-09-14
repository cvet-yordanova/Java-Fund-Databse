import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    Comment findOne(Long aLong);
    void delete(Long aLong);
    void delete(Comment car);
}