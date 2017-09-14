package softuni.service.api;

import softuni.entities.Branch;
import softuni.entities.Employee;
import softuni.entities.EmployeeCard;
import softuni.models.binding.import_employees.ImportEmployeeXmlDto;
import softuni.models.view.export_productive_employees.ExportEmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findOne(Long aLong);
    void delete(Long aLong);
    void delete(Employee car);
    void saveEmployeeDto(ImportEmployeeXmlDto employeeXmlDto, EmployeeCard card, Branch branch);
    List<ExportEmployeeDto> getProductiveEmployees();
}