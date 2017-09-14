package photography.service.api;

import photography.dto.import_lenses_json.ImportLensesJsonDto;
import photography.entities.Lens;

import java.util.List;

public interface LensService {

    List<Lens> findAll();
    Lens findOne(Long aLong);
    void delete(Long aLong);
    void delete(Lens car);

    void importLensesJson(ImportLensesJsonDto lenses);
}