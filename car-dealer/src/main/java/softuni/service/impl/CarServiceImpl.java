package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JodaTimeConverters;
import org.springframework.stereotype.Service;
import softuni.entities.Car;
import softuni.entities.Part;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.CarAddJsonDto;
import softuni.models.view_models.CarViewDto;
import softuni.models.view_models.ExportCartByMake;
import softuni.repositories.CarRepository;
import softuni.service.api.CarService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findOne(Long aLong) {
        return this.carRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.carRepository.delete(aLong);
    }

    @Override
    public void delete(Car entity) {
            this.carRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void save(CarAddJsonDto carAddJsonDto, Set<Part> parts) {
        Car car = DtoMappingUtil.convert(carAddJsonDto, Car.class);

        car.setParts(parts);

        this.carRepository.save(car);
    }

    @Override
    public List<ExportCartByMake> findAllByMake(String make) {
        List<Car> cars = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make);
        List<ExportCartByMake> exportCartByMakes = new ArrayList<>();

        for (Car car : cars) {
            ExportCartByMake exportCartByMake = DtoMappingUtil.convert(car, ExportCartByMake.class);
            exportCartByMakes.add(exportCartByMake);
        }

        return exportCartByMakes;
    }

    @Override
    public List<CarViewDto> carWithParts() {
        List<Car> cars = this.findAll();
        List<CarViewDto> carViewDtos = DtoMappingUtil.convert(cars, CarViewDto.class);
        return carViewDtos;
    }
}