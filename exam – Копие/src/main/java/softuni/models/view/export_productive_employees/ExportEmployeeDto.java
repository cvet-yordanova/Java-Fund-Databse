package softuni.models.view.export_productive_employees;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.EmployeeCard;

import javax.persistence.Transient;

public class ExportEmployeeDto {

    private String firstName;

    private String lastName;

    @Expose
    private String position;

    private CardExportPrEmployee card;

    @Expose
    @SerializedName(value = "full_name")
    private String fullName;

    @Expose
    @SerializedName(value = "number")
    private String number;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public CardExportPrEmployee getCard() {
        return card;
    }

    public void setCard(CardExportPrEmployee card) {
        this.card = card;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public String getNumber() {
        return card.getNumber();
    }
}
