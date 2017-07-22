import Model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory en = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = en.createEntityManager();

        entityManager.getTransaction().begin();
        BasicIngredient str = new Strawberry();
        BasicIngredient mint = new Mint();
        BasicIngredient str2 = new Strawberry();
        BasicIngredient am = new AmmoniumChloride();
        entityManager.persist(str);
        entityManager.persist(mint);
        entityManager.persist(str2);
        entityManager.persist(am);

        ClassicLabel label = new ClassicLabel("Fresh Nuke");
        BasicShampoo shampoo1 = new FreshNuke();
        Set<BasicIngredient> basicIngredients = new HashSet<>();
        basicIngredients.add(mint);
        basicIngredients.add(str);
        shampoo1.setIngredients(basicIngredients);
        shampoo1.setLabel(label);
        ProductionBatch pr = new ProductionBatch();
        shampoo1.setProductionBatch(pr);

        entityManager.persist(pr);

        entityManager.persist(label);
        entityManager.persist(shampoo1);
        entityManager.getTransaction().commit();




    }
}
