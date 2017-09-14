package student_system.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private List<Student> students;
    private List<Resource> resources;
    private List<Homework> homeworkSubmissions;

    public Course() {
    }

    public Course(String name, String description, Date startDate, Date endDate, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.students = new ArrayList<>();
        this.resources = new ArrayList<>();
        this.homeworkSubmissions = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name  = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "startDate", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "endDate", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course")
    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @OneToMany(mappedBy = "course")
    public List<Homework> getHomeworkSubmissions() {
        return homeworkSubmissions;
    }

    public void setHomeworkSubmissions(List<Homework> homeworkSubmissions) {
        this.homeworkSubmissions = homeworkSubmissions;
    }
}
