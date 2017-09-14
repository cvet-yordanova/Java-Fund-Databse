package softuni.dto.export_agencies_by_town_xml_dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportTownXmlDto {

    @XmlAttribute
    private String name;
    @XmlElementWrapper(name = "agencies")
    @XmlElement(name = "agency")
    private List<ExportAgencyXmlDto> agencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExportAgencyXmlDto> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<ExportAgencyXmlDto> agencies) {
        this.agencies = agencies;
    }
}
