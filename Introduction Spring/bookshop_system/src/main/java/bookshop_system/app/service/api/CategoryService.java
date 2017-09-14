package bookshop_system.app.service.api;


import bookshop_system.app.entities.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAllCategories();
}
