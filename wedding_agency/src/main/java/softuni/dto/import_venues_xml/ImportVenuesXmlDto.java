package softuni.dto.import_venues_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportVenuesXmlDto {

    @XmlElement(name = "venue")
    private List<ImportVenueXmlDto> venues;

    public List<ImportVenueXmlDto> getVenues() {
        return venues;
    }

    public void setVenues(List<ImportVenueXmlDto> venues) {
        this.venues = venues;
    }
}
