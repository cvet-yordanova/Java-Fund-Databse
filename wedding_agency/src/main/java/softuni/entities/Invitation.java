package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invitations")
public class Invitation {

    private Long id;

    private Wedding wedding;

    private Person guest;

    private Present present;

    private Boolean attending;

    private Family family;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    public Wedding getWedding() {
        return wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
    }

    @NotNull
    @OneToOne
    @JoinColumn(nullable = false)
    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    @OneToOne
    @JoinColumn(name = "present")
    public Present getPresent() {
        return present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }

    @Column(name = "attending")
    public Boolean getAttending() {
        return attending;
    }

    public void setAttending(Boolean attending) {
        this.attending = attending;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "family", nullable = false)
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

}
