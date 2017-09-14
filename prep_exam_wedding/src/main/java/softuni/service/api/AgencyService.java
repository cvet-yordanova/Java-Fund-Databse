package softuni.service.api;

import softuni.entities.Agency;

import java.util.List;

public interface AgencyService {

    List<Agency> findAll();
    Agency findOne(Long aLong);
    void delete(Long aLong);
    void delete(Agency car);
    void save(Agency agency);
    Agency findByName(String name);
}