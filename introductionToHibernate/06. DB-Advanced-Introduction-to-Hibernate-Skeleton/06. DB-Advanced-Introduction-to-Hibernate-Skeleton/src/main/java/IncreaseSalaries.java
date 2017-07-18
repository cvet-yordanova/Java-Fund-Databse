import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Department> selectDepartments = entityManager.createQuery("SELECT d FROM Department AS d WHERE d.name IN " +
                "('Engineering','Tool Design','Marketing','Information Services')")
                .getResultList();

        Query updateSalaries = entityManager.createQuery("UPDATE Employee AS e " +
                "SET e .salary = e .salary * 1.12  " +
                "WHERE e.department IN :departments");
        updateSalaries.setParameter("departments",selectDepartments);

        List<Employee> selectEmployees = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.department.name IN " +
                "('Engineering','Tool Design','Marketing','Information Services')")
                .getResultList();

        entityManager.getTransaction().begin();
        updateSalaries.executeUpdate();
        entityManager.getTransaction().commit();

        for (Employee employee : selectEmployees) {
            System.out.printf("%s %s ($%.2f)\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary());
        }

        entityManager.close();;
        entityManagerFactory.close();

    }
}
