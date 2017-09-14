package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Town;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.ImportTownJsonDto;
import softuni.repositories.TownRepository;
import softuni.service.api.TownService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    @Autowired
    private final DTOValidator dtoValidator;

    @Autowired
    private final TownRepository townRepository;

    public TownServiceImpl(DTOValidator dtoValidator, TownRepository townRepository) {
        this.dtoValidator = dtoValidator;
        this.townRepository = townRepository;
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }

    @Override
    public Town findOne(Long aLong) {
        return this.townRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.townRepository.delete(aLong);
    }

    @Override
    public void delete(Town entity) {
            this.townRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importTownJsonDto(ImportTownJsonDto townDto) {
        Town town = DtoMappingUtil.convert(townDto, Town.class);
        Town town1 = this.townRepository.findTownByName("asdf");

        if(this.dtoValidator.isValid(town)){
            this.townRepository.saveAndFlush(town);
            System.out.println("Successfully imported Town "+town.getName());
        }
        else {
            System.out.println("Invalid data.");
        }
    }

    @Override
    public Town findTownByName(String name) {
        return this.townRepository.findTownByName(name);
    }
}