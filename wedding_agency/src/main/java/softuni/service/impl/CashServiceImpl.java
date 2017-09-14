package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Cash;
import softuni.resources.repositories.CashRepository;
import softuni.service.api.CashService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CashServiceImpl implements CashService {

    @Autowired
    private final CashRepository cashRepository;

    public CashServiceImpl(CashRepository cashRepository) {
        this.cashRepository = cashRepository;
    }

    @Override
    public List<Cash> findAll() {
        return this.cashRepository.findAll();
    }

    @Override
    public Cash findOne(Long aLong) {
        return this.cashRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.cashRepository.delete(aLong);
    }

    @Override
    public void delete(Cash entity) {
            this.cashRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}