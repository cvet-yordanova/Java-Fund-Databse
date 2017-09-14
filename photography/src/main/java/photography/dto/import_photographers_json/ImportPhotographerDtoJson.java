package photography.dto.import_photographers_json;


import com.google.gson.annotations.Expose;
import photography.entities.Camera;
import photography.entities.Lens;

import java.util.List;

public class ImportPhotographerDtoJson {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;
    @Expose
    private Camera primaryCamera;
    @Expose
    private Camera secondaryCamera;
    @Expose
    private Long[] lenses;

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

    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public Camera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Long[] getLensesIds() {
        return lenses;
    }

    public void setLensesIds(Long[] lensesIds) {
        this.lenses = lensesIds;
    }
}
