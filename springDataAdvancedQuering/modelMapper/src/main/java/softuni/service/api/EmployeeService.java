package softuni.service.api;


import softuni.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public void register(Employee employee);
    public List<Employee> findOlderEmployee(Date date);
}
