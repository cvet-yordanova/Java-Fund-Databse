package entites;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation {
    private Long id;
    private LocalDate date;
    private String comments;

    public Visitation(Long id,LocalDate date, String comments) {
        this.id = id;
        this.date = date;
        this.comments = comments;
    }

    public Visitation() {
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "visitation_date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
