package Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chemical_ingredient")
@PrimaryKeyJoinColumn(name = "id")
public abstract class BasicChemicalIngredient extends BasicIngredient{
    @Column(name = "chemical_formula")
    private String chemicalFormula;

    public BasicChemicalIngredient() {
    }

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
