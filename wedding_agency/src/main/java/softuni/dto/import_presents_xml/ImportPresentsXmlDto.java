package softuni.dto.import_presents_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "presents")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPresentsXmlDto {

    @XmlElement(name = "present")
    private List<ImportPresentXmlDto> presents;

    public List<ImportPresentXmlDto> getPresents() {
        return presents;
    }

    public void setPresents(List<ImportPresentXmlDto> presents) {
        this.presents = presents;
    }
}
