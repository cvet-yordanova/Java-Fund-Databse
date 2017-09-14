package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dslr_cameras")
public class DSLRCamera extends Camera{

    private Integer maxShutterSpeed;

    public DSLRCamera() {
    }

    public DSLRCamera(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    @Column(name = "max_shutter_speed")
    public Integer getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}
