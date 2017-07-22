package Model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mint")
@PrimaryKeyJoinColumn(name = "id")
public class Mint extends BasicIngredient{
    public Mint() {
        super("Mint", new BigDecimal("0.34"));
    }
}
