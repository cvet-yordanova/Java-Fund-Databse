package entities.vehicles.motor_vehicles;


import entities.carriage.CarriageImpl;
import entities.vehicles.locomotive.Locomotive;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Train extends MotorVehicle {

    private Locomotive locomotive;
    private Integer numberOfCarriages;
    List<CarriageImpl> carriages;

    public Train(Long id, String manufacturer,
                 String model, BigDecimal price, Double maxSpeed,
                 Integer numberOfEngines, String engineType, Double tankCapacity,
                 Locomotive locomotive, Integer numberOfCarriages, List<CarriageImpl> carriages) {
        super(id, manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.locomotive = locomotive;
        this.numberOfCarriages = numberOfCarriages;
        this.carriages = carriages;
    }

    public Train() {
    }

    @OneToOne
    @JoinColumn(name = "locomotive_id")
    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Column(name = "number_of_carriages")
    public Integer getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(Integer numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    @OneToMany
    public List<CarriageImpl> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<CarriageImpl> carriages) {
        this.carriages = carriages;
    }
}
