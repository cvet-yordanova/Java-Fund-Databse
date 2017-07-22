package entities;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public abstract class BasicBillingDetail implements BillingDetail{

    private Long id;
    private String number;
    private User owner;

    public BasicBillingDetail(String number, User owner) {
        this.number = number;
        this.owner = owner;
    }

    public BasicBillingDetail() {
    }

    @Override
    @Column(name = "number")
    public String getNumber() {
        return this.number;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    public User getOwner() {
        return this.owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
