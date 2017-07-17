import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> select = entityManager.createQuery("SELECT e FROM Employee AS e")
                .getResultList();

        String[] name = reader
                .readLine().split("\\s");

        System.out.println(select.stream().anyMatch(a -> a.getFirstName().equals(name[0]) && a.getLastName().equals(name[1])) ? "Yes" : "No");

        entityManager.close();
        entityManager.close();
    }
}
