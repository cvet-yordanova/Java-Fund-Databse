package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.dto.import_accessories_xml.ImportAccessoryDtoXml;
import photography.entities.Accessory;
import photography.entities.Photographer;
import photography.io.DtoMappingUtil;
import photography.repositories.AccessoryRepository;
import photography.repositories.PhotographerRepository;
import photography.service.api.AccessoryService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private final AccessoryRepository accessoryRepository;

    private final PhotographerRepository photographerRepository;

    @Autowired
    public AccessoryServiceImpl(AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository) {
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public List<Accessory> findAll() {
        return this.accessoryRepository.findAll();
    }

    @Override
    public Accessory findOne(Long aLong) {
        return this.accessoryRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.accessoryRepository.delete(aLong);
    }

    @Override
    public void delete(Accessory entity) {
            this.accessoryRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importAccessory(ImportAccessoryDtoXml importAccessoryDtoXml) {
        Accessory accessory = DtoMappingUtil.convert(importAccessoryDtoXml, Accessory.class);
        Long l1 = ThreadLocalRandom.current().nextLong(1, this.photographerRepository.findAll().size());
        Photographer photographer = this.photographerRepository.findOne(l1);

        accessory.setOwner(photographer);
        this.accessoryRepository.saveAndFlush(accessory);

        System.out.println("Successfully imported accessory "+accessory.getName());

    }
}