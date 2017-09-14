package softuni.dto.export_venues_in_sofia_xml;

import softuni.entities.Wedding;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportVenueInSofiaXmlDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private Integer capacity;
    @XmlElement(name = "weddings-count")
    private Integer weddingsCount;

    @XmlTransient
    private List<Wedding> weddings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getWeddingsCount() {
        return weddingsCount;
    }

    public void setWeddingsCount(Integer weddingsCount) {
        this.weddingsCount = weddingsCount;
    }

    public List<Wedding> getWeddings() {
        return weddings;
    }

    public void setWeddings(List<Wedding> weddings) {
        this.weddings = weddings;
    }
}
