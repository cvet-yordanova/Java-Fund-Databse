package app.dao.api;

import app.model.BasicShampoos;
import app.model.ClassicLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by User on 18.7.2017 ?..
 */
@Repository
public interface ShampoosDao extends JpaRepository<BasicShampoos, Long> {
    @Query("Select s from BasicShampoos s join s.ingredients i where i.name = :ingredientName")
    List<BasicShampoos> shampoosWithIngredient(@Param("ingredientName") String ingredientName);

    //Problem 1
    List<BasicShampoos> findByBrand(String brandName);

    //Problem 2
    List<BasicShampoos> findByBrandAndSize(String brandName, int size);

    //Problem 3
    List<BasicShampoos> findByBrandOrLabel(String brandName, ClassicLabel label);

    //Problem 4
    List<BasicShampoos> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price);

}
