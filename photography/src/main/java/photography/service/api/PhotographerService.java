package photography.service.api;

import photography.dto.export_landscape_photographers_json.ExportLandscapePhotographesJsonDto;
import photography.dto.export_photographers_ordered_json.ExportPhotographerJson;
import photography.dto.export_photographers_with_same_cameras_xml.ExportPhotographerWithSameCameras;
import photography.dto.import_photographers_json.ImportPhotographerDtoJson;
import photography.entities.Camera;
import photography.entities.Lens;
import photography.entities.Photographer;

import java.util.List;

public interface PhotographerService {

    List<Photographer> findAll();
    Photographer findOne(Long aLong);
    void delete(Long aLong);
    void delete(Photographer car);
    void importPhotographer(ImportPhotographerDtoJson photographerDtoJson, Camera primaryCamera, Camera secondaryCamera, List<Lens> lens);
    List<ExportPhotographerJson> exportPhotographersOrderd();
    List<ExportPhotographerWithSameCameras> exportPhotographersWithSameCameras();
    List<ExportLandscapePhotographesJsonDto> exportLandscapePhotographers();


}