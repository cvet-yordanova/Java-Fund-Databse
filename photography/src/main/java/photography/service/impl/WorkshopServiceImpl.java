package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.dto.export_workshops_by_town_xml.ExportLocationsXmlDto;
import photography.dto.export_workshops_by_town_xml.ExportParticipantWorkshopXml;
import photography.dto.export_workshops_by_town_xml.ExportParticipantsWorkshopXmlDto;
import photography.dto.export_workshops_by_town_xml.ExportWorkshopByTownXmlDto;
import photography.dto.import_workshops_xml.ImportParticipantXmlDto;
import photography.dto.import_workshops_xml.ImportWorkshopXmlDto;
import photography.entities.Photographer;
import photography.entities.Workshop;
import photography.io.DtoMappingUtil;
import photography.repositories.PhotographerRepository;
import photography.repositories.WorkshopRepository;
import photography.service.api.WorkshopService;
import photography.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopService {

    @Autowired
    private final WorkshopRepository workshopRepository;

    private final PhotographerRepository photographerRepository;

    private DTOValidator validator;


    public WorkshopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographerRepository, DTOValidator validator) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
        this.validator = validator;
    }

    @Override
    public List<Workshop> findAll() {
        return this.workshopRepository.findAll();
    }

    @Override
    public Workshop findOne(Long aLong) {
        return this.workshopRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.workshopRepository.delete(aLong);
    }

    @Override
    public void delete(Workshop entity) {
            this.workshopRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importWorkshops(ImportWorkshopXmlDto workshopXmlDto) {

        Photographer trainer = null;

        if(workshopXmlDto.getTrainer() != null){
            String[] namesTrainer = workshopXmlDto.getTrainer().split("\\s+");
            trainer = this.photographerRepository.findByFirstNameAndLastName(namesTrainer[0], namesTrainer[1]);
        }

        List<Photographer> participants = new ArrayList<>();

        if(workshopXmlDto.getParticipants() != null){
            for (ImportParticipantXmlDto importParticipantXmlDto : workshopXmlDto.getParticipants()) {
                Photographer participant = this.photographerRepository.findByFirstNameAndLastName(importParticipantXmlDto.getFirstName(),importParticipantXmlDto.getLastName());
                participants.add(participant);
            }
        }

        Workshop workshop = DtoMappingUtil.convert(workshopXmlDto, Workshop.class);
        workshop.setTrainer(trainer);
        workshop.setParticipants(participants);

        if(validator.isValid(workshop)){
            this.workshopRepository.saveAndFlush(workshop);
            System.out.println("Successfully imported "+workshop.getName());
        }
        else {
            System.out.println("Error.Invalid data provided.");
        }


    }

    @Override
    public List<ExportLocationsXmlDto> exportLocationsXml() {
        List<ExportLocationsXmlDto> exportLocationsXmlDtos = new ArrayList<>();
        HashMap<String,List<Workshop>> workshopsByLocation = new HashMap<>();
        List<String> getAllLocations = this.workshopRepository.getAllLocations();

        for (String location : getAllLocations) {
            List<Workshop> workshops = this.workshopRepository.getWorkshopsNoLess5Partipants(location);
            if(workshops.size() > 1){
                workshopsByLocation.put(location, workshops);
            }
        }

        for (Map.Entry<String, List<Workshop>> location : workshopsByLocation.entrySet()) {

            ExportLocationsXmlDto exportLocation = new ExportLocationsXmlDto();
            exportLocation.setName(location.getKey());

            List<ExportWorkshopByTownXmlDto> workshops = new ArrayList<>();

            for (Workshop workshop : location.getValue()) {
                 ExportWorkshopByTownXmlDto workshopExport = DtoMappingUtil.convert(workshop,ExportWorkshopByTownXmlDto.class);
                 ExportParticipantsWorkshopXmlDto participants = new ExportParticipantsWorkshopXmlDto();

                 List<ExportParticipantWorkshopXml> participantsWorkshop = DtoMappingUtil.convert(workshopExport.getParticipants(),ExportParticipantWorkshopXml.class);
                 participants.setParticipants(participantsWorkshop);
                 workshopExport.setParticipantsExport(participants);
                 workshops.add(workshopExport);
            }

            exportLocation.setWorkshops(workshops);
            exportLocationsXmlDtos.add(exportLocation);

        }
        return exportLocationsXmlDtos;
    }
}