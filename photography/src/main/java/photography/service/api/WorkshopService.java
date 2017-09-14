package photography.service.api;

import photography.dto.export_workshops_by_town_xml.ExportLocationsXmlDto;
import photography.dto.import_workshops_xml.ImportWorkshopXmlDto;
import photography.entities.Workshop;

import java.util.List;

public interface WorkshopService {

    List<Workshop> findAll();
    Workshop findOne(Long aLong);
    void delete(Long aLong);
    void delete(Workshop car);
    void importWorkshops(ImportWorkshopXmlDto workshopXmlDto);
    List<ExportLocationsXmlDto> exportLocationsXml();
}