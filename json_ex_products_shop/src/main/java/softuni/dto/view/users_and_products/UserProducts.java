package softuni.dto.view.users_and_products;


import com.google.gson.annotations.Expose;
import softuni.dto.view.user_with_sold_products.SoldProduct;

import java.util.HashSet;
import java.util.Set;

public class UserProducts {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private SoldProducts soldProducts;

    public UserProducts() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public SoldProducts getSoldProductsO() {
        return soldProducts;
    }

    public void setSoldProductsO(SoldProducts soldProductsO) {
        this.soldProducts = soldProductsO;
    }
}
