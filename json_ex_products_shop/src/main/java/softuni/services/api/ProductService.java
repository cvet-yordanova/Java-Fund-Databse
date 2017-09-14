package softuni.services.api;


import softuni.dto.binding.add.ProductAddDto;
import softuni.dto.view.ProductViewDto;
import softuni.dto.view.productsWithNoSeller.ProductNoBuyerView;
import softuni.dto.view.xml.ProductsExportXmlDto;
import softuni.entites.User;

import java.util.List;

public interface ProductService {
    void save(ProductAddDto productAddDto);
    List<ProductViewDto> findAll();
    List<ProductNoBuyerView> productsNoSeller(User user);
    ProductsExportXmlDto getProductsToExport();
}
