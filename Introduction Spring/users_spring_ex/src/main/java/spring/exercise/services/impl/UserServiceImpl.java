package spring.exercise.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.entites.User;
import spring.exercise.repositories.UserRepository;
import spring.exercise.services.api.UserService;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(User user) {
            this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByLastTimeLoggedInBefore(Date date) {
        return userRepository.findByLastTimeLoggedInBefore(date);
    }
}
