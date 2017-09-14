import java.util.List;

public interface PostService {

    List<Post> findAll();
    Post findOne(Long aLong);
    void delete(Long aLong);
    void delete(Post car);
}