package entities.carriage;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "sleeping_carriages")
@DiscriminatorValue(value = "sleeping_carriage")
public class SleepingCarriage extends CarriageImpl {

    private Integer bedsCount;

    public SleepingCarriage() {
    }

    public SleepingCarriage(Long id, Integer bedsCount) {
        super(id);
        this.bedsCount = bedsCount;
    }

    @Column(name = "beds_count")
    public Integer getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }


}
