package entities.vehicles.non_motor_vehicle;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike extends NonMotorVehicle {
    private Integer shiftsCount;
    private String color;

    public Bike(Long id, String manufacturer, String model, BigDecimal price, Double maxSpeed, Integer shiftsCount, String color) {
        super(id, manufacturer, model, price, maxSpeed);
        this.shiftsCount = shiftsCount;
        this.color = color;
    }

    public Bike() {
    }

    @Column(name = "shifts_count")
    public Integer getShiftsCount() {
        return shiftsCount;
    }

    public void setShiftsCount(Integer shiftsCount) {
        this.shiftsCount = shiftsCount;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
