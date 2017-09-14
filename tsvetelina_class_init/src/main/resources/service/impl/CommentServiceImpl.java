import org.springframework.stereotype.Service;

import javax.transaction.Transactional; import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment findOne(Long aLong) {
        return this.commentRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.commentRepository.delete(aLong);
    }

    @Override
    public void delete(Comment entity) {
            this.commentRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}