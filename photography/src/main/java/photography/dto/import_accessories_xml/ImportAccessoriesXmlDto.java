package photography.dto.import_accessories_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportAccessoriesXmlDto {

    @XmlElement(name = "accessory")
    private List<ImportAccessoryDtoXml> importAccessoryDtoXmls;


    public List<ImportAccessoryDtoXml> getImportAccessoryDtoXmls() {
        return importAccessoryDtoXmls;
    }

    public void setImportAccessoryDtoXmls(List<ImportAccessoryDtoXml> importAccessoryDtoXmls) {
        this.importAccessoryDtoXmls = importAccessoryDtoXmls;
    }
}
