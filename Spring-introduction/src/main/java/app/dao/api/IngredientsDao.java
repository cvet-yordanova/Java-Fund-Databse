package app.dao.api;

import app.model.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 18.7.2017 ?..
 */

public interface IngredientsDao extends JpaRepository<BasicIngredient, Long>, IngedientsDaoCustom {
    List<BasicIngredient> findByNameEndingWith(String suffix);
}
