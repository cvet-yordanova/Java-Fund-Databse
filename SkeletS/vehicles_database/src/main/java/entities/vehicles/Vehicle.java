package entities.vehicles;


import java.math.BigDecimal;

public interface Vehicle {
    Long getId();
    String getManufacturer();
    String getModel();
    BigDecimal getPrice();
    Double getMaxSpeed();
}
