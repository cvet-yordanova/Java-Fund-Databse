package Model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "basicIngredients")
    private Set<BasicShampoo> shampoos;

    public BasicIngredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }

    public BasicIngredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
