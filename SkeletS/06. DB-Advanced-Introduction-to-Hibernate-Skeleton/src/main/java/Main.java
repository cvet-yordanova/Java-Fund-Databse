import Model.*;
import Model.service.api.Service;
import Model.service.impl.ServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private Service<BasicIngredient,Long> basicIngredientService = new ServiceImpl<>();
    private Service<ClassicLabel,Long> classicLabelService = new ServiceImpl<>();
    private Service<BasicShampoo, Long> basicShampooService = new ServiceImpl<>();
    private Service<ProductionBatch, Long> productionBatchService = new ServiceImpl<>();

    public static void main(String[] args) {
        EntityManagerFactory en = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = en.createEntityManager();

    Main shampooCompany = new Main();
    shampooCompany.run();

    }

    private void run (){

        BasicIngredient str = new Strawberry();
        BasicIngredient mint = new Mint();
        BasicIngredient str2 = new Strawberry();
        BasicIngredient am = new AmmoniumChloride();

       basicIngredientService.save(str);
       basicIngredientService.save(mint);
       basicIngredientService.save(str2);
       basicIngredientService.save(am);

        ClassicLabel label = new ClassicLabel("Fresh Nuke");
        BasicShampoo shampoo1 = new FreshNuke();
        Set<BasicIngredient> basicIngredients = new HashSet<>();
        basicIngredients.add(mint);
        basicIngredients.add(str);
        shampoo1.setIngredients(basicIngredients);
        shampoo1.setLabel(label);
        ProductionBatch pr = new ProductionBatch();
        shampoo1.setProductionBatch(pr);

        productionBatchService.save(pr);

        classicLabelService.save(label);
        basicShampooService.save(shampoo1);

    }
}
