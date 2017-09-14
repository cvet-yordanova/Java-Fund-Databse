package photography.dto.export_photographers_with_same_cameras_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportPhotographersWithSameCameras {

    @XmlElement(name = "photographer")
    private List<ExportPhotographerWithSameCameras> exportPhotographerWithSameCameras;

    public List<ExportPhotographerWithSameCameras> getExportPhotographerWithSameCameras() {
        return exportPhotographerWithSameCameras;
    }

    public void setExportPhotographerWithSameCameras(List<ExportPhotographerWithSameCameras> exportPhotographerWithSameCameras) {
        this.exportPhotographerWithSameCameras = exportPhotographerWithSameCameras;
    }
}
