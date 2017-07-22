package Model.service.api;


import Model.BasicIngredient;

import java.util.List;

public interface IngredientsService {

    BasicIngredient findById(Long id);
    void remove(BasicIngredient entity);
    List<BasicIngredient> findAll();
    void save(BasicIngredient Entity);
}
