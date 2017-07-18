import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeeByFirstName {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Query selectEmployeesQuery = entityManager.createQuery("SELECT e from Employee AS e WHERE e.firstName LIKE :word");
        selectEmployeesQuery.setParameter("word",input+"%");
        List<Employee> employees = selectEmployeesQuery.getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - %s ($%.2f)\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary());
        }

        entityManager.close();
        entityManagerFactory.close();

    }
}
