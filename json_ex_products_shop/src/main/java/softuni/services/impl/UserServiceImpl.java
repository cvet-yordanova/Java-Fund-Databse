package softuni.services.impl;

import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.binding.UserDto;
import softuni.dto.binding.add.UserAddDto;
import softuni.dto.view.user_with_sold_products.SoldProduct;
import softuni.dto.view.user_with_sold_products.UserSoldProducts;
import softuni.dto.view.users_and_products.CountUserProducts;
import softuni.dto.view.users_and_products.SoldProducts;
import softuni.dto.view.users_and_products.UserProducts;
import softuni.entites.Product;
import softuni.entites.User;
import softuni.io.ModelParser;
import softuni.repositories.UserRepository;
import softuni.services.api.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserAddDto userAddDto) {
        User user = ModelParser.getInstance().map(userAddDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserDto> findAllUserDtos() {

        List<User> allUsers = this.userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : allUsers) {
            UserDto userDto = ModelParser.getInstance().map(user, UserDto.class);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public List<UserSoldProducts> usersWithSoldProducts() {
        List<User> usersWithSoldProducts = this.userRepository.findUsersWithSoldProducts();
        List<UserSoldProducts> userSoldProducts = new ArrayList<>();

        for (User user : usersWithSoldProducts) {
            UserSoldProducts userS = ModelParser.getInstance().map(user, UserSoldProducts.class);
            userSoldProducts.add(userS);
        }
        return userSoldProducts;
    }

    @Override
    public CountUserProducts findUserAndProducts4() {
        List<User> UserWithSoldProductsOrder = this.userRepository.findUserWithSoldProductsOrder();
        List<UserProducts> userProductsList = new ArrayList<>();

        for (User user : UserWithSoldProductsOrder) {
            UserProducts userProducts = ModelParser.getInstance().map(user, UserProducts.class);

            Set<softuni.dto.view.users_and_products.SoldProduct> soldProducts = new HashSet<>();
            for (Product product : user.getSoldProducts()) {
                softuni.dto.view.users_and_products.SoldProduct soldProduct = ModelParser.getInstance().map(product, softuni.dto.view.users_and_products.SoldProduct.class);
                soldProducts.add(soldProduct);
            }
            userProducts.setSoldProductsO(new SoldProducts());
            userProducts.getSoldProductsO().setSoldProduct4s(soldProducts);
            userProducts.getSoldProductsO().setCount(soldProducts.size());
            userProductsList.add(userProducts);
        }

        CountUserProducts countUserProducts = new CountUserProducts();
        countUserProducts.setUsersCount(userProductsList.size());
        countUserProducts.setUsers(userProductsList);

        return countUserProducts;


    }
}
