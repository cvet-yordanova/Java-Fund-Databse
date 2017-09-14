package softuni.models.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "presents")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPresentsXml {

    @XmlElement(name = "present")
    private List<ImportPresentXml> presentXmls;

    public List<ImportPresentXml> getPresentXmls() {
        return presentXmls;
    }

    public void setPresentXmls(List<ImportPresentXml> presentXmls) {
        this.presentXmls = presentXmls;
    }
}
