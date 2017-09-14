package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Supplier1;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.SupplierDto;
import softuni.repositories.Supplier2Repository;
import softuni.service.api.Supplier2Service;

@Service
@Transactional
public class Supplier1ServiceImpl implements Supplier2Service {

    @Autowired
    private final Supplier2Repository supplier2Repository;

    public Supplier1ServiceImpl(Supplier2Repository supplier2Repository) {
        this.supplier2Repository = supplier2Repository;
    }

    @Override
    public void supplierDto(SupplierDto supplierDto) {
        Supplier1 supplier1 = DtoMappingUtil.convert(supplierDto, Supplier1.class);

        this.supplier2Repository.saveAndFlush(supplier1);

    }
}
