package softuni.dto.import_presents_xml;

import softuni.entities.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPresentXmlDto {

    @XmlAttribute
    private String type;

    @XmlAttribute(name = "invitation-id")
    private Long invitaionId;

    @XmlAttribute
    private BigDecimal amount;

    @XmlAttribute(name = "present-name")
    private String name;

    @XmlAttribute
    private Size size;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getInvitaionId() {
        return invitaionId;
    }

    public void setInvitaionId(Long invitaionId) {
        this.invitaionId = invitaionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
