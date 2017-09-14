package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Gift;
import softuni.resources.repositories.GiftRepository;
import softuni.service.api.GiftService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GiftServiceImpl implements GiftService {

    @Autowired
    private final GiftRepository giftRepository;

    public GiftServiceImpl(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @Override
    public List<Gift> findAll() {
        return this.giftRepository.findAll();
    }

    @Override
    public Gift findOne(Long aLong) {
        return this.giftRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.giftRepository.delete(aLong);
    }

    @Override
    public void delete(Gift entity) {
            this.giftRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}