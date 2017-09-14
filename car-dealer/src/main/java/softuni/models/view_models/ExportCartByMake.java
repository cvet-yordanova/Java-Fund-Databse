package softuni.models.view_models;


import com.google.gson.annotations.Expose;

import java.math.BigInteger;

public class ExportCartByMake {
    @Expose
    private Long id;

    @Expose
    private BigInteger travelledDistance;

    @Expose
    private String make;

    @Expose
    private String model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
