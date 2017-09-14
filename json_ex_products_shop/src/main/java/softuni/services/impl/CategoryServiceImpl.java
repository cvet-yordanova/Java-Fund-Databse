package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.add.CategoryAddDto;
import softuni.dto.view.category_by_products_count.ProductCatView;
import softuni.entites.Category;
import softuni.entites.Product;
import softuni.io.ModelParser;
import softuni.repositories.CategoryRepository;
import softuni.services.api.CategoryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryAddDto categoryAddDto) {

        Category category = ModelParser.getInstance().map(categoryAddDto, Category.class);
        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> findAll = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category : findAll) {
            CategoryDto categoryDto = ModelParser.getInstance().map(category,CategoryDto.class);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    public List<ProductCatView> CategoriesByProductsCount() {
        List<ProductCatView> productCatViews = this.categoryRepository.categoriesByProducts();
        List<ProductCatView> productCatViewList = new ArrayList<>();

        return productCatViews;
    }
}
