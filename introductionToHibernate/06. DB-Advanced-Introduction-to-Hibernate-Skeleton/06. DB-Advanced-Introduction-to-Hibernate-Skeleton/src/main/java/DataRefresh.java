import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employeeFour = (Employee) entityManager.createQuery("SELECT e from Employee  AS e WHERE e.id = 4")
                .getSingleResult();

        System.out.println(employeeFour.getFirstName());

        employeeFour.setFirstName(employeeFour.getFirstName().toUpperCase());
        entityManager.refresh(employeeFour);
        entityManager.persist(employeeFour);

        entityManager.close();

        System.out.println(employeeFour.getFirstName());
    }
}
