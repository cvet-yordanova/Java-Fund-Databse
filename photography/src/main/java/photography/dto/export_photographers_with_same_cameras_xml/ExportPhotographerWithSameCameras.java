package photography.dto.export_photographers_with_same_cameras_xml;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportPhotographerWithSameCameras {

    @XmlTransient
    private String firstName;
    @XmlTransient
    private String lastName;
   // @XmlAttribute(name = "name")
   // private String fullName;
    @XmlTransient
    private String primaryCameraMake;
    @XmlTransient
    private String primaryCameraModel;
    //@XmlAttribute(name = "primary-camera")
    //private String cameraInfo;
    @XmlElementWrapper(name = "lenses")
    @XmlElement(name = "lens")
    private List<ExportLensXmlDto> lenses;

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

    public String getPrimaryCameraModel() {
        return primaryCameraModel;
    }

    public void setPrimaryCameraModel(String primaryCameraModel) {
        this.primaryCameraModel = primaryCameraModel;
    }

    public List<ExportLensXmlDto> getLenses() {
        return lenses;
    }

    public void setLenses(List<ExportLensXmlDto> lenses) {
        this.lenses = lenses;
    }

    @XmlAttribute(name = "primary-camera")
    public String getCameraInfo(){
        return primaryCameraMake+" "+primaryCameraMake;
    }

    @XmlAttribute(name = "name")
    public String getFullName(){
        return firstName+" "+lastName;
    }
}
