package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.binding.add.ProductAddDto;
import softuni.dto.view.ProductViewDto;
import softuni.dto.view.productsWithNoSeller.ProductNoBuyerView;
import softuni.dto.view.xml.ProductsExportXmlDto;
import softuni.entites.Product;
import softuni.entites.User;
import softuni.io.ModelParser;
import softuni.repositories.ProductRepository;
import softuni.services.api.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductAddDto productAddDto) {
        Product product = ModelParser.getInstance().map(productAddDto,Product.class);
        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductViewDto> findAll() {
        List<Product> products = this.productRepository.findAll();
        List<ProductViewDto> productViewDtos = new ArrayList<>();

        for (Product product : products) {
            ProductViewDto productViewDto = ModelParser.getInstance().map(product, ProductViewDto.class);
            productViewDtos.add(productViewDto);
        }

        return productViewDtos;
    }

    @Override
    public List<ProductNoBuyerView> productsNoSeller(User user) {
        List<Product> productsNoBuyer = this.productRepository.findAllByBuyerEqualsOrderByPrice(user);
        List<ProductNoBuyerView> productNoBuyerViews = new ArrayList<>();

        for (Product product : productsNoBuyer) {
            ProductNoBuyerView productNoBuyerView = ModelParser.getInstance().map(product, ProductNoBuyerView.class);
            productNoBuyerView.getSeller().setFullName();
            productNoBuyerViews.add(productNoBuyerView);
        }
        return productNoBuyerViews;
    }

    @Override
    public ProductsExportXmlDto getProductsToExport() {
        ProductsExportXmlDto productsExportXmlDto = new ProductsExportXmlDto();
        productsExportXmlDto.setProductViewDtos(findAll());
        return productsExportXmlDto;
    }
}
