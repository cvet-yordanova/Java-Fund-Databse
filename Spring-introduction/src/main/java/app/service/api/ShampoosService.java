package app.service.api;

import java.util.List;

/**
 * Created by User on 18.7.2017 ?..
 */
public interface ShampoosService<BasicShampoos, Long> extends ServiceInterface<BasicShampoos, Long> {
    void solveAllTasks();

    List<app.model.BasicShampoos> shampoosWithBrand(String brand);

    List<BasicShampoos> shampoosWithIngredient(String ingredientName);
}
