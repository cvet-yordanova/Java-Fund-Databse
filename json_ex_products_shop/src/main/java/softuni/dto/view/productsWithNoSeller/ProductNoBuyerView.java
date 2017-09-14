package softuni.dto.view.productsWithNoSeller;


import com.google.gson.annotations.Expose;
import softuni.entites.User;

import java.math.BigDecimal;

public class ProductNoBuyerView {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private SellerProductNoBuyer seller;

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

    public SellerProductNoBuyer getSeller() {
        return seller;
    }

    public void setSeller(SellerProductNoBuyer seller) {
        this.seller = seller;
    }
}
