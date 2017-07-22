package entities.vehicles.locomotive;


import javax.persistence.*;

@Entity
@Table(name = "locomotives")
public class Locomotive {
    private Long id;
    private String model;
    private Double power;

    public Locomotive() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "power")
    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
}
