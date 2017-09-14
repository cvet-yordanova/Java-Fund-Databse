package softuni.dto.import_weddings_and_invitaions_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Family;
import softuni.entities.Person;
import softuni.entities.Present;

public class ImportInvitaionJsonDto {

    private Person guest;

    @Expose
    @SerializedName(value = "Name")
    private String name;

    @Expose
    @SerializedName(value = "RSVP")
    private Boolean attending;

    @Expose
    @SerializedName(value = "Family")
    private String family;

    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAttending() {
        return attending;
    }

    public void setAttending(Boolean attending) {
        this.attending = attending;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

}
