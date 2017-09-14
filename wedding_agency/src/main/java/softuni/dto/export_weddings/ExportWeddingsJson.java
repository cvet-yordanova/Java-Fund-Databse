package softuni.dto.export_weddings;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Agency;
import softuni.entities.Invitation;
import softuni.entities.Person;

import java.util.Date;
import java.util.List;

public class ExportWeddingsJson {

    @Expose
    @SerializedName(value = "bride" )
    private Person brideFullName;

    @Expose
    @SerializedName(value = "bridegroom" )
    private Person bridegroomFullName;

    @Expose
    private ExportAgencyJsonDto agency;

    List<Invitation> invitations;

    @Expose
    private Integer invitedGuests;
    @Expose
    private Integer brideGuests;
    @Expose
    private Integer bridegroomGuests;
    @Expose
    private Integer attendingGuests;

    @Expose
    private List<String> guests;

    public Person getBrideFullName() {
        return brideFullName;
    }

    public void setBrideFullName(Person brideFullName) {
        this.brideFullName = brideFullName;
    }

    public Person getBridegroomFullName() {
        return bridegroomFullName;
    }

    public void setBridegroomFullName(Person bridegroomFullName) {
        this.bridegroomFullName = bridegroomFullName;
    }

    public ExportAgencyJsonDto getAgency() {
        return agency;
    }

    public void setAgency(ExportAgencyJsonDto agency) {
        this.agency = agency;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public Integer getInvitedGuests() {
        return invitedGuests;
    }

    public void setInvitedGuests(Integer invitedGuests) {
        this.invitedGuests = invitedGuests;
    }

    public Integer getBrideGuests() {
        return brideGuests;
    }

    public void setBrideGuests(Integer brideGuests) {
        this.brideGuests = brideGuests;
    }

    public Integer getBridegroomGuests() {
        return bridegroomGuests;
    }

    public void setBridegroomGuests(Integer bridegroomGuests) {
        this.bridegroomGuests = bridegroomGuests;
    }

    public Integer getAttendingGuests() {
        return attendingGuests;
    }

    public void setAttendingGuests(Integer attendingGuests) {
        this.attendingGuests = attendingGuests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }

}
