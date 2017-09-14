package softuni.dto.import_comments_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCommentXmlDto {

    @XmlElement
    private ImportPostPXmlDto post;

    @XmlElement
    private String content;

    @XmlElement(name = "user")
    private String userUsername;

    public ImportPostPXmlDto getPost() {
        return post;
    }

    public void setPost(ImportPostPXmlDto post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
