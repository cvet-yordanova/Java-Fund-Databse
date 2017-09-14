package photography.dto.export_photographers_with_same_cameras_xml;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportLensXmlDto {

    @XmlTransient
    private String make;

    @XmlTransient
    private Integer focalLength;

    @XmlTransient
    private BigDecimal maxAperture;

   // @XmlElement(name = "lens")
    //private String info;

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

    @XmlValue
    public String getInfo() {
        return make+" "+focalLength+" "+maxAperture;
    }

  // public void setInfo(String info) {
  //      this.info = info;
  //  }
}
