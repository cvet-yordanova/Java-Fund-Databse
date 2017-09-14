package softuni.dto.view.category_by_products_count;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductCatView {

    @Expose
    private String name;
    @Expose
    private Long numberOfProducts;
    @Expose
    private Double averagePriceOfTheProducts;
    @Expose
    private BigDecimal totalRevenue;

    public ProductCatView() {
    }

    public ProductCatView(String name, Long numberOfProducts, Double averagePriceOfTheProducts, BigDecimal totalRevenue) {
        this.name = name;
        this.numberOfProducts = numberOfProducts;
        this.averagePriceOfTheProducts = averagePriceOfTheProducts;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Long numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public Double getAveragePriceOfTheProducts() {
        return averagePriceOfTheProducts;
    }

    public void setAveragePriceOfTheProducts(Double averagePriceOfTheProducts) {
        this.averagePriceOfTheProducts = averagePriceOfTheProducts;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
