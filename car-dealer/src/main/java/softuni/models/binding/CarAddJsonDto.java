package softuni.models.binding;


import com.google.gson.annotations.Expose;

import java.math.BigInteger;

public class CarAddJsonDto {

    @Expose
    private BigInteger travelledDistance;

    @Expose
    private String make;

    @Expose
    private String model;

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
}
