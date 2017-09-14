package softuni.dto.export_agencies_by_town_xml_dto;


import softuni.entities.Cash;
import softuni.entities.Invitation;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportWeddingByTownXmlDto {

    @XmlTransient
    private List<Invitation> invitations;
    @XmlElement(name = "bride")
    private String brideFullName;
    @XmlAttribute(name = "bridegroom")
    private String bridegroomFullName;
    @XmlElementWrapper(name = "guests")
    @XmlElement(name = "guest")
    private List<GuestExportXmlDto> guests;
//    @XmlAttribute(name = "cash")
//    private Integer countCash;
//    @XmlAttribute(name = "presents")
//    private Integer countGift;

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public String getBrideFullName() {
        return brideFullName;
    }

    public void setBrideFullName(String brideFullName) {
        this.brideFullName = brideFullName;
    }

    public String getBridegroomFullName() {
        return bridegroomFullName;
    }

    public void setBridegroomFullName(String bridegroomFullName) {
        this.bridegroomFullName = bridegroomFullName;
    }

    public List<GuestExportXmlDto> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestExportXmlDto> guests) {
        this.guests = guests;
    }

    @XmlAttribute(name = "cash")
    public Integer getCountCash() {
        int countCash = 0;

        for (Invitation invitation : invitations) {
            if(invitation.getPresent().getClass().getSimpleName() == "Cash"){
                countCash++;
            }
        }
        return countCash;
    }


    @XmlAttribute(name = "presents")
    public Integer getCountGift() {

        int countGift = 0;

        for (Invitation invitation : invitations) {
            if(invitation.getPresent().getClass().getSimpleName() == "Gift"){
                countGift++;
            }
        }
        return countGift;
    }

    public BigDecimal CashAmount(){
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Invitation invitation : invitations) {
             if(invitation.getPresent().getClass().getSimpleName() == "Cash"){
                 Cash cash = (Cash)invitation.getPresent();
                 sum.add(cash.getAmount());
             }
        }
        return sum;
    }

}
