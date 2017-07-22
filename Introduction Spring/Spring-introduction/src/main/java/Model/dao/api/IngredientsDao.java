package Model.dao.api;

import Model.BasicIngredient;
import Model.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsDao extends JpaRepository<BasicIngredient,Long>{
    
}
