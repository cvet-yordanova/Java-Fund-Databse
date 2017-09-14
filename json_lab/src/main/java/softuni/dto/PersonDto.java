package softuni.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.springframework.beans.factory.annotation.Autowired;
import softuni.model.PhoneNumber;
import softuni.validation.ValidatorUtils;

import javax.xml.bind.annotation.*;
import java.util.Iterator;
import java.util.Set;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDto {

    @Autowired
    private ValidatorUtils validatorUtils;

    @Expose
    @XmlElement(name = "first_name")
    private String firstName;

    @Expose
    @XmlElement(name = "last_name")
    private String lastName;

    @Expose
    @SerializedName(value = "addressImportDto")
    @XmlElement(name = "address")
    private AddressDto address;

    @Expose
    @XmlElementWrapper(name = "phone_numbers")
    @XmlElement(name = "phone_number")
    private Set<PhoneNumberDto> phoneNumbers;

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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Set<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumberDto> phoneNumbers) {

        for (Iterator<PhoneNumberDto> i = phoneNumbers.iterator(); i.hasNext();) {
            PhoneNumberDto phoneNumber = i.next();

            if(!validatorUtils.isValid(phoneNumber)){
                i.remove();
            }
        }
        this.phoneNumbers = phoneNumbers;
    }
}
