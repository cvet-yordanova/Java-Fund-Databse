package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "gift")
public class Gift extends Present{

    private String name;

    private Size size;

    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
