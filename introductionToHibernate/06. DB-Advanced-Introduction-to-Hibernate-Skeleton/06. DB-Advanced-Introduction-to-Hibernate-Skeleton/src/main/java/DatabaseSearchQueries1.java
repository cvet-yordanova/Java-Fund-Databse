import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DatabaseSearchQueries1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Address> addresses = entityManager.createQuery("SELECT DISTINCT a FROM Address AS a "+
                "ORDER BY a.employees.size DESC, a.town.name ASC")
                .setMaxResults(10)
                .getResultList();
        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees\n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }

        entityManager.close();
        entityManagerFactory.close();

    }
}
