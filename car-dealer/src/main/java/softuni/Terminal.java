package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.Car;
import softuni.entities.Part;
import softuni.entities.Supplier;
import softuni.models.binding.CarAddJsonDto;
import softuni.models.binding.CustomerDto;
import softuni.models.binding.PartImportJsonDto;
import softuni.models.binding.SupplierDto;
import softuni.models.view_models.CarViewDto;
import softuni.models.view_models.ExportCartByMake;
import softuni.models.view_models.SupplierViewDto;
import softuni.serialize.JSonSerializer;
import softuni.service.api.CarService;
import softuni.service.api.CustomerService;
import softuni.service.api.PartService;
import softuni.service.api.Supplier2Service;
import softuni.service.impl.SupplierServiceImpl;

import java.util.*;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private final JSonSerializer jSonSerializer;

    @Autowired
    private final Supplier2Service supplier2Service;

    @Autowired
    private final CarService carService;

    @Autowired
    private final PartService partService;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final SupplierServiceImpl supplierService;

    private final String IMPORT_SUPPLIERS_JSON = "/files/json/in/suppliers.json";
    private final String IMPORT_PARTS_JSON = "/files/json/in/parts.json";
    private final String IMPORT_CARS_JSON = "/files/json/in/cars.json";
    private final String IMPORT_CUSTOMERS_JSON = "/files/json/in/customers.json";
    private final String EXPORT_CARS_BY_MAKE = "src/main/resources/files/json/out/cars_by_make1.json";
    private final String EXPORT_LOCAL_SUPPLIERS= "src/main/resources/files/json/out/local_suppliers.json";
    private final String EXPORT_CARS_WITH_PARTS= "src/main/resources/files/json/out/cars_with_parts.json";

    public Terminal(JSonSerializer jSonSerializer, Supplier2Service supplier2Service, CarService carService, PartService partService, CustomerService customerService, SupplierServiceImpl supplierService) {
        this.jSonSerializer = jSonSerializer;
        this.supplier2Service = supplier2Service;
        this.carService = carService;
        this.partService = partService;
        this.customerService = customerService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... strings) throws Exception {

      //  importSuppliers();
        //importParts();
        //importCars();
        //importCustomersJson();

       // exportCarsByMake();
        //exportLocalSuppliers();
       // exportCarsAndParts();

    }

    private void importSuppliers() {
        SupplierDto[] supplierDtos = jSonSerializer.deserialize(SupplierDto[].class,IMPORT_SUPPLIERS_JSON);

        for (SupplierDto supplierDto : supplierDtos) {
            this.supplierService.save(supplierDto);
        }
    }

    private void importParts(){
        PartImportJsonDto[] partImportJsonDtos = this.jSonSerializer.deserialize(PartImportJsonDto[].class,IMPORT_PARTS_JSON);

        Random random = new Random();
        List<Supplier> suppliers = this.supplierService.findAll();

        for (PartImportJsonDto partImportJsonDto : partImportJsonDtos) {
            Supplier supplier = suppliers.get(random.nextInt(suppliers.size()));
            this.partService.save(partImportJsonDto,supplier);
        }
    }

    private void importCars(){
        CarAddJsonDto[] carAddJsonDto = this.jSonSerializer.deserialize(CarAddJsonDto[].class,IMPORT_CARS_JSON );
        List<Part> parts = this.partService.findAll();
        Set<Part> partsToAdd = new HashSet<>();
        Random random = new Random();

        for (CarAddJsonDto addJsonDto : carAddJsonDto) {

            for (int i = 0; i < 2; i++) {
                Part part = parts.get(random.nextInt(parts.size()));

                if(partsToAdd.contains(part)){
                    continue;
                }
                else {
                    partsToAdd.add(part);
                }

            }

            this.carService.save(addJsonDto, partsToAdd);

        }


    }

    private void importCustomersJson(){

        CustomerDto[] customerDtos = this.jSonSerializer.deserialize(CustomerDto[].class, IMPORT_CUSTOMERS_JSON);

        for (CustomerDto customerDto : customerDtos) {
            this.customerService.save(customerDto);
        }
    }

    private void exportCarsByMake(){
        List<ExportCartByMake> cars = this.carService.findAllByMake("Toyota");
                jSonSerializer.serialize(cars,EXPORT_CARS_BY_MAKE);
    }

    private void exportLocalSuppliers(){
        List<SupplierViewDto> supplierViewDtos = this.supplierService.getLocalSuppliers();

        this.jSonSerializer.serialize(supplierViewDtos,EXPORT_LOCAL_SUPPLIERS );
    }

    private void exportCarsAndParts(){
        List<CarViewDto> carViewDtos = this.carService.carWithParts();

        jSonSerializer.serialize(carViewDtos,EXPORT_CARS_WITH_PARTS );
    }

}
