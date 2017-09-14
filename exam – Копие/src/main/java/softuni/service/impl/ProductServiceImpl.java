package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Branch;
import softuni.entities.Product;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.import_products.ImportProductXmlDto;
import softuni.repositories.ProductRepository;
import softuni.service.api.ProductService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final DTOValidator validator;

    public ProductServiceImpl(ProductRepository productRepository, DTOValidator validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findOne(Long aLong) {
        return this.productRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.productRepository.delete(aLong);
    }

    @Override
    public void delete(Product entity) {
            this.productRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importProductsXml(ImportProductXmlDto productDto, Branch branch) {

        Product product = DtoMappingUtil.convert(productDto, Product.class);
        product.setBranch(branch);

        if(validator.isValid(product)){
            this.productRepository.saveAndFlush(product);
            System.out.println("Successfully imported Product "+product.getName());
        }

        else {
            System.out.println("Error: Invalid data.");
        }
    }
}