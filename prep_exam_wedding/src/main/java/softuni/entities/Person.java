package softuni.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;
import softuni.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {
    private Long id;

    private String firstName;

    private String middleNameInitial;

    private String lastName;

    private String fullName;

    private Gender gender;

    private LocalDate birthDate;

    private Integer age;

    private String phone;

    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "first_name", nullable = false)
    @Length(min = 1, max = 60)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "middle_name_initial", nullable = false)
    @Length(min = 1, max = 1)
    public String getMiddleNameInitial() {
        return middleNameInitial;
    }

    public void setMiddleNameInitial(String middleNameInitial) {
        this.middleNameInitial = middleNameInitial;
    }

    @NotNull
    @Column(name = "last_name", nullable = false)
    @Length(min = 2)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "gender", nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "birthdate")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return 12 ;//Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
