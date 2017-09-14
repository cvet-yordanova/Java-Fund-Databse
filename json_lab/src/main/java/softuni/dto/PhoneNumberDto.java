package softuni.dto;


import com.google.gson.annotations.Expose;
import softuni.model.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberDto {

    @Expose
    @XmlElement
    private String number;

    @Expose
    @XmlTransient
    private PersonDto person;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
