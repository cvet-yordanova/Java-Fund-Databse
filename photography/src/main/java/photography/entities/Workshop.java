package photography.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workshops")
public class Workshop {

    private Long id;

    private String name;

    private Date startDate;

    private Date endDate;

    private String location;

    private BigDecimal pricePerParticipant;

    private Photographer trainer;

    private List<Photographer> participants;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @NotNull
    @Column(name = "location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NotNull
    @Column(name = "price_per_participant", nullable = false)
    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    public Photographer getTrainer() {
        return trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    @ManyToMany
    @JoinTable(name = "workshops_participants",
    joinColumns = @JoinColumn(name = "workshop_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "participant_id",referencedColumnName = "id"))
    public List<Photographer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Photographer> participant) {
        this.participants = participant;
    }
}
