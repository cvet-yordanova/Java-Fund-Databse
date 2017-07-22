package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_types")
public class RoomType {

    private String roomType;
    private String notes;

    public RoomType(String roomType, String notes) {
        this.roomType = roomType;
        this.notes = notes;
    }

    public RoomType() {
    }

    @Id
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Column(name = "notes", columnDefinition = "text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
