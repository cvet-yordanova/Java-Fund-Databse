package entities;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    private Integer roomNumber;
    private RoomType roomType;
    private BedType bedType;
    private Float rate;
    private RoomStatus roomStatus;
    private String notes;

    public Room(Integer roomNumber, RoomType roomType, BedType bedType, Float rate, RoomStatus roomStatus, String notes) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.rate = rate;
        this.roomStatus = roomStatus;
        this.notes = notes;
    }

    public Room() {
    }

    @Id
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "room_type")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @ManyToOne
    @JoinColumn(name = "bed_type")
    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    @Column(name = "rate")
    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @ManyToOne
    @JoinColumn(name = "room_status")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
