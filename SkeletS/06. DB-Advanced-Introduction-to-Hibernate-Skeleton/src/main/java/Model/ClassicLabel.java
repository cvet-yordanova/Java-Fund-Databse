package Model;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class ClassicLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Basic
    private String name;

    public ClassicLabel() {
    }

    public ClassicLabel(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
