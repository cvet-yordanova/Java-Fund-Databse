package softuni.dto;


import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeDto implements Serializable{

    private static final long serialVersionUID = -3651870946477574614L;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String addressCityName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCity) {
        this.addressCityName = addressCity;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", addressCity='" + addressCityName + '\'' +
                '}';
    }
}
