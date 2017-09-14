package softuni.service.api;

import softuni.dto.import_agencies.ImportAgencyJsonDto;
import softuni.dto.import_presents_xml.ImportPresentXmlDto;
import softuni.entities.Agency;

import java.util.List;

public interface PresentService {

    void importPresents(ImportPresentXmlDto presentXmlDto);
}