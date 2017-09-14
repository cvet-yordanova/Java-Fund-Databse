package softuni.service.api;

import softuni.dto.export_agencies_by_town_xml_dto.ExportTownsXmlDto;
import softuni.dto.export_weddings.ExportWeddingsJson;
import softuni.dto.import_weddings_and_invitaions_json.ImportWeddingJsonDto;
import softuni.entities.Wedding;

import java.util.List;

public interface WeddingService {

    List<Wedding> findAll();
    Wedding findOne(Long aLong);
    void delete(Long aLong);
    void delete(Wedding car);
    void importWeddingsAndInvitations(ImportWeddingJsonDto[] weddingJsonDtos);
    List<ExportWeddingsJson> exportWeddings();
    ExportTownsXmlDto exportWeddingsByTown();
}