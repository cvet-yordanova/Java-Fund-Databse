package softuni.models.binding.ImportWeddingJson;

import softuni.models.binding.ImportVenue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportVenuesXml {

    @XmlElement(name = "venue")
    private List<ImportVenue> importVenues;

    public List<ImportVenue> getImportVenues() {
        return importVenues;
    }

    public void setImportVenues(List<ImportVenue> importVenues) {
        this.importVenues = importVenues;
    }
}
