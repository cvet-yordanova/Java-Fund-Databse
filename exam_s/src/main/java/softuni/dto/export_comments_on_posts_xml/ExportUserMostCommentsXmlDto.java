package softuni.dto.export_comments_on_posts_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportUserMostCommentsXmlDto {

    @XmlElement
    private String username;
    @XmlElement(name = "most-comments")
    private Integer mostComments;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMostComments() {
        return mostComments;
    }

    public void setMostComments(Integer mostComments) {
        this.mostComments = mostComments;
    }
}
