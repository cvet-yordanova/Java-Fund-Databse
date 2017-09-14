package photography.service.api;

import photography.dto.import_cameras_json.ImportCamerasJsonDto;
import photography.entities.Camera;

import java.util.List;

public interface CameraService {

    List<Camera> findAll();
    Camera findOne(Long aLong);
    void delete(Long aLong);
    void delete(Camera car);

    void importCamera(ImportCamerasJsonDto camera);
    List<Camera> getUnusedCameras();
}