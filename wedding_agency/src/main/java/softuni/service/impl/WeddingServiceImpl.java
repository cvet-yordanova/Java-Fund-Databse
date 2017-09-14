package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.export_agencies_by_town_xml_dto.ExportAgencyXmlDto;
import softuni.dto.export_agencies_by_town_xml_dto.ExportTownXmlDto;
import softuni.dto.export_agencies_by_town_xml_dto.ExportTownsXmlDto;
import softuni.dto.export_agencies_by_town_xml_dto.ExportWeddingByTownXmlDto;
import softuni.dto.export_weddings.ExportWeddingsJson;
import softuni.dto.import_weddings_and_invitaions_json.ImportInvitaionJsonDto;
import softuni.dto.import_weddings_and_invitaions_json.ImportWeddingJsonDto;
import softuni.entities.*;
import softuni.io.DtoMappingUtil;
import softuni.resources.repositories.*;
import softuni.service.api.WeddingService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Transactional
public class WeddingServiceImpl implements WeddingService {

    @Autowired
    private final WeddingRepository weddingRepository;
    private final PersonRepository personRepository;
    private final AgencyRepository agencyRepository;
    private final InvitationRepository invitationRepository;
    private final VenueRepository venueRepository;

    private final DTOValidator validator;

    @Autowired
    public WeddingServiceImpl(WeddingRepository weddingRepository, PersonRepository personRepository, AgencyRepository agencyRepository, InvitationRepository invitationRepository, VenueRepository venueRepository, DTOValidator validator) {
        this.weddingRepository = weddingRepository;
        this.personRepository = personRepository;
        this.agencyRepository = agencyRepository;
        this.invitationRepository = invitationRepository;
        this.venueRepository = venueRepository;
        this.validator = validator;
    }

    @Override
    public List<Wedding> findAll() {
        return this.weddingRepository.findAll();
    }

    @Override
    public Wedding findOne(Long aLong) {
        return this.weddingRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.weddingRepository.delete(aLong);
    }

    @Override
    public void delete(Wedding entity) {
            this.weddingRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importWeddingsAndInvitations(ImportWeddingJsonDto[] weddingJsonDtos) {
        for (ImportWeddingJsonDto weddingDto : weddingJsonDtos) {

            Wedding weddingImport = DtoMappingUtil.convert(weddingDto,Wedding.class);
            if(weddingDto.getBride() != null){
                Person bride = this.personRepository.findPersonByFullName(weddingDto.getBride());
                weddingImport.setBride(bride);
            }
            if(weddingDto.getBridegroom() != null){
                Person brideGroom = this.personRepository.findPersonByFullName(weddingDto.getBridegroom());
                weddingImport.setBridegroom(brideGroom);
            }
            if(weddingDto.getAgency() != null){
                Agency agency = this.agencyRepository.findByName(weddingDto.getAgency());
                weddingImport.setAgency(agency);
            }

            List<Invitation> invitaions = new ArrayList<>();
            for (ImportInvitaionJsonDto invitationDto : weddingDto.getGuests()) {

                Invitation invitation = DtoMappingUtil.convert(invitationDto, Invitation.class);
                invitation.setFamily(Family.valueOf(invitationDto.getFamily()));
                invitation.setWedding(weddingImport);

                Person guest = this.personRepository.findPersonByFullName(invitationDto.getName());
                if(guest != null){
                    invitation.setGuest(guest);
                }
                if(validator.isValid(invitation)){
                    invitaions.add(invitation);
                }
            }

            weddingImport.setInvitations(invitaions);

            if(validator.isValid(weddingImport)){
                this.weddingRepository.saveAndFlush(weddingImport);
                System.out.println("Successfully imported wedding of "+weddingDto.getBride()+" and "+weddingDto.getBridegroom());
            } else {
                System.out.println("Error. Invalid data provided.");
            }


        }
    }

    @Override
    public List<ExportWeddingsJson> exportWeddings() {
        List<Wedding> weddingsOrderByCountGuests = this.weddingRepository.allWeddingsOrderByGuests();

        List<ExportWeddingsJson> exportWeddingsJsons = new ArrayList<>();

        for (Wedding weddingExp : weddingsOrderByCountGuests) {
            ExportWeddingsJson exportWeddings = DtoMappingUtil.convert(weddingExp,ExportWeddingsJson.class);

            List<String> namesOfComingGuests = new ArrayList<>();

            int invitedGuests = 0;
            int brideGuests = 0;
            int brideGroomGuests = 0;
            int attendingGuests = 0;

            for (Invitation invitation : weddingExp.getInvitations()) {
                 if(invitation.getAttending() == true){
                     attendingGuests ++;
                     namesOfComingGuests.add(invitation.getGuest().getFullName());
                 }
                 if(invitation.getFamily().equals(Family.Bride)){
                     brideGuests++;
                 }
                 if(invitation.getFamily().equals(Family.Bridegroom)){
                     brideGroomGuests++;
                 }

                invitedGuests++;
            }

            exportWeddings.setAttendingGuests(attendingGuests);
            exportWeddings.setBrideGuests(brideGuests);
            exportWeddings.setBridegroomGuests(brideGroomGuests);
            exportWeddings.setInvitedGuests(invitedGuests);
            exportWeddings.setGuests(namesOfComingGuests);

            exportWeddingsJsons.add(exportWeddings);

        }
        return exportWeddingsJsons.stream().sorted(Comparator.comparingInt( a -> a.getAttendingGuests())).collect(Collectors.toList());
    }

    @Override
    public ExportTownsXmlDto exportWeddingsByTown() {

        ExportTownsXmlDto exportTownsXmlDto = new ExportTownsXmlDto();
        List<ExportTownXmlDto> exportTownXmlDtoList = new ArrayList<>();
        List<String> towns = this.weddingRepository.AllTownsWithAtLeast6Symbols();
        List<Agency> agenciesWithEnoughWeddings = this.agencyRepository.agenciesWithEnoughWeddings();
        Map<String,List<Agency>> townsAndAgencies = new HashMap<>();

        for (String town : towns) {
             List<Agency> agenciesInTown = new ArrayList<>();
            for (Agency agency : agenciesWithEnoughWeddings) {
                if(agency.getTown().equals(town)){
                    agenciesInTown.add(agency);
                }
            }

            townsAndAgencies.put(town,agenciesInTown);
        }

        for (Map.Entry<String,List<Agency>> stringListEntry : townsAndAgencies.entrySet()) {
             ExportTownXmlDto exportTownXmlDto = new ExportTownXmlDto();
             List<ExportAgencyXmlDto> agencyXmlDtos = new ArrayList<>();

            for (Agency agency : stringListEntry.getValue() ) {
                 ExportAgencyXmlDto exportAgencyXmlDto = new ExportAgencyXmlDto();
                exportAgencyXmlDto.setName(agency.getName());
                List<Wedding> weddingsFromAgency = this.weddingRepository.findWeddingsByAgencyName(agency.getName());
                List<ExportWeddingByTownXmlDto> weddingByTownXmlDtos = DtoMappingUtil.convert(weddingsFromAgency,ExportWeddingByTownXmlDto.class);
                exportAgencyXmlDto.setWeddings(weddingByTownXmlDtos);


                agencyXmlDtos.add(exportAgencyXmlDto);
            }
            exportTownXmlDto.setAgencies(agencyXmlDtos);
            exportTownXmlDtoList.add(exportTownXmlDto);
        }
        exportTownsXmlDto.setTowns(exportTownXmlDtoList);

        return exportTownsXmlDto;
    }
}