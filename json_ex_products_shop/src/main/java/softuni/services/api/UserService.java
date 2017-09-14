package softuni.services.api;


import softuni.dto.binding.UserDto;
import softuni.dto.binding.add.UserAddDto;
import softuni.dto.view.user_with_sold_products.UserSoldProducts;
import softuni.dto.view.users_and_products.CountUserProducts;
import softuni.dto.view.users_and_products.UserProducts;

import java.util.List;

public interface UserService {
    void save(UserAddDto userAddDto);
    List<UserDto> findAllUserDtos();
    List<UserSoldProducts> usersWithSoldProducts();
    CountUserProducts findUserAndProducts4();

}
