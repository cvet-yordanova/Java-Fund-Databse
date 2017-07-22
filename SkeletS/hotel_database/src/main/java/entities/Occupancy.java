package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "occupancies")
public class Occupancy {

    private Long id;
    private LocalDate dateOccupied;
    private Customer accountNumber;
    private Room roomNumber;
    private BigDecimal rateApplied;
    private BigDecimal phoneCharge;
    private String notes;

    public Occupancy() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date_occupied")
    public LocalDate getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(LocalDate dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @OneToOne
    @JoinColumn(name = "account_number")
    public Customer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Customer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @OneToOne
    @JoinColumn(name = "room_number")
    public Room getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Room roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "rate_applied")
    public BigDecimal getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(BigDecimal rateApplied) {
        this.rateApplied = rateApplied;
    }

    @Column(name = "phone_charge")
    public BigDecimal getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(BigDecimal phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
