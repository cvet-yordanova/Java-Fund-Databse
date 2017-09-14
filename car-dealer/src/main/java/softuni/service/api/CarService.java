package softuni.service.api;

import softuni.entities.Car;
import softuni.entities.Part;
import softuni.models.binding.CarAddJsonDto;
import softuni.models.view_models.CarViewDto;
import softuni.models.view_models.ExportCartByMake;

import java.util.List;
import java.util.Set;

public interface CarService {

    List<Car> findAll();
    Car findOne(Long aLong);
    void delete(Long aLong);
    void delete(Car car);
    void save(CarAddJsonDto carAddJsonDto, Set<Part> parts);
    List<ExportCartByMake> findAllByMake(String make);
    List<CarViewDto> carWithParts();
}