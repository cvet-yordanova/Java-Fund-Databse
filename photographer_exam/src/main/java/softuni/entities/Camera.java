package softuni.entities;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public abstract class Camera {

    private Long id;
    private String make;
    private String model;
    private Boolean isFullFrame;
    private Integer minISO;
    private Integer maxISO;
    private Integer maxShutterSpeed;


    public Camera() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "make", nullable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "is_full_frame")
    public Boolean getFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(Boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    @Column(name = "min_ISO", nullable = false)
    @Size(min = 100)
    public Integer getMinISO() {
        return minISO;
    }
    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    @Column(name = "maxISO")
    public Integer getMaxISO() {
        return maxISO;
    }

    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }

    @Column(name = "max_shutter_speed")
    public Integer getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

}
