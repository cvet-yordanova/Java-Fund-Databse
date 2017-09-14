package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Supplier;
import softuni.io.DtoMappingUtil;

import softuni.models.binding.SupplierDto;
import softuni.models.view_models.SupplierViewDto;
import softuni.repositories.SupplierRepository;
import softuni.service.api.SupplierService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return this.supplierRepository.findAll();
    }

    @Override
    public Supplier findOne(Long aLong) {
        return this.supplierRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.supplierRepository.delete(aLong);
    }

    @Override
    public void delete(Supplier entity) {
            this.supplierRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void save(SupplierDto supplierDto) {
        Supplier supplier = DtoMappingUtil.convert(supplierDto,Supplier.class);

        this.supplierRepository.saveAndFlush(supplier);
    }

    @Override
    public List<SupplierViewDto> getLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.findAllByUsesImportedParts(false);
        List<SupplierViewDto> supplierViewDtos1 = new ArrayList<>();

        for (Supplier s : suppliers) {

            SupplierViewDto supplierViewDto1  = DtoMappingUtil.convert(s, SupplierViewDto.class);
            supplierViewDto1.setCountParts(s.getParts().size());

            supplierViewDtos1.add(supplierViewDto1);
        }
        return supplierViewDtos1;
    }
}