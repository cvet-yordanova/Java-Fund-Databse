package softuni.dto.import_weddings_and_invitaions_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Person;

import java.util.Date;

public class ImportWeddingJsonDto {

    @Expose
    @SerializedName(value = "Bride")
    private String bride;

    @Expose
    @SerializedName(value = "Bridegroom")
    private String bridegroom;

    @Expose
    @SerializedName(value = "Date")
    private Date date;

    @Expose
    @SerializedName(value = "Agency")
    private String agency;

    @Expose
    @SerializedName(value = "Guests")
    private ImportInvitaionJsonDto[] guests;

    public String getBride() {
        return bride;
    }

    public void setBride(String bride) {
        this.bride = bride;
    }

    public String getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(String bridegroom) {
        this.bridegroom = bridegroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public ImportInvitaionJsonDto[] getGuests() {
        return guests;
    }

    public void setGuests(ImportInvitaionJsonDto[] guests) {
        this.guests = guests;
    }
}
