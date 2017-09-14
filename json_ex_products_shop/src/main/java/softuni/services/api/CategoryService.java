package softuni.services.api;


import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.add.CategoryAddDto;
import softuni.dto.view.category_by_products_count.ProductCatView;
import softuni.entites.Category;

import java.util.List;

public interface CategoryService {

    public void save(CategoryAddDto categoryAddDto);
    List<CategoryDto> findAll();
    List<ProductCatView> CategoriesByProductsCount();
}
