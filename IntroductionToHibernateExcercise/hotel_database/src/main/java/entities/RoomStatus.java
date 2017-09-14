package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_statuses")
public class RoomStatus {

    private String roomStatus;
    private String notes;

    public RoomStatus(String roomStatus, String notes) {
        this.roomStatus = roomStatus;
        this.notes = notes;
    }

    public RoomStatus() {
    }

    @Id
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Column(name = "notes", columnDefinition = "text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
	
	8804fizika
}
