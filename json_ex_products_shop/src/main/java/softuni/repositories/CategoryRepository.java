package softuni.repositories;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.dto.view.ProductViewDto;
import softuni.dto.view.category_by_products_count.ProductCatView;
import softuni.entites.Category;
import softuni.entites.Product;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("SELECT  new softuni.dto.view.category_by_products_count.ProductCatView(c.name, COUNT(p), AVG(p.price), " +
            "SUM(p.price))  FROM Category AS c INNER JOIN c.products AS p " +
            "GROUP BY c")
    List<ProductCatView> categoriesByProducts();
}
