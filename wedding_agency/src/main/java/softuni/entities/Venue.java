package softuni.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "venues")
public class Venue {

    private Long id;

    private String name;

    private Integer capacity;

    private String town;

    private List<Wedding> weddings;

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

    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Column(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @ManyToMany
    @JoinTable(name = "venues_weddings",joinColumns =
    @JoinColumn(name = "venue", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "wedding",referencedColumnName = "id"))
    public List<Wedding> getWeddings() {
        return weddings;
    }

    public void setWeddings(List<Wedding> weddings) {
        this.weddings = weddings;
    }
}
