package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    private Long id;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer credits;
    private Set<Student> students;
    private Teacher teacher;

    public Course(String description, Date startDate, Date endDate, Integer credits, Set<Student> students, Teacher teacher) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.credits = credits;
        this.students = students;
        this.teacher = teacher;
    }

    public Course() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Column(name = "credits")
    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @ManyToMany
    @JoinTable(name = "courses_students",
    joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne
    @JoinColumn(name = "teacher",referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
