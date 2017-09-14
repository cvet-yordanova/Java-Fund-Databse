package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.dto.import_cameras_json.ImportCamerasJsonDto;
import photography.entities.Camera;
import photography.entities.DSLRCamera;
import photography.entities.MirrorlessCamera;
import photography.io.DtoMappingUtil;
import photography.repositories.CameraRepository;
import photography.service.api.CameraService;
import photography.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CameraServiceImpl implements CameraService {

    @Autowired
    private final CameraRepository cameraRepository;

    @Autowired
    private final DTOValidator validator;

    public CameraServiceImpl(CameraRepository cameraRepository, DTOValidator validator) {
        this.cameraRepository = cameraRepository;
        this.validator = validator;
    }

    @Override
    public List<Camera> findAll() {
        return this.cameraRepository.findAll();
    }

    @Override
    public Camera findOne(Long aLong) {
        return this.cameraRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.cameraRepository.delete(aLong);
    }

    @Override
    public void delete(Camera entity) {
            this.cameraRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importCamera(ImportCamerasJsonDto camera) {

        if(camera.getType() == null ){
            System.out.println("Error. Invalid data provided");
        }
        else {
            switch (camera.getType()){
                case "Mirrorless":
                    MirrorlessCamera mirrorlessCamera = DtoMappingUtil.convert(camera, MirrorlessCamera.class);

                    if(validator.isValid(mirrorlessCamera)){
                        this.cameraRepository.saveAndFlush(mirrorlessCamera);
                        System.out.printf("Successfully imported Mirrorless %s %s\n", mirrorlessCamera.getMake(), mirrorlessCamera.getModel());
                    }
                    else{
                        System.out.println("Error. Invalid data provided");
                    }
                    break;

                case "DSLR":
                    DSLRCamera dslrCamera = DtoMappingUtil.convert(camera, DSLRCamera.class);

                    if(validator.isValid(dslrCamera)){
                        this.cameraRepository.saveAndFlush(dslrCamera);

                        System.out.printf("Successfully imported DSLR %s %s\n", dslrCamera.getMake(), dslrCamera.getModel());
                    }

                    else {
                        System.out.println("Error. Invalid data provided");
                    }

                    break;
            }
        }
    }

    @Override
    public List<Camera> getUnusedCameras() {
        return this.cameraRepository.getIdsOfUnusedCameras();
    }
}