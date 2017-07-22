package entities;


import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "title",discriminatorType = DiscriminatorType.STRING)
public abstract class PersonImpl implements Person{

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public PersonImpl(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public PersonImpl() {
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @Override
    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    @Override
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
