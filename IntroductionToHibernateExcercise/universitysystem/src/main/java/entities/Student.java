package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
//@DiscriminatorValue(value = "student")
//@Table(name = "students")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends PersonImpl{

    private Double averageGrade;
    private Double attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column(name = "attendance")
    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
