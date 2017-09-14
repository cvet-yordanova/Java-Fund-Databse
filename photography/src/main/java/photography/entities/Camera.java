package photography.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_camera")
public abstract class Camera {

    private Long id;

    private String make;

    private String model;

    private Boolean isFullFrame;

    private Integer minISO;

    private Integer maxISO;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "make", nullable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    @Column(name = "models", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "is_full_frame")
    public Boolean getIsFullFrame() {
        return isFullFrame;
    }

    public void setIsFullFrame(Boolean isFullFrame) {
        this.isFullFrame = isFullFrame;
    }

    @NotNull
    @Column(name = "min_ISO", nullable = false)
    @Min(value = 100)
    public Integer getMinISO() {
        return minISO;
    }

    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    @Column(name = "max_ISO")
    public Integer getMaxISO() {
        return maxISO;
    }

    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }

}
