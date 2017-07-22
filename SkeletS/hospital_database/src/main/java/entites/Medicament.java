package entites;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicaments")
public class Medicament {
    private String name;

    public Medicament(String name) {
        this.name = name;
    }

    public Medicament() {
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
