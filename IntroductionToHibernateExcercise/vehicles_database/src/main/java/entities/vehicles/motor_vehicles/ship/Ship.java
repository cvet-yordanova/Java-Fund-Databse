package entities.vehicles.motor_vehicles.ship;


import entities.vehicles.motor_vehicles.MotorVehicle;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public abstract class Ship extends MotorVehicle {
    private String nationality;
    private String captainName;
    private Integer sizeOfShipCrew;

    public Ship() {
    }

    public Ship(Long id, String manufacturer,
                String model, BigDecimal price, Double maxSpeed,
                Integer numberOfEngines, String engineType,
                Double tankCapacity, String nationality,
                String captainName, Integer sizeOfShipCrew) {
        super(id, manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.nationality = nationality;
        this.captainName = captainName;
        this.sizeOfShipCrew = sizeOfShipCrew;
    }

    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "captain_name")
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Column(name = "size_of_ship")
    public Integer getSizeOfShipCrew() {
        return sizeOfShipCrew;
    }

    public void setSizeOfShipCrew(Integer sizeOfShipCrew) {
        this.sizeOfShipCrew = sizeOfShipCrew;
    }
}
