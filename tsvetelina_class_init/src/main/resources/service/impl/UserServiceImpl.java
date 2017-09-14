import org.springframework.stereotype.Service;

import javax.transaction.Transactional; import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findOne(Long aLong) {
        return this.userRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.userRepository.delete(aLong);
    }

    @Override
    public void delete(User entity) {
            this.userRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}