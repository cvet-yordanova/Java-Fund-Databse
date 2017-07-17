import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DatabaseSearchQueries3 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Project> projectIds = entityManager.createQuery("SELECT p.id FROM Project AS p " +
                "WHERE DATE_FORMAT(p.startDate, '%Y') BETWEEN 2001 AND 2005").getResultList();

        Query employeesQuery = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "INNER JOIN e.projects AS p " +
                "WHERE p.id IN (:ids)");

        employeesQuery.setParameter("ids",projectIds);
        List<Employee> employees = employeesQuery.getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - Manager: %s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getManager().getFirstName());

            for (Project project : employee.getProjects()) {
                System.out.printf("--- Name: %s, Start date: %s, End date: %s\n",
                       project.getName(),
                        project.getStartDate(),
                        project.getEndDate());
            }
        }
        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}
