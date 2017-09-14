package softuni.dto.import_posts_xml;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPostsXmlDto {

    @XmlElement(name = "post")
    private List<ImportPostXmlDto> importPostXmlDtos;

    public List<ImportPostXmlDto> getImportPostXmlDtos() {
        return importPostXmlDtos;
    }

    public void setImportPostXmlDtos(List<ImportPostXmlDto> importPostXmlDtos) {
        this.importPostXmlDtos = importPostXmlDtos;
    }
}
