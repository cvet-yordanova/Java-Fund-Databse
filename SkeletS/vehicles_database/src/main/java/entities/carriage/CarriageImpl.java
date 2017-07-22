package entities.carriage;


import entities.carriage.Carriage;

import javax.persistence.*;

@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CARRIAGE")
public abstract class CarriageImpl implements Carriage {

    private Long id;

    public CarriageImpl(Long id) {
        this.id = id;
    }

    public CarriageImpl() {
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
