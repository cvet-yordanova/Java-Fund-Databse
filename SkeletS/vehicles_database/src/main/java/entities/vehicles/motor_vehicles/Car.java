package entities.vehicles.motor_vehicles;


import entities.vehicles.motor_vehicles.MotorVehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends MotorVehicle {

    private Integer numberOfDoors;
    private Boolean hasInsurance;

    public Car() {
    }

    public Car(Long id, String manufacturer, String model,
               BigDecimal price, Double maxSpeed, Integer numberOfEngines, String engineType, Double tankCapacity, Integer numberOfDoors, Boolean hasInsurance) {
        super(id, manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.numberOfDoors = numberOfDoors;
        this.hasInsurance = hasInsurance;
    }

    @Column(name = "number_of_doors")
    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Column(name = "has_insurance")
    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(Boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
