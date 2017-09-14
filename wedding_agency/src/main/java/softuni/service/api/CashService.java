package softuni.service.api;

import softuni.entities.Cash;

import java.util.List;

public interface CashService {

    List<Cash> findAll();
    Cash findOne(Long aLong);
    void delete(Long aLong);
    void delete(Cash car);
}