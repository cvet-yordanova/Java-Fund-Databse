package entities.vehicles.motor_vehicles.ship;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cargo_ships")
public class CargoShip extends Ship {
    private Double maxLoadKilometers;

    public CargoShip() {
    }

    public CargoShip(Long id, String manufacturer,
                     String model, BigDecimal price,
                     Double maxSpeed, Integer numberOfEngines,
                     String engineType, Double tankCapacity,
                     String nationality, String captainName,
                     Integer sizeOfShipCrew, Double maxLoadKilometers) {
        super(id, manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity, nationality, captainName, sizeOfShipCrew);
        this.maxLoadKilometers = maxLoadKilometers;
    }

    @Column(name = "max_load_kilometers")
    public Double getMaxLoadKilometers() {
        return maxLoadKilometers;
    }

    public void setMaxLoadKilometers(Double maxLoadKilometers) {
        this.maxLoadKilometers = maxLoadKilometers;
    }
}
