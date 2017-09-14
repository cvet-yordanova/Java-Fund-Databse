package softuni.dto.view.user_with_sold_products;


import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserSoldProducts {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<SoldProduct> soldProducts;

    public UserSoldProducts() {
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

    public Set<SoldProduct> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProduct> soldProducts) {
        this.soldProducts = soldProducts;
    }

}
