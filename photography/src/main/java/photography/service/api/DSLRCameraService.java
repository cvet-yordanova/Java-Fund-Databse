package photography.service.api;

import photography.entities.DSLRCamera;

import java.util.List;

public interface DSLRCameraService {

    List<DSLRCamera> findAll();
    DSLRCamera findOne(Long aLong);
    void delete(Long aLong);
    void delete(DSLRCamera car);
}