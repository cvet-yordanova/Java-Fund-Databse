package photography.dto.export_workshops_by_town_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportLocationsXmlDto {

    @XmlAttribute
    private String name;
    @XmlElement(name = "workshop")
    private List<ExportWorkshopByTownXmlDto> workshops;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExportWorkshopByTownXmlDto> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<ExportWorkshopByTownXmlDto> workshops) {
        this.workshops = workshops;
    }
}
