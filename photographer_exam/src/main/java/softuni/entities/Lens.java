package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Table(name = "lenses")
public class Lens {

    private Long id;
    private String make;
    private Integer focalLength;
    private BigDecimal maxAperture;
    private String makeOfCamera;
    private Photographer owner;


    public Lens() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "focal_length")
    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    @Column(name = "max_aperture")
    @Digits(integer = 10 ,fraction = 1)
    public BigDecimal getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(BigDecimal maxAperture) {
        this.maxAperture = maxAperture;
    }

    @Column(name = "make_of_camera")
    public String getMakeOfCamera() {
        return makeOfCamera;
    }

    public void setMakeOfCamera(String makeOfCamera) {
        this.makeOfCamera = makeOfCamera;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
