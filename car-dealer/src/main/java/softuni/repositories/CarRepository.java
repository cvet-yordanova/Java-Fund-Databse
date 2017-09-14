package softuni.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>{

    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}