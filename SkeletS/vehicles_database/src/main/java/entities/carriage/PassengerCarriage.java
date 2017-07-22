package entities.carriage;


import entities.carriage.CarriageImpl;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "passenger_carriages")
@DiscriminatorValue(value = "passenger_carriage")
public class PassengerCarriage extends CarriageImpl {

    private Integer standingPassengersCapacity;

    public PassengerCarriage() {
    }

    public PassengerCarriage(Long id, Integer standingPassengersCapacity) {
        super(id);
        this.standingPassengersCapacity = standingPassengersCapacity;
    }

    @Column(name = "passengers_capacity")
    public Integer getStandingPassengersCapacity() {
        return standingPassengersCapacity;
    }

    public void setStandingPassengersCapacity(Integer standingPassengersCapacity) {
        this.standingPassengersCapacity = standingPassengersCapacity;
    }
}
