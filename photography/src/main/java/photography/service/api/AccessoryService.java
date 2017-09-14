package photography.service.api;

import photography.dto.import_accessories_xml.ImportAccessoryDtoXml;
import photography.entities.Accessory;

import java.util.List;

public interface AccessoryService {

    List<Accessory> findAll();
    Accessory findOne(Long aLong);
    void delete(Long aLong);
    void delete(Accessory car);
    void importAccessory(ImportAccessoryDtoXml importAccessoryDtoXml);
}