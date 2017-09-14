import java.util.List;

public interface UserService {

    List<User> findAll();
    User findOne(Long aLong);
    void delete(Long aLong);
    void delete(User car);
}