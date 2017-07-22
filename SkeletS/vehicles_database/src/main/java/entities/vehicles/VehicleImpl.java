package entities.vehicles;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VehicleImpl implements Vehicle{
    private Long Id;
    private String manufacturer;
    private String model;
    private BigDecimal price;
    private Double maxSpeed;

    public VehicleImpl() {
    }

    public VehicleImpl(Long id, String manufacturer, String model, BigDecimal price, Double maxSpeed) {
        Id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return this.Id;
    }

    @Override
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    @Column(name = "model")
    public String getModel() {
        return this.model;
    }

    @Override
    @Column(name = "price")
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    @Column(name = "max_speed")
    public Double getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
