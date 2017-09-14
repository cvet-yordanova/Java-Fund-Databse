package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Car;
import softuni.entities.Supplier1;

import java.util.List;

@Repository
public interface Supplier2Repository extends JpaRepository<Supplier1,Long>{
    @Override
    List<Supplier1> findAll();

    @Override
    Supplier1 getOne(Long aLong);

    @Override
    Supplier1 findOne(Long aLong);

    @Override
    boolean exists(Long aLong);

    @Override
    long count();

    @Override
    void delete(Long aLong);

    @Override
    void delete(Supplier1 car);
}