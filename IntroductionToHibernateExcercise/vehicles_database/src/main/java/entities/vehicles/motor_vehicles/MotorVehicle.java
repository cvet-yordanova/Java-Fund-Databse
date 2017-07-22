package entities.vehicles.motor_vehicles;


import entities.vehicles.VehicleImpl;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "motor_vehicles")
public abstract class MotorVehicle extends VehicleImpl {

    private Integer numberOfEngines;
    private String engineType;
    private Double tankCapacity;

    public MotorVehicle() {
    }

    public MotorVehicle(Long id, String manufacturer, String model, BigDecimal price, Double maxSpeed, Integer numberOfEngines, String engineType, Double tankCapacity) {
        super(id, manufacturer, model, price, maxSpeed);
        this.numberOfEngines = numberOfEngines;
        this.engineType = engineType;
        this.tankCapacity = tankCapacity;
    }

    @Column(name = "number_of_engines")
    public Integer getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(Integer numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    @Column(name = "engine_type")
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Column(name = "tank_capacity")
    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
