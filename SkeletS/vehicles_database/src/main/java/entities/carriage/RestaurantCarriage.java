package entities.carriage;


import entities.carriage.CarriageImpl;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "restaurant_carriages")
@DiscriminatorValue(value = "restaurant_carriage")
public class RestaurantCarriage extends CarriageImpl {
    private Integer tablesCount;

    public RestaurantCarriage() {
    }

    public RestaurantCarriage(Long id, Integer tablesCount) {
        super(id);
        this.tablesCount = tablesCount;
    }

    @Column(name = "tables_count")
    public Integer getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(Integer tablesCount) {
        this.tablesCount = tablesCount;
    }
}
