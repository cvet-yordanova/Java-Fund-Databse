package softuni.dto.import_comments_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "comments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCommentsXmlDto {

    @XmlElement(name = "comment")
    private List<ImportCommentXmlDto> importCommentXmlDtos;

    public List<ImportCommentXmlDto> getImportCommentXmlDtos() {
        return importCommentXmlDtos;
    }

    public void setImportCommentXmlDtos(List<ImportCommentXmlDto> importCommentXmlDtos) {
        this.importCommentXmlDtos = importCommentXmlDtos;
    }
}
