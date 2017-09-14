package softuni.models.binding.ImportWeddingJson;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Agency;

import java.util.Date;
import java.util.List;

public class ImportWeddingJson {


    @Expose
    private String Bride;
    @Expose
    private String Bridegroom;
    @Expose
    @SerializedName(value = "Date")
    private Date date;
    @Expose
    private String Agency;
    @Expose
    private List<Guest> Guests;

    public String getBride() {
        return Bride;
    }

    public void setBride(String bride) {
        Bride = bride;
    }

    public String getBridegroom() {
        return Bridegroom;
    }

    public void setBridegroom(String bridegroom) {
        Bridegroom = bridegroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String agency) {
        Agency = agency;
    }

    public List<Guest> getGuests() {
        return Guests;
    }

    public void setGuests(List<Guest> guests) {
        Guests = guests;
    }
}
