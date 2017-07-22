package entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    private Long accountNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyNumber;
    private String notes;

    public Customer(Long accountNumber,String firstName, String lastName, String phoneNumber, String emergencyName, String emergencyNumber, String notes) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
        this.notes = notes;
    }

    public Customer() {
    }

    @Id
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "first_name", length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number", length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "emergency_name", length = 50)
    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    @Column(name = "emergency_number", length = 20)
    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    @Column(name = "notes", columnDefinition = "text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
