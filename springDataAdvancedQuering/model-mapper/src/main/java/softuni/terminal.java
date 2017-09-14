package softuni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import softuni.dto.DtoMappingUtil;
import softuni.dto.EmployeeDto;
import softuni.model.Address;
import softuni.model.City;
import softuni.model.Employee;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class terminal implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {

        City city = new City("Varna");
        Address address = new Address(city);

        Employee employee1 = new Employee("Ivan","Dimitrov", BigDecimal.valueOf(1234.234), new Date(),address);
        EmployeeDto employeeDto = DtoMappingUtil.convertEmployee(employee1);
        System.out.println(employeeDto);

        Employee employee2 = DtoMappingUtil.convertToEmployee(employeeDto);
        System.out.println(employee2);
    }
}
