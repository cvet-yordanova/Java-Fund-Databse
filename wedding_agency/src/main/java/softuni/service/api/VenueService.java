package softuni.service.api;

import softuni.dto.export_venues_in_sofia_xml.ExportVenueInSofiaXmlDto;
import softuni.dto.export_venues_in_sofia_xml.ExportVenuesInSofiaXmlDto;
import softuni.dto.import_venues_xml.ImportVenuesXmlDto;
import softuni.entities.Venue;

import java.util.List;

public interface VenueService {

    List<Venue> findAll();
    Venue findOne(Long aLong);
    void delete(Long aLong);
    void delete(Venue car);
    void importVenuesXml(ImportVenuesXmlDto importVenuesXmlDto);
    ExportVenuesInSofiaXmlDto exportVenues();
}