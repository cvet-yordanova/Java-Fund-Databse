package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Part;
import softuni.entities.Supplier;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.PartImportJsonDto;
import softuni.repositories.PartRepository;
import softuni.service.api.PartService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    private final PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return this.partRepository.findAll();
    }

    @Override
    public Part findOne(Long aLong) {
        return this.partRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.partRepository.delete(aLong);
    }

    @Override
    public void delete(Part entity) {
            this.partRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void save(PartImportJsonDto partImportJsonDto, Supplier supplier) {
        Part part = DtoMappingUtil.convert(partImportJsonDto, Part.class);

        part.setSupplier(supplier);

        this.partRepository.saveAndFlush(part);
    }
}