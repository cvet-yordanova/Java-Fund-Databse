package softuni.entities;

import softuni.enums.Family;

import javax.persistence.*;

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

    @ManyToOne
    @JoinTable(name = "wedding_id")
    public Wedding getWedding() {
        return wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
    }

   @OneToOne
    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    @OneToOne
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

    @Enumerated(EnumType.STRING)
    @Column(name = "family")
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }



}
