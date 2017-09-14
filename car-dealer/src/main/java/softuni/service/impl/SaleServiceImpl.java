package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Sale;
import softuni.repositories.SaleRepository;
import softuni.service.api.SaleService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale findOne(Long aLong) {
        return this.saleRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.saleRepository.delete(aLong);
    }

    @Override
    public void delete(Sale entity) {
            this.saleRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}