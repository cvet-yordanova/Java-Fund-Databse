package softuni.service.api;

import softuni.entities.Sale;

import java.util.List;

public interface SaleService {

    List<Sale> findAll();
    Sale findOne(Long aLong);
    void delete(Long aLong);
    void delete(Sale car);
}