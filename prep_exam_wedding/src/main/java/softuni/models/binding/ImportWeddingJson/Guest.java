package softuni.models.binding.ImportWeddingJson;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Person;
import softuni.entities.Present;
import softuni.enums.Family;

public class Guest {

    private String firstName;

    private String middleNameInitial;

    private String lastName;

    @Expose
    @SerializedName(value = "Name")
    private String importName;

    @Expose
    @SerializedName(value = "RSVP")
    private Boolean attending;

    @Expose
    @SerializedName(value = "Family")
    private Family family;


    public String getFirstName() {
        return getNames()[0];
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNameInitial() {
        return getNames()[1];
    }

    public void setMiddleNameInitial(String middleNameInitial) {
        this.middleNameInitial = middleNameInitial;
    }

    public String getLastName() {
        return getNames()[2];
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getNames(){
        return importName.split("\\s+");
    }

    public String getImportName() {
        return importName;
    }

    public void setImportName(String importName) {
        this.importName = importName;
    }

    public Boolean getAttending() {
        return attending;
    }

    public void setAttending(Boolean attending) {
        this.attending = attending;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
