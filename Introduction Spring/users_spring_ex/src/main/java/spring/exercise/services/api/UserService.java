package spring.exercise.services.api;


import spring.exercise.entites.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    void persist(User user);
    List<User> findAll();
    List<User> findByLastTimeLoggedInBefore(Date date);
}
