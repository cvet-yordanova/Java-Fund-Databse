package photography;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import photography.dto.export_landscape_photographers_json.ExportLandscapePhotographesJsonDto;
import photography.dto.export_photographers_ordered_json.ExportPhotographerJson;
import photography.dto.export_photographers_with_same_cameras_xml.ExportPhotographerWithSameCameras;
import photography.dto.export_photographers_with_same_cameras_xml.ExportPhotographersWithSameCameras;
import photography.dto.export_workshops_by_town_xml.ExportLocationsRootXmlDto;
import photography.dto.export_workshops_by_town_xml.ExportLocationsXmlDto;
import photography.dto.import_accessories_xml.ImportAccessoriesXmlDto;
import photography.dto.import_accessories_xml.ImportAccessoryDtoXml;
import photography.dto.import_cameras_json.ImportCamerasJsonDto;
import photography.dto.import_lenses_json.ImportLensesJsonDto;
import photography.dto.import_photographers_json.ImportPhotographerDtoJson;
import photography.dto.import_workshops_xml.ImportWorkshopXmlDto;
import photography.dto.import_workshops_xml.ImportWorkshopsXmlDto;
import photography.entities.Camera;
import photography.entities.Lens;
import photography.serialize.JSonSerializer;
import photography.serialize.XMLSerializer;
import photography.service.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Transactional
public class Terminal implements CommandLineRunner{

    private final LensService lensService;
    private final DSLRCameraService dSLRCameraService;
    private final MirrorlessCameraService mirrorlessCameraService;
    private final CameraService cameraService;
    private final AccessoryService accessoryService;
    private final PhotographerService photographerService;
    private final WorkshopService workshopService;

    private final JSonSerializer jsonSerializer;
    private final XMLSerializer xmlSerializer;

    private final String IMPORT_LENSES_JSON = "/files/in/lenses.json";
    private final String IMPORT_CAMERAS_JSON = "/files/in/cameras.json";
    private final String IMPORT_PHOTOGRAPHERS_JSON = "/files/in/photographers.json";
    private final String IMPORT_ACCESSORIES_XML = "/files/in/accessories.xml";
    private final String IMPORT_WORKSHOPS_XML = "/files/in/workshops.xml";
    private final String EXPORT_PHOTOGRAPHERS_ORDERED_JSON = "src/main/resources/files/out/photographers-ordered.json";
    private final String EXPORT_PHOTOGRAPHERS_WITH_SAME_CAMERAS_XML = "src/main/resources/files/out/same-cameras-photographers.xml";
    private final String EXPORT_LANDSCAPE_PHOTOGRAPHERS_JSON = "src/main/resources/files/out/landscape-photogaphers.json";
    private final String EXPORT_WORKSHOPS_BY_LOCATION = "src/main/resources/files/out/workshops-by-location.xml";

    @Autowired
    public Terminal(LensService lensService, DSLRCameraService dSLRCameraService,
                    MirrorlessCameraService mirrorlessCameraService, CameraService cameraService,
                    AccessoryService accessoryService, PhotographerService photographerService,
                    WorkshopService workshopService, JSonSerializer jsonSerializer, XMLSerializer xmlSerializer) {
        this.lensService = lensService;
        this.dSLRCameraService = dSLRCameraService;
        this.mirrorlessCameraService = mirrorlessCameraService;
        this.cameraService = cameraService;
        this.accessoryService = accessoryService;
        this.photographerService = photographerService;
        this.workshopService = workshopService;
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
    }


    @Override
    public void run(String... strings) throws Exception {

//        importLenses();
//        importCameras();
//        importPhotographers();
//        importAccessories();
//        importWorkshopsXMl();

//        exportPhotographersOrderedJson();
//        exportPhotographersWithSameCameras();
//          exportLandscapePhotographers();
        exportWorkshopsByLocation();

    }

    private void importLenses(){
        ImportLensesJsonDto[] importLensesJsonDtos = this.jsonSerializer.deserialize(ImportLensesJsonDto[].class,IMPORT_LENSES_JSON);

        for (ImportLensesJsonDto importLensesJsonDto : importLensesJsonDtos) {
            this.lensService.importLensesJson(importLensesJsonDto);
        }

    }

    private void importCameras(){

        ImportCamerasJsonDto[] importCamerasJsonDto = this.jsonSerializer.deserialize(ImportCamerasJsonDto[].class, IMPORT_CAMERAS_JSON);

        for (ImportCamerasJsonDto camerasJsonDto : importCamerasJsonDto) {
            this.cameraService.importCamera(camerasJsonDto);
        }
    }

    private void importPhotographers(){
        ImportPhotographerDtoJson[] photographerDtoJsons = this.jsonSerializer.deserialize(ImportPhotographerDtoJson[].class,IMPORT_PHOTOGRAPHERS_JSON );

        for (ImportPhotographerDtoJson photographerDtoJson : photographerDtoJsons) {
            long l1 = -1;
            long l2 = -1;
            Camera primaryCamera = this.cameraService.findOne(l1);;
            Camera secondaryCamera = this.cameraService.findOne(l2);;

            List<Camera> unusedCameras = this.cameraService.getUnusedCameras();

            while(!this.cameraService.getUnusedCameras().contains(primaryCamera)){
                l1 = ThreadLocalRandom.current().nextLong(1, this.cameraService.findAll().size());
                primaryCamera = this.cameraService.findOne(l1);
                unusedCameras.remove(primaryCamera);

            }

            while(!this.cameraService.getUnusedCameras().contains(secondaryCamera)){
                l2 = ThreadLocalRandom.current().nextLong(1, this.cameraService.findAll().size());
                secondaryCamera = this.cameraService.findOne(l2);
                unusedCameras.remove(secondaryCamera);
            }

            List<Lens> lensList = new ArrayList<>();

            for (Long aLong : photographerDtoJson.getLensesIds()) {

                Lens lens = this.lensService.findOne(aLong);
                 if(lens == null || !(isCameraCompatible(primaryCamera,lens) || isCameraCompatible(secondaryCamera,lens))){
                     System.out.println("Invalid Lens!");
                 }
                 else {
                     lensList.add(lens);
                     System.out.println("Lenses added!");
                 }
            }

            this.photographerService.importPhotographer(photographerDtoJson,primaryCamera, secondaryCamera, lensList);
        }

    }

    private boolean isCameraCompatible(Camera camera, Lens lens){
        return camera.getMake().equals(lens.getCompatibleWith());
    }

    private void importAccessories(){

        ImportAccessoriesXmlDto importAccessoriesXmlDto = this.xmlSerializer.deserialize(ImportAccessoriesXmlDto.class, IMPORT_ACCESSORIES_XML);

        for (ImportAccessoryDtoXml importAccessoryDtoXml : importAccessoriesXmlDto.getImportAccessoryDtoXmls()) {
            this.accessoryService.importAccessory(importAccessoryDtoXml);
        }
    }

    private void importWorkshopsXMl(){

        ImportWorkshopsXmlDto workshopsXmlDto = this.xmlSerializer.deserialize(ImportWorkshopsXmlDto.class,IMPORT_WORKSHOPS_XML);

        for (ImportWorkshopXmlDto importWorkshopXmlDto : workshopsXmlDto.getImportWorkshopXmlDtos()) {
            this.workshopService.importWorkshops(importWorkshopXmlDto);
        }
    }

    private void exportPhotographersOrderedJson(){
        List<ExportPhotographerJson> exportPhotographerJsons = this.photographerService.exportPhotographersOrderd();
        this.jsonSerializer.serialize(exportPhotographerJsons,EXPORT_PHOTOGRAPHERS_ORDERED_JSON);
    }

    private void exportPhotographersWithSameCameras(){
        List<ExportPhotographerWithSameCameras> photographersWithSameCameras = this.photographerService.exportPhotographersWithSameCameras();
        ExportPhotographersWithSameCameras exportPhotographersWithSameCameras = new ExportPhotographersWithSameCameras();
        exportPhotographersWithSameCameras.setExportPhotographerWithSameCameras(photographersWithSameCameras);
        this.xmlSerializer.serialize(exportPhotographersWithSameCameras,EXPORT_PHOTOGRAPHERS_WITH_SAME_CAMERAS_XML);

    }

    private void exportLandscapePhotographers(){
        List<ExportLandscapePhotographesJsonDto> exportLandscapePhotographesJsonDtos = this.photographerService.exportLandscapePhotographers();
        this.jsonSerializer.serialize(exportLandscapePhotographesJsonDtos,EXPORT_LANDSCAPE_PHOTOGRAPHERS_JSON);
    }

    private void exportWorkshopsByLocation(){
        List<ExportLocationsXmlDto> locations = this.workshopService.exportLocationsXml();
        ExportLocationsRootXmlDto locationsRootXmlDto = new ExportLocationsRootXmlDto();
        locationsRootXmlDto.setExportLocationsXmlDtos(locations);
        this.xmlSerializer.serialize(locationsRootXmlDto,EXPORT_WORKSHOPS_BY_LOCATION);
    }

}
