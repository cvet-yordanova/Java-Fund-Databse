package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Wedding;
import softuni.repositories.WeddingRepository;
import softuni.service.api.WeddingService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WeddingServiceImpl implements WeddingService {

    @Autowired
    private final WeddingRepository weddingRepository;

    @Autowired
    private final DTOValidator validator;

    public WeddingServiceImpl(WeddingRepository weddingRepository, DTOValidator validator) {
        this.weddingRepository = weddingRepository;
        this.validator = validator;
    }

    @Override
    public List<Wedding> findAll() {
        return this.weddingRepository.findAll();
    }

    @Override
    public Wedding findOne(Long aLong) {
        return this.weddingRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.weddingRepository.delete(aLong);
    }

    @Override
    public void delete(Wedding entity) {
            this.weddingRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void saveWedding(Wedding wedding) {
        if(validator.isValid(wedding)){
            this.weddingRepository.saveAndFlush(wedding);
            System.out.println("Successfully added wedding ...");
        }
        else {
            System.out.println("Error.Invalid data.");
        }
    }
}