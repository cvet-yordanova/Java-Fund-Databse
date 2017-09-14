package softuni.entities;


import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "people")
public class Person {

    private Long id;

    private String firstName;

    private String middleNameInitial;

    private String lastName;

    private Gender gender;

    private Date birthDate;

    private String phone;

    private String email;

    private String fullName;

    private int age;

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
    @Size(min = 1, max = 60)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "middle_name_initial")
    public String getMiddleNameInitial() {
        return middleNameInitial;
    }

    public void setMiddleNameInitial(String middleNameInitial) {
        this.middleNameInitial = middleNameInitial;
    }

    @NotNull
    @Size(min = 2)
    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Column(name = "birthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    @Transient
    public String getFullName() {
        return firstName+" "+middleNameInitial+" "+lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = firstName+" "+middleNameInitial+" "+lastName;
    }

    @Transient
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
