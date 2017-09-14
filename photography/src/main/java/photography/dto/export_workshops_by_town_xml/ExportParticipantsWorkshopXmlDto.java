package photography.dto.export_workshops_by_town_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportParticipantsWorkshopXmlDto {


    @XmlElement(name = "participant")
    private List<ExportParticipantWorkshopXml> participants;

    @XmlAttribute(name = "count")
    public Integer getParticipantsCount() {
        return participants.size();
    }

    public List<ExportParticipantWorkshopXml> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ExportParticipantWorkshopXml> participants) {
        this.participants = participants;
    }
}
