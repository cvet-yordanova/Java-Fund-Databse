package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bed_Types")
public class BedType {

    private String bedType;
    private String notes;

    public BedType(String bedType, String notes) {
        this.bedType = bedType;
        this.notes = notes;
    }

    public BedType() {
    }

    @Id
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Column(name = "notes", columnDefinition = "text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
