import org.springframework.stereotype.Service;

import javax.transaction.Transactional; import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Post findOne(Long aLong) {
        return this.postRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.postRepository.delete(aLong);
    }

    @Override
    public void delete(Post entity) {
            this.postRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}