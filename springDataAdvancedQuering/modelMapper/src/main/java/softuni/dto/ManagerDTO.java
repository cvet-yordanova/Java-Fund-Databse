package softuni.dto;


import softuni.model.Employee;

import java.util.Set;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private String managerLastName;
    private Set<EmployeeDto> managedEmployees;

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

    public Set<EmployeeDto> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<EmployeeDto> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", managedEmployees=" + managedEmployees +
                '}';
    }
}
