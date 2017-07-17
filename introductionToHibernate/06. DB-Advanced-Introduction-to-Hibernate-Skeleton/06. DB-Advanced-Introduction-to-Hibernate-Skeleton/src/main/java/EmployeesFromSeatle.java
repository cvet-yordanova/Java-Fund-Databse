import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DecimalFormat;
import java.util.List;

public class EmployeesFromSeatle {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Employee> employeesFromDepartment = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.department.name = 'Research and Development'  ORDER BY e.salary, e.firstName DESC")
                .getResultList();

        for (Employee employee : employeesFromDepartment) {
            System.out.printf("%s %s from %s - $%.2f\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    (employee.getSalary()));
        }

        entityManager.close();
        entityManagerFactory.close();


    }
}
