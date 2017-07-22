package entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    private String name;
    private String comments;

    public Diagnose() {
    }

    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comments",columnDefinition = "text")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
