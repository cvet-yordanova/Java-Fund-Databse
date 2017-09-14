package softuni.dto.view.users_and_products;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SoldProduct {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public SoldProduct() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
