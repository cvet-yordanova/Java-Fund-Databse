package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.dto.import_lenses_json.ImportLensesJsonDto;
import photography.entities.Lens;
import photography.io.DtoMappingUtil;
import photography.repositories.LensRepository;
import photography.service.api.LensService;
import photography.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LensServiceImpl implements LensService {

    @Autowired
    private final DTOValidator validator;

    @Autowired
    private final LensRepository lensRepository;

    public LensServiceImpl(DTOValidator validator, LensRepository lensRepository) {
        this.validator = validator;
        this.lensRepository = lensRepository;
    }

    @Override
    public List<Lens> findAll() {
        return this.lensRepository.findAll();
    }

    @Override
    public Lens findOne(Long aLong) {
        return this.lensRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.lensRepository.delete(aLong);
    }

    @Override
    public void delete(Lens entity) {
            this.lensRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importLensesJson(ImportLensesJsonDto lenses) {
        Lens importLens = DtoMappingUtil.convert(lenses, Lens.class);

        if(validator.isValid(importLens)){
            this.lensRepository.saveAndFlush(importLens);

            System.out.printf("Successfully imported %s %dmm f%f\n", importLens.getMake(), importLens.getFocalLength(), importLens.getMaxAperture());
        }
        else {
            System.out.printf("Error.Couldn't import %s %dmm f%f\n",importLens.getMake(), importLens.getFocalLength(), importLens.getMaxAperture());
        }
    }
}