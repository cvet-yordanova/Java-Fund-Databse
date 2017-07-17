import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConcurrentDatabaseChanges {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManagerOne = entityManagerFactory.createEntityManager();

        EntityManager entityManagerTwo = entityManagerFactory.createEntityManager();

        entityManagerOne.getTransaction().begin();


    }
}
