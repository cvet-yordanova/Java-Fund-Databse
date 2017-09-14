package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dao.EmployeeDao;
import softuni.model.Employee;
import softuni.service.api.EmployeeService;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void register(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public List<Employee> findOlderEmployee(Date date) {
        return employeeDao.findAllByBirthDateBeforeOrderBySalaryDesc(date);
    }
}
