package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "weddings")
public class Wedding {

    private Long id;

    private Person bride;

    private Person bridegroom;

    private Date date;

    private Agency agency;

    List<Invitation> invitations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, name = "bride")
    public Person getBride() {
        return bride;
    }

    public void setBride(Person bride) {
        this.bride = bride;
    }

    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, name = "bridegroom")
    public Person getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(Person bridegroom) {
        this.bridegroom = bridegroom;
    }

    @NotNull
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "agency")
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @OneToMany(mappedBy = "wedding", cascade = CascadeType.PERSIST)
    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }
}
