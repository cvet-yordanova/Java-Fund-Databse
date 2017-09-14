package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.DtoMappingUtil;
import softuni.dto.EmployeeDto;
import softuni.dto.ManagerDTO;
import softuni.model.Address;
import softuni.model.City;
import softuni.model.Employee;
import softuni.service.impl.EmployeeServiceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class terminal implements CommandLineRunner{

    @Autowired
    private final EmployeeServiceImpl employeeService;

    public terminal(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public void run(String... strings) throws Exception {

        City city = new City("Varna");
        Address address = new Address(city);

        Employee employee1 = new Employee("Ivan","Dimitrov", BigDecimal.valueOf(1234.234), new Date(),address);
        Employee employee2 = new Employee("Gosho","Petrov", BigDecimal.valueOf(5234.234), new Date(),address);
        EmployeeDto employeeDto = DtoMappingUtil.convert(employee1, EmployeeDto.class);
        System.out.println(employeeDto);

        Employee employee3 = DtoMappingUtil.convert(employeeDto, Employee.class);
        System.out.println(employee3);
        employee2.addManagedEmployee(employee1);
        employee1.setManager(employee2);

        ManagerDTO managerDTO = DtoMappingUtil.convert(employee2, ManagerDTO.class);
        System.out.println(managerDTO);

        employeeService.register(employee2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<Employee> olderEmployee = employeeService.findOlderEmployee(sdf.parse("20180101"));
        System.out.println(olderEmployee);


    }
}
