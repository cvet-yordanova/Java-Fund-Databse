package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Branch;
import softuni.entities.Employee;
import softuni.entities.EmployeeCard;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.import_employees.ImportEmployeeXmlDto;
import softuni.models.view.export_productive_employees.ExportEmployeeDto;
import softuni.repositories.BranchRepository;
import softuni.repositories.EmployeeRepository;
import softuni.service.api.EmployeeService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final DTOValidator validator;

    @Autowired
    private final BranchRepository branchRepository;

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(DTOValidator validator, BranchRepository branchRepository, EmployeeRepository employeeRepository) {
        this.validator = validator;
        this.branchRepository = branchRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findOne(Long aLong) {
        return this.employeeRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.employeeRepository.delete(aLong);
    }

    @Override
    public void delete(Employee entity) {
            this.employeeRepository.delete(entity);
    }

    @Override
    public void saveEmployeeDto(ImportEmployeeXmlDto employeeXmlDto, EmployeeCard card, Branch branch) {
        Employee employee = DtoMappingUtil.convert(employeeXmlDto, Employee.class);
        employee.setBranch(branch);
        employee.setCard(card);

        if (validator.isValid(employee)) {
            this.employeeRepository.saveAndFlush(employee);
            System.out.printf("Successfully imported %s %s.\n", employee.getFirstName(), employee.getLastName());
        }

        else {
            System.out.println("Error: Invalid data.");
        }
    }

    @Override
    public List<ExportEmployeeDto> getProductiveEmployees() {

        List<Branch> branchesWithAtLeastOneProduct = this.branchRepository.findBranchByCountProductsMoreThan1();
        List<ExportEmployeeDto> exportEmployeeDtos = new ArrayList<>();

        for (Branch branch : branchesWithAtLeastOneProduct) {

            for (Employee employee : branch.getEmployees()) {
                ExportEmployeeDto productiveEmployee = DtoMappingUtil.convert(employee, ExportEmployeeDto.class);
                exportEmployeeDtos.add(productiveEmployee);
            }
        }

        return exportEmployeeDtos;
    }

    //--------------------------------------------------------------------
}