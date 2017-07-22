package entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.validation.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import static javax.swing.text.StyleConstants.Size;

@Entity
@Table(name = "patients")
public class Patient {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Date dateOfBirth;
    private String picture;
    private Boolean hasInsurance;
    Set<Visitation> visitation;
    Set<Diagnose> diagnoses;
    Set<Medicament> prescribedMedicaments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, Date dateOfBirth, String picture, Boolean hasInsurance, Set<Visitation> visitation, Set<Diagnose> diagnoses, Set<Medicament> prescribedMedicaments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.hasInsurance = hasInsurance;
        this.visitation = visitation;
        this.diagnoses = diagnoses;
        this.prescribedMedicaments = prescribedMedicaments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    @Size(min = 2, max = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    @Size(min = 1, max = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    @Past
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name = "has_ensurance")
    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(Boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @OneToMany
    public Set<Visitation> getVisitation() {
        return visitation;
    }

    public void setVisitation(Set<Visitation> visitation) {
        this.visitation = visitation;
    }

    @ManyToMany
    @JoinTable(name = "patient_diagnoses")
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany
    @JoinTable(name = "patient_medicaments")
    public Set<Medicament> getPrescribedMedicaments() {
        return prescribedMedicaments;
    }

    public void setPrescribedMedicaments(Set<Medicament> prescribedMedicaments) {
        this.prescribedMedicaments = prescribedMedicaments;
    }
}
