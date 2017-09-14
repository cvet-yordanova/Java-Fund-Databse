package photography.dto.export_workshops_by_town_xml;

import photography.entities.Photographer;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportWorkshopByTownXmlDto {

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "participants")
    private ExportParticipantsWorkshopXmlDto participantsExport;
    @XmlTransient
    private BigDecimal pricePerParticipant;
    @XmlTransient
    private List<Photographer> participants ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExportParticipantsWorkshopXmlDto getParticipantsExport() {
        return participantsExport;
    }

    public void setParticipantsExport(ExportParticipantsWorkshopXmlDto participantsExport) {
        this.participantsExport = participantsExport;
    }

    public List<Photographer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Photographer> participants) {
        this.participants = participants;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    //ParticipantsCount * PricePerSingleParticipant – 20% (Trainer Salary)

    @XmlAttribute(name = "total-profit")
    public BigDecimal getTotalProfit(){
        return pricePerParticipant.multiply(BigDecimal.valueOf(participants.size())).multiply(BigDecimal.valueOf(0.8));
    }
}
