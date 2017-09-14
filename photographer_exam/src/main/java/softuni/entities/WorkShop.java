package softuni.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "workshops")
public class WorkShop {
    private Long id;
    private Date startDate;
    private Date endDate;
    private String location;
    private BigDecimal priceParticipant;
    private Photographer trainer;
    private Set<Photographer> participants;

    public WorkShop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "price_participant")
    public BigDecimal getPriceParticipant() {
        return priceParticipant;
    }

    public void setPriceParticipant(BigDecimal priceParticipant) {
        this.priceParticipant = priceParticipant;
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    public Photographer getTrainer() {
        return trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    @ManyToMany
    public Set<Photographer> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Photographer> participants) {
        this.participants = participants;
    }
}
