import org.springframework.stereotype.Service;

import javax.transaction.Transactional; import java.util.List;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<Picture> findAll() {
        return this.pictureRepository.findAll();
    }

    @Override
    public Picture findOne(Long aLong) {
        return this.pictureRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.pictureRepository.delete(aLong);
    }

    @Override
    public void delete(Picture entity) {
            this.pictureRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}