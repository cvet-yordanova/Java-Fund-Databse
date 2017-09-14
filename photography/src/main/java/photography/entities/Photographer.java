package photography.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "photographers")
public class Photographer {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private Camera primaryCamera;

    private Camera secondaryCamera;

    private List<Lens> lenses;

    private List<Accessory> accessories;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "last_name", nullable = false)
    @Length(min = 2, max = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToOne
    @JoinColumn(name = "primary_camera_id", nullable = false, unique = true)
    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "secondary_camera_id", nullable = false, unique = true)
    public Camera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.MERGE)
    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    @OneToMany(mappedBy = "owner")
    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

}
