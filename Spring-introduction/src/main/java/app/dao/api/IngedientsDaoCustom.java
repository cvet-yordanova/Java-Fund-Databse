package app.dao.api;

import app.model.BasicIngredient;
import app.model.BasicShampoos;

import java.util.List;

/**
 * Created by User on 19.7.2017 ?..
 */
public interface IngedientsDaoCustom {
    List<BasicShampoos> shampoosWithIngredient(BasicIngredient ingredient);
}
