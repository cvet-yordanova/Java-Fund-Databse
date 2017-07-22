package entities.vehicles.motor_vehicles;


import entities.vehicles.motor_vehicles.MotorVehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends MotorVehicle {
    private String airlineOwner;
    private String color;
    private Integer passengersCapacity;

    public Plane() {
    }

    public Plane(Long id, String manufacturer,
                 String model, BigDecimal price, Double maxSpeed, Integer numberOfEngines, String engineType, Double tankCapacity, String airlineOwner, String color, Integer passengersCapacity) {
        super(id, manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.airlineOwner = airlineOwner;
        this.color = color;
        this.passengersCapacity = passengersCapacity;
    }

    @Column(name = "airline_owner")
    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "passengers_capacity")
    public Integer getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(Integer passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}
