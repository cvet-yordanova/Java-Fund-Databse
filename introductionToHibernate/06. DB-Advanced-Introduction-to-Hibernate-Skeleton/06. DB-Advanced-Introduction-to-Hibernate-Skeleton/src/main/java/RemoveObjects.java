import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveObjects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Town> towns = entityManager.createQuery("SELECT t FROM Town AS t ")
                .getResultList();

        for (Town town : towns) {
            if(town.getName().length() > 5){
                entityManager.detach(town);
            }
        }

        entityManager.getTransaction().begin();
        for (Town town : towns) {
            if(entityManager.contains(town)){
                town.setName(town.getName().toLowerCase());
                entityManager.persist(town);
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
