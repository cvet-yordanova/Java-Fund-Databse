import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DatabaseSearchQueries4 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Department> departments = entityManager.createQuery("SELECT d FROM Department AS d " +
                "WHERE d.employees.size > 5" +
                "ORDER BY d.employees.size ASC")
                .getResultList();

        for (Department department : departments) {
            System.out.printf("--%s - Manager: %s, Employees: %d\n",
                    department.getName(),
                    department.getManager().getLastName(),
                    department.getEmployees().size()
                    );

            for (Employee employee : department.getEmployees()) {
                System.out.printf("--Employee %s %s Hire Date:%s Job Title: %s\n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getHireDate(),
                        employee.getJobTitle());
            }
        }

        entityManager.close();
        entityManagerFactory.close();

    }
}
