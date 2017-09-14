package softuni.models.view_models;


import com.google.gson.annotations.Expose;
import softuni.entities.Part;

import java.math.BigInteger;
import java.util.Set;

public class CarViewDto {
    @Expose
    private BigInteger travelledDistance;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Set<PartViewDto> parts;

    public BigInteger getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<PartViewDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartViewDto> parts) {
        this.parts = parts;
    }
}
