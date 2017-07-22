package Model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "strawberry")
@PrimaryKeyJoinColumn(name = "id")
public class Strawberry extends BasicIngredient{
    public Strawberry() {
        super("Strawberry", new BigDecimal("0.22"));
    }
}
