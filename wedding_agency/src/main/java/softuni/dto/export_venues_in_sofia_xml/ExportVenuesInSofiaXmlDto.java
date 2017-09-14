package softuni.dto.export_venues_in_sofia_xml;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportVenuesInSofiaXmlDto {

    @XmlElement(name = "venue")
    private List<ExportVenueInSofiaXmlDto> venues;

    @XmlAttribute
    private String town;

    public List<ExportVenueInSofiaXmlDto> getVenues() {
        return venues;
    }

    public void setVenues(List<ExportVenueInSofiaXmlDto> venues) {
        this.venues = venues;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
