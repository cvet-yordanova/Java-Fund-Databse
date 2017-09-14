package softuni.service.api;

import softuni.entities.Town;
import softuni.models.binding.ImportTownJsonDto;

import java.util.List;

public interface TownService {

    List<Town> findAll();
    Town findOne(Long aLong);
    void delete(Long aLong);
    void delete(Town car);
    void importTownJsonDto(ImportTownJsonDto townDto);
    Town findTownByName(String name);
}