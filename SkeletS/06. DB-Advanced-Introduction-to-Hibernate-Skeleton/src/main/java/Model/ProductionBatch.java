package Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ProductionBatch")
public class ProductionBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "productionBatch")
    private Set<BasicShampoo> shampoos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
