package softuni.service.api;

import softuni.entities.Supplier;
import softuni.models.binding.SupplierDto;
import softuni.models.view_models.SupplierViewDto;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();
    Supplier findOne(Long aLong);
    void delete(Long aLong);
    void delete(Supplier car);
    void save(SupplierDto supplierViewDto);
    List<SupplierViewDto> getLocalSuppliers();
}