package photography.dto.export_landscape_photographers_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import photography.entities.Lens;

import java.util.List;

public class ExportLandscapePhotographesJsonDto {

    @Expose
    @SerializedName(value = "FirstName")
    private String firstName;
    @Expose
    @SerializedName(value = "LastName")
    private String lastName;
    @Expose
    @SerializedName(value = "CameraMake")
    private String primaryCameraMake;
    private List<Lens> lenses;
    @Expose
    @SerializedName(value = "LensesCount")
    private Integer lensesCount;

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

    public String getPrimaryCameraMake() {
        return primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    public Integer getLensesCount() {
        return lensesCount;
    }

    public void setLensesCount(Integer lensesCount) {
        this.lensesCount = lensesCount;
    }
}
