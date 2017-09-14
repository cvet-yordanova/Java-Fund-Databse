package softuni.service.api;

import softuni.dto.export_agencies_json.ExportAgenciesJsonDto;
import softuni.dto.import_agencies.ImportAgencyJsonDto;
import softuni.entities.Agency;

import java.util.List;

public interface AgencyService {

    List<Agency> findAll();
    Agency findOne(Long aLong);
    void delete(Long aLong);
    void delete(Agency car);
    void importAgenciesJson(ImportAgencyJsonDto[] agenciesDto);
    List<ExportAgenciesJsonDto> exportAgencies();
}