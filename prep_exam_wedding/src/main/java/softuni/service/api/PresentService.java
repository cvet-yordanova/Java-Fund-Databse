package softuni.service.api;

import softuni.entities.Present;
import softuni.models.binding.ImportPresentXml;

public interface PresentService {

    void importPresents(ImportPresentXml importPresent);
    void importPresent(Present present);
}