package spring.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exercise.entites.User;

@Repository
public interface UserRaRepository<User, Long>{
}