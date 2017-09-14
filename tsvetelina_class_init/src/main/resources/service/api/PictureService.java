import java.util.List;

public interface PictureService {

    List<Picture> findAll();
    Picture findOne(Long aLong);
    void delete(Long aLong);
    void delete(Picture car);
}