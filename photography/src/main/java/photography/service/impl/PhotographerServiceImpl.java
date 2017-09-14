package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.dto.export_landscape_photographers_json.ExportLandscapePhotographesJsonDto;
import photography.dto.export_photographers_ordered_json.ExportPhotographerJson;
import photography.dto.export_photographers_with_same_cameras_xml.ExportPhotographerWithSameCameras;
import photography.dto.import_photographers_json.ImportPhotographerDtoJson;
import photography.entities.Camera;
import photography.entities.Lens;
import photography.entities.Photographer;
import photography.io.DtoMappingUtil;
import photography.repositories.PhotographerRepository;
import photography.service.api.PhotographerService;
import photography.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {

    @Autowired
    private final PhotographerRepository photographerRepository;

    @Autowired
    private final DTOValidator validator;

    public PhotographerServiceImpl(PhotographerRepository photographerRepository, DTOValidator validator) {
        this.photographerRepository = photographerRepository;
        this.validator = validator;
    }

    @Override
    public List<Photographer> findAll() {
        return this.photographerRepository.findAll();
    }

    @Override
    public Photographer findOne(Long aLong) {
        return this.photographerRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.photographerRepository.delete(aLong);
    }

    @Override
    public void delete(Photographer entity) {
            this.photographerRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importPhotographer(ImportPhotographerDtoJson photographerDtoJson, Camera primaryCamera, Camera secondaryCamera, List<Lens> lens) {

        Photographer photographer = DtoMappingUtil.convert(photographerDtoJson, Photographer.class);
        photographer.setPrimaryCamera(primaryCamera);
        photographer.setSecondaryCamera(secondaryCamera);
        photographer.setLenses(lens);

        if(validator.isValid(photographer)){
            this.photographerRepository.save(photographer);
            for (Lens len : lens) {
                len.setOwner(photographer);
            }
            System.out.printf("Successfully imported %s | %d lenses\n", photographer.getFirstName()+" "+photographer.getLastName(), lens.size());
        }
        else {
            System.out.println("Error. Invalid data provided.");
        }
    }

    @Override
    public List<ExportPhotographerJson> exportPhotographersOrderd() {

        List<Photographer> orderdPhotographers = this.photographerRepository.getPhotographersOrdered();
        return DtoMappingUtil.convert(orderdPhotographers,ExportPhotographerJson.class);
    }

    @Override
    public List<ExportPhotographerWithSameCameras> exportPhotographersWithSameCameras() {

        List<Photographer> getPhotographersWithSameCameras = this.photographerRepository.getPhotographersWithSameCameras();
        List<ExportPhotographerWithSameCameras> exportPhotographerWithSameCameras = new ArrayList<>();

        for (Photographer photographer : getPhotographersWithSameCameras) {
            ExportPhotographerWithSameCameras exportPhotographer = DtoMappingUtil.convert(photographer,ExportPhotographerWithSameCameras.class);
        //    exportPhotographer.setFullName(photographer.getFirstName()+" "+photographer.getLastName());
        //    exportPhotographer.setCameraInfo(exportPhotographer.getPrimaryCameraMake()+" "+exportPhotographer.getPrimaryCameraModel());
            exportPhotographerWithSameCameras.add(exportPhotographer);
        }
        return exportPhotographerWithSameCameras;
    }

    @Override
    public List<ExportLandscapePhotographesJsonDto> exportLandscapePhotographers() {
        List<Photographer> getLandscapePhotographers = this.photographerRepository.getLandscapePhotographers();
        List<ExportLandscapePhotographesJsonDto> exportPhotographers = new ArrayList<>();

        for (Photographer photographer : getLandscapePhotographers) {
            ExportLandscapePhotographesJsonDto exportLandscapePhotographesJsonDto = DtoMappingUtil.convert(photographer, ExportLandscapePhotographesJsonDto.class);
            exportLandscapePhotographesJsonDto.setLensesCount(photographer.getLenses().size());
            exportPhotographers.add(exportLandscapePhotographesJsonDto);
        }

        return exportPhotographers ;
    }
}