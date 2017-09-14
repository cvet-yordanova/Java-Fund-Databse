package softuni.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers1")
public class Supplier1 {

    private Long id;
    private String name;
    private Boolean usesImportedParts;
    private Set<Part> parts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "uses_imported_parts")
    public Boolean getUsesImportedParts() {
        return usesImportedParts;
    }

    public void setUsesImportedParts(Boolean usesImportedParts) {
        this.usesImportedParts = usesImportedParts;
    }

    @OneToMany
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
