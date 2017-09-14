package softuni.dto;


import org.modelmapper.ModelMapper;
import softuni.model.Employee;

public final class DtoMappingUtil {

    private DtoMappingUtil(){};

    public static EmployeeDto convertEmployee(Employee employee){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employee, EmployeeDto.class);
    }

    public static Employee convertToEmployee(EmployeeDto employeeDto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeDto, Employee.class);
    }
}
