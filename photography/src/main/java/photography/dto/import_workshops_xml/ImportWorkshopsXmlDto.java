package photography.dto.import_workshops_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportWorkshopsXmlDto {

    @XmlElement(name = "workshop")
    private List<ImportWorkshopXmlDto> importWorkshopXmlDtos;

    public List<ImportWorkshopXmlDto> getImportWorkshopXmlDtos() {
        return importWorkshopXmlDtos;
    }

    public void setImportWorkshopXmlDtos(List<ImportWorkshopXmlDto> importWorkshopXmlDtos) {
        this.importWorkshopXmlDtos = importWorkshopXmlDtos;
    }
}
