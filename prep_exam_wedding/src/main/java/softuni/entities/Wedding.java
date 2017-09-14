package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "weddings")
public class Wedding {
    private Long id;

    private Person bride;

    private Person brideGroom;

    private Date date;

    private Agency agency;

    private Set<Venue> venues;

    private Set<Invitation> invitations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @OneToOne()
    public Person getBride() {
        return bride;
    }

    public void setBride(Person bride) {
        this.bride = bride;
    }

    @NotNull
    @OneToOne
    public Person getBrideGroom() {
        return brideGroom;
    }

    public void setBrideGroom(Person brideGroom) {
        this.brideGroom = brideGroom;
    }

    @NotNull
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "agency_id")
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "wedding_venues",
    joinColumns = @JoinColumn(name = "wedding_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "venue_id",referencedColumnName = "id"))
    public Set<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(Set<Invitation> invitations) {
        this.invitations = invitations;
    }
}
