package softuni.service.api;

import softuni.entities.Wedding;

import java.util.List;

public interface WeddingService {

    List<Wedding> findAll();
    Wedding findOne(Long aLong);
    void delete(Long aLong);
    void delete(Wedding car);
    void saveWedding(Wedding wedding);
}