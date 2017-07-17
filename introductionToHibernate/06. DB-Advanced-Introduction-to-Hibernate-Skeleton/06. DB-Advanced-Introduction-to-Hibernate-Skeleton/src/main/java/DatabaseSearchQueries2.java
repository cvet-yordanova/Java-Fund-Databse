import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DatabaseSearchQueries2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        Query searchEmployeeById = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.id = :id");
        searchEmployeeById.setParameter("id",id);

        Employee employee = (Employee)searchEmployeeById.getSingleResult();

        System.out.printf("%s %s %s\n", employee.getFirstName(), employee.getLastName(),employee.getJobTitle());
        Set<Project> projects = employee.getProjects();

        for (Project project : projects) {
            System.out.println("---"+project.getName());
        }

    }
}
