package softuni.models.binding.import_products;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProductsXmlDto {

    @XmlElement(name = "product")
    private List<ImportProductXmlDto> importProductXmlDtos;

    public List<ImportProductXmlDto> getImportProductXmlDtos() {
        return importProductXmlDtos;
    }

    public void setImportProductXmlDtos(List<ImportProductXmlDto> importProductXmlDtos) {
        this.importProductXmlDtos = importProductXmlDtos;
    }
}
