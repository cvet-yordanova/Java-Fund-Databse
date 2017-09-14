package softuni.service.api;

import softuni.entities.Gift;

import java.util.List;

public interface GiftService {

    List<Gift> findAll();
    Gift findOne(Long aLong);
    void delete(Long aLong);
    void delete(Gift car);
}