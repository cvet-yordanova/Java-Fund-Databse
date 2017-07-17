import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalaryOver50000 {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> listWithNames = entityManager.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000")
                .getResultList();

        for (String name : listWithNames) {
            System.out.println(name);
        }

        entityManager.close();
        entityManagerFactory.close();

    }


}
