package photography.dto.export_workshops_by_town_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportLocationsRootXmlDto {

    @XmlElement(name = "location")
    private List<ExportLocationsXmlDto> exportLocationsXmlDtos;

    public List<ExportLocationsXmlDto> getExportLocationsXmlDtos() {
        return exportLocationsXmlDtos;
    }

    public void setExportLocationsXmlDtos(List<ExportLocationsXmlDto> exportLocationsXmlDtos) {
        this.exportLocationsXmlDtos = exportLocationsXmlDtos;
    }
}
