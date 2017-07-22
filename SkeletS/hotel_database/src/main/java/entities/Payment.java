package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {
    private Long id;
    private LocalDate paymentDate;
    private Customer accountNumber;
    private LocalDate firstDateOccupied;
    private LocalDate lastDateOccupied;
    private Integer totalDays;
    private BigDecimal amountCharged;
    private Float taxRate;
    private BigDecimal taxAmount;
    private BigDecimal paymentTotal;
    private String notes;

    public Payment(LocalDate paymentDate, Customer accountNumber, LocalDate firstDateOccupied, LocalDate lastDateOccupied, Integer totalDays, BigDecimal amountCharged, Float taxRate, BigDecimal taxAmount, BigDecimal paymentTotal, String notes) {
        this.paymentDate = paymentDate;
        this.accountNumber = accountNumber;
        this.firstDateOccupied = firstDateOccupied;
        this.lastDateOccupied = lastDateOccupied;
        this.totalDays = totalDays;
        this.amountCharged = amountCharged;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.paymentTotal = paymentTotal;
        this.notes = notes;
    }

    public Payment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "payment_date")
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @ManyToOne
    @JoinColumn(name = "account_number")
    public Customer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Customer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "first_date_occupied")
    public LocalDate getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(LocalDate firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    @Column(name = "last_date_occupied")
    public LocalDate getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(LocalDate lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    @Column(name = "total_days")
    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    @Column(name = "amount_charged")
    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(BigDecimal amountCharged) {
        this.amountCharged = amountCharged;
    }

    @Column(name = "tax_rate")
    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    @Column(name = "tax_amount")
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Column(name = "total_payment")
    public BigDecimal getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(BigDecimal paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    @Column(name = "notes",columnDefinition = "text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
