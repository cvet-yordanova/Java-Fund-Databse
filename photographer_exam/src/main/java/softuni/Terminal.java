package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.LensesDto;
import softuni.entities.Lens;
import softuni.serialize.Serializer;
import softuni.services.impl.LensServiceImpl;

import java.util.List;

@Component
public class Terminal implements CommandLineRunner{
    private static final String LENSES_INPUT_JSON = "/files/in/json/lenses.json";

    @Autowired
    private final LensServiceImpl lensService;

    private final Serializer serializer;

    @Autowired
    public Terminal(LensServiceImpl lensService, @Qualifier(value = "JSonSerializer") Serializer serializer) {
        this.lensService = lensService;
        this.serializer = serializer;
    }

    @Override
    public void run(String... strings) throws Exception {

        importLensesJson();

    }

    public void importLensesJson(){

        LensesDto lens = serializer.deserialize(LensesDto.class,LENSES_INPUT_JSON);
        List<Lens> lensList = DtoMappingUtil.convert(lens.getLens(),Lens.class);

        for (Lens lens1 : lensList) {
            this.lensService.save(lens1);
        }

        }

    }

