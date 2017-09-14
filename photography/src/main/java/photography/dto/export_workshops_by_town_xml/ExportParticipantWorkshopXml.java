package photography.dto.export_workshops_by_town_xml;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportParticipantWorkshopXml {

    @XmlTransient
    private String firstName;
    @XmlTransient
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlValue
    public String getName(){
        return firstName+" "+lastName;
    }
}
