package softuni.test;


import java.util.List;

public class PersonT2 {

    private String FirstName;
    private String LastName;
    private String number;
    private List<TelephoneT> telephones;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<TelephoneT> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneT> telephones) {
        this.telephones = telephones;
    }
}
