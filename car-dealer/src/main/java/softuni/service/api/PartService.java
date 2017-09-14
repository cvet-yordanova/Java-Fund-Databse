package softuni.service.api;

import softuni.entities.Part;
import softuni.entities.Supplier;
import softuni.models.binding.PartImportJsonDto;

import java.util.List;

public interface PartService {

    List<Part> findAll();
    Part findOne(Long aLong);
    void delete(Long aLong);
    void delete(Part car);
    void save(PartImportJsonDto partImportJsonDto, Supplier supplier);
}