package Model;

import Model.service.api.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner{

    private Service<BasicIngredient,Long> basicIngredientService = new ServiceImpl<>();
    private Service<ClassicLabel,Long> classicLabelService = new ServiceImpl<>();
    private Service<BasicShampoo, Long> basicShampooService = new ServiceImpl<>();
    private Service<ProductionBatch, Long> productionBatchService = new ServiceImpl<>();

    @Override
    public void run(String... strings) throws Exception {

    }
}
