package softuni.service.api;

import softuni.entities.Branch;
import softuni.entities.Product;
import softuni.models.binding.import_products.ImportProductXmlDto;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findOne(Long aLong);
    void delete(Long aLong);
    void delete(Product car);
    void importProductsXml(ImportProductXmlDto productDto, Branch branch);
}