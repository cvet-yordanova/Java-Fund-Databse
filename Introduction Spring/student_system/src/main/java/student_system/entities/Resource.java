package student_system.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {
    private Long id;
    private String name;
    private String typeResource;
    private String URL;
    private Course course;
    private List<License> licenses;

    public Resource() {
    }

    public Resource(String name, String typeResource, String URL, Course course) {
        this.name = name;
        this.typeResource = typeResource;
        this.URL = URL;
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "resourceType")
    public String getTypeResource() {
        return typeResource;
    }

    public void setTypeResource(String typeResource) {
        this.typeResource = typeResource;
    }

    @Column(name = "URL")
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany
    @JoinTable(name = "resources_licenses")
    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeResource='" + typeResource + '\'' +
                ", URL='" + URL + '\'' +
                ", course=" + course.getName() +
                '}';
    }
}
