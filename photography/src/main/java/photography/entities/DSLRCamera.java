package photography.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DSLR")
public class DSLRCamera extends Camera{

    private int maxShutterSpeed;

    @Column(name = "max_shutter_speed")
    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}
