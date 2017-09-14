package app.dao.api;

import app.model.BasicShampoos;
import app.model.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 18.7.2017 ?..
 */
@Repository
public interface ProductionBatchDao  extends JpaRepository<ProductionBatch, Long> {
    List<ProductionBatch> findByName(String name);

    //Problem 5
    List<ProductionBatch> findByDateAfter(LocalDate date);

    //Problem 9
    List<ProductionBatch> findByShampoosIsNull();
}
