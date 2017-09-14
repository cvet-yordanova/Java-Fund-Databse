package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.UserDto;
import softuni.dto.binding.add.CategoryAddDto;
import softuni.dto.binding.add.ProductAddDto;
import softuni.dto.binding.add.UserAddDto;
import softuni.dto.view.ProductViewDto;
import softuni.dto.view.category_by_products_count.ProductCatView;
import softuni.dto.view.productsWithNoSeller.ProductNoBuyerView;
import softuni.dto.view.user_with_sold_products.UserSoldProducts;
import softuni.dto.view.users_and_products.CountUserProducts;
import softuni.dto.view.xml.ProductsExportXmlDto;
import softuni.dto.xmlDTOs.CategoriesImporDtoXml;
import softuni.dto.xmlDTOs.ProductsImportXmlDto;
import softuni.dto.xmlDTOs.UsersImportXMLDto;
import softuni.io.JsonParser;
import softuni.io.XMLParser;
import softuni.services.api.CategoryService;
import softuni.services.api.ProductService;
import softuni.services.api.UserService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner{


    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final JsonParser jsonParser;
    private final XMLParser xmlParser;


    @Autowired
    public Terminal(CategoryService categoryService, UserService userService, ProductService productService, JsonParser jsonParser, XMLParser xmlParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {
           // importUsers();
       // importCategories();
        //importProducts();
        //export();
        //exportProductsNoSeller();
       // exportUserWithSoldProduct();
        //exportCategoriesByCountProducts();
        //exportUsersAndProducts();
       // importUsersXml();
        //importCategoriesXml();
       // importProductsXml();

        exportXml();
    }

    private void importUsers() {
        UserAddDto[] userAddDtos = this.jsonParser.getObject(UserAddDto[].class, "/files/json/in/users.json");

        for (UserAddDto userAddDto : userAddDtos) {
            this.userService.save(userAddDto);
        }
    }

    public void importCategories(){
        CategoryAddDto[] categoryAddDtos = this.jsonParser.getObject(CategoryAddDto[].class, "/files/json/in/categories.json");

        for (CategoryAddDto categoryAddDto : categoryAddDtos) {
            this.categoryService.save(categoryAddDto);
        }
    }

    public void importProducts(){
        Random random = new Random();
        List<UserDto> allUsers = this.userService.findAllUserDtos();
        List<CategoryDto> allCategories = this.categoryService.findAll();
        ProductAddDto[] productAddDtos = this.jsonParser.getObject(ProductAddDto[].class, "/files/json/in/products.json");

        for (ProductAddDto productAddDto : productAddDtos) {

            Set<CategoryDto> categoryDtoSet = new HashSet<>();
            UserDto seller = allUsers.get(random.nextInt(allUsers.size()));
            UserDto buyer = allUsers.get(random.nextInt(allUsers.size()));

            if(seller.getId().equals(buyer.getId())){
                buyer = null;
            }


            for (int i = 0; i <random.nextInt(10) ; i++) {
                categoryDtoSet.add(allCategories.get(random.nextInt(allCategories.size())));
            }

            productAddDto.setSeller(seller);
            productAddDto.setBuyer(buyer);
            productAddDto.setCategories(categoryDtoSet);
            this.productService.save(productAddDto);
        }
    }

    public void export(){
            List<ProductViewDto> productViewDtos = this.productService.findAll();
            this.jsonParser.writeObject(productViewDtos,"src/main/resources/files/out/pr_res.json");
    }

    public void exportProductsNoSeller(){
        List<ProductNoBuyerView> productNoBuyerViews = this.productService.productsNoSeller(null);
        this.jsonParser.writeObject(productNoBuyerViews, "src/main/resources/files/out/products-in-range.json");
    }

    public void exportUserWithSoldProduct(){
        List<UserSoldProducts> userSoldProducts = this.userService.usersWithSoldProducts();
        this.jsonParser.writeObject(userSoldProducts, "src/main/resources/files/out/users-sold-products.json");
    }

    public void exportCategoriesByCountProducts(){
        List<ProductCatView> categories = this.categoryService.CategoriesByProductsCount();
        this.jsonParser.writeObject(categories, "src/main/resources/files/out/categories-by-products.json");
    }

    public void exportUsersAndProducts(){
        CountUserProducts countUserProducts = this.userService.findUserAndProducts4();
        this.jsonParser.writeObject(countUserProducts, "src/main/resources/files/out/users-and-products.json");
    }

    public void importUsersXml(){
        UsersImportXMLDto userAddDtos = null;
        try {
            userAddDtos = this.xmlParser.getObject(UsersImportXMLDto.class, "/files/xml/in/users.xml");
            for (UserAddDto userAddDto : userAddDtos.getUserAddDtos()) {
                this.userService.save(userAddDto);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void importCategoriesXml(){
        CategoriesImporDtoXml categoryAddDtos = null;
        try {
            categoryAddDtos = this.xmlParser.getObject(CategoriesImporDtoXml.class, "/files/xml/in/categories.xml");
            for (CategoryAddDto categoryAddDto : categoryAddDtos.getCategories()) {
                this.categoryService.save(categoryAddDto);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void importProductsXml(){
        Random random = new Random();
        List<UserDto> allUsers = this.userService.findAllUserDtos();
        List<CategoryDto> allCategories = this.categoryService.findAll();
        ProductsImportXmlDto productAddDtos = null;
        try {
            productAddDtos = this.xmlParser.getObject(ProductsImportXmlDto.class, "/files/xml/in/products.xml");

            for (ProductAddDto productAddDto : productAddDtos.getProductAddDtos()) {

                Set<CategoryDto> categoryDtoSet = new HashSet<>();
                UserDto seller = allUsers.get(random.nextInt(allUsers.size()));
                UserDto buyer = allUsers.get(random.nextInt(allUsers.size()));

                if(seller.getId().equals(buyer.getId())){
                    buyer = null;
                }


                for (int i = 0; i <random.nextInt(10) ; i++) {
                    categoryDtoSet.add(allCategories.get(random.nextInt(allCategories.size())));
                }

                productAddDto.setSeller(seller);
                productAddDto.setBuyer(buyer);
                productAddDto.setCategories(categoryDtoSet);
                this.productService.save(productAddDto);
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void exportXml(){
        ProductsExportXmlDto productViewDtos = this.productService.getProductsToExport();

        for (ProductViewDto productViewDto : productViewDtos.getProductViewDtos()) {
            productViewDto.setDate(new Date());
        }
        try {
            this.xmlParser.writeObject(productViewDtos,"src/main/resources/files/xml/out/xml_out.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
