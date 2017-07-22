package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BasicBillingDetail> basicBillingDetails;

    public User(String firstName, String lastName, String email, String password, Set<BasicBillingDetail> basicBillingDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.basicBillingDetails = basicBillingDetails;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    public Set<BasicBillingDetail> getBasicBillingDetails() {
        return basicBillingDetails;
    }

    public void setBasicBillingDetails(Set<BasicBillingDetail> basicBillingDetails) {
        this.basicBillingDetails = basicBillingDetails;
    }
}
