package softuni.dto.view.users_and_products;


import com.google.gson.annotations.Expose;

import java.util.Set;

public class SoldProducts {

    @Expose
    private Integer count;

    @Expose
    private Set<SoldProduct> products;

    public SoldProducts() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<SoldProduct> getSoldProduct4s() {
        return products;
    }

    public void setSoldProduct4s(Set<SoldProduct> soldProducts) {
        this.products = soldProducts;
    }
}
