package photography.service.api;

import photography.entities.MirrorlessCamera;

import java.util.List;

public interface MirrorlessCameraService {

    List<MirrorlessCamera> findAll();
    MirrorlessCamera findOne(Long aLong);
    void delete(Long aLong);
    void delete(MirrorlessCamera car);
}