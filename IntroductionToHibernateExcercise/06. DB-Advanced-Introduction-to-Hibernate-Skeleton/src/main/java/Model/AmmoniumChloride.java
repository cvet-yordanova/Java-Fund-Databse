package Model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ammonium_chloride")
@PrimaryKeyJoinColumn(name = "id")
public class AmmoniumChloride extends BasicChemicalIngredient{
    public AmmoniumChloride() {
        super("Ammonium Chloride",new BigDecimal("0.34"),"AM4CL");
    }
}
