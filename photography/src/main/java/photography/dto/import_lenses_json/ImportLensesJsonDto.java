package photography.dto.import_lenses_json;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ImportLensesJsonDto {

    @Expose
    private String make;

    @Expose
    private Integer focalLength;

    @Expose
    private BigDecimal maxAperture;

    @Expose
    private String compatibleWith;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public BigDecimal getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(BigDecimal maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }
}
