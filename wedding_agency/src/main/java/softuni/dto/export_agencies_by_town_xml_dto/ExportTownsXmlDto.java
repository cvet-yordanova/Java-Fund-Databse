package softuni.dto.export_agencies_by_town_xml_dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportTownsXmlDto {

    @XmlElement(name = "town")
    private List<ExportTownXmlDto> towns;

    public List<ExportTownXmlDto> getTowns() {
        return towns;
    }

    public void setTowns(List<ExportTownXmlDto> towns) {
        this.towns = towns;
    }
}
