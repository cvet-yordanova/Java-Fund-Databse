package entities.vehicles.non_motor_vehicle;

import entities.vehicles.VehicleImpl;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "non_motor_vehicles")
public abstract class NonMotorVehicle extends VehicleImpl {
    public NonMotorVehicle(Long id, String manufacturer, String model, BigDecimal price, Double maxSpeed) {
        super(id, manufacturer, model, price, maxSpeed);
    }

    public NonMotorVehicle() {
    }
}
