package entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String notes;

    public Employee(String firstName, String lastName, String title, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.notes = notes;
    }

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
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

    @Column(name = "title",length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "notes", columnDefinition = "text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
