package photography.dto.export_photographers_ordered_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExportPhotographerJson {

    @Expose
    @SerializedName(value = "FirstName")
    private String firstName;
    @Expose
    @SerializedName(value = "LastName")
    private String lastName;
    @Expose
    @SerializedName(value = "Phone")
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
