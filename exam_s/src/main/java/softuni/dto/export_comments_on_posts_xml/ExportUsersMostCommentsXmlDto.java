package softuni.dto.export_comments_on_posts_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportUsersMostCommentsXmlDto {

    @XmlElement(name = "user")
    private List<ExportUserMostCommentsXmlDto> exportUserMostCommentsXmlDtos;

    public List<ExportUserMostCommentsXmlDto> getExportUserMostCommentsXmlDtos() {
        return exportUserMostCommentsXmlDtos;
    }

    public void setExportUserMostCommentsXmlDtos(List<ExportUserMostCommentsXmlDto> exportUserMostCommentsXmlDtos) {
        this.exportUserMostCommentsXmlDtos = exportUserMostCommentsXmlDtos;
    }
}
