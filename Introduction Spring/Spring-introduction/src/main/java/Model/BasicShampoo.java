package Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shampoo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BasicShampoo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "label_id")
    private ClassicLabel label;

    @ManyToOne(optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "batch_id")
    private ProductionBatch productionBatch;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shampoos_ingredients",
    joinColumns = @JoinColumn(name = "shampoo_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"),
    foreignKey = @ForeignKey(name = "fk_shampoos_ingredients_shapoos"),
    inverseForeignKey = @ForeignKey(name = "fk_shampoos_ingredients_ingredients"))
    private Set<BasicIngredient> basicIngredients;


    public Long getId() {
        return id;
    }

    public Set<BasicIngredient> getIngredients() {
        return basicIngredients;
    }

    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.basicIngredients = ingredients;
    }

    public ProductionBatch getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(ProductionBatch productionBatch) {
        this.productionBatch = productionBatch;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassicLabel getLabel() {
        return label;
    }

    public void setLabel(ClassicLabel label) {
        this.label = label;
    }
}
