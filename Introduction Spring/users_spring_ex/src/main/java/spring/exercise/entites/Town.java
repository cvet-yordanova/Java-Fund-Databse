package spring.exercise.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town {
    private Long id;
    private String name;
    private String country;
    private List<User> usersBornHere;
    private List<User> usersLivingHere;

    public Town() {
    }

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

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @OneToMany(mappedBy = "bornTown")
    public List<User> getUsersBornHere() {
        return usersBornHere;
    }

    public void setUsersBornHere(List<User> usersBornHere) {
        this.usersBornHere = usersBornHere;
    }


    @OneToMany(mappedBy = "currentlyLivingInTown")
    public List<User> getUsersLivingHere() {
        return usersLivingHere;
    }

    public void setUsersLivingHere(List<User> usersLivingHere) {
        this.usersLivingHere = usersLivingHere;
    }
}
