package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.dto.export_agencies_by_town_xml_dto.ExportTownXmlDto;
import softuni.dto.export_agencies_by_town_xml_dto.ExportTownsXmlDto;
import softuni.dto.export_agencies_json.ExportAgenciesJsonDto;
import softuni.dto.export_venues_in_sofia_xml.ExportVenuesInSofiaXmlDto;
import softuni.dto.export_weddings.ExportWeddingsJson;
import softuni.dto.import_agencies.ImportAgencyJsonDto;
import softuni.dto.import_people_json.ImportPersonJsonDto;
import softuni.dto.import_presents_xml.ImportPresentXmlDto;
import softuni.dto.import_presents_xml.ImportPresentsXmlDto;
import softuni.dto.import_venues_xml.ImportVenuesXmlDto;
import softuni.dto.import_weddings_and_invitaions_json.ImportWeddingJsonDto;
import softuni.serialize.JSonSerializer;
import softuni.serialize.XMLSerializer;
import softuni.service.api.*;

import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    private final VenueService venueService;
    private final AgencyService agencyService;
    private final PersonService personService;
    private final WeddingService weddingService;
    private final InvitationService invitationService;
    private final CashService cashService;
    private final GiftService giftService;
    private final PresentService presentService;

    private final JSonSerializer jSonSerializer;
    private final XMLSerializer xmlSerializer;

    private final String IMPORT_AGENCIES_JSON = "/files/json/in/agencies.json";
    private final String IMPORT_PEOPLE_JSON = "/files/json/in/people.json";
    private final String IMPORT_WEDDINGS_JSON = "/files/json/in/weddings.json";
    private final String IMPORT_VENUES_XML = "/files/json/in/venues.xml";
    private final String IMPORT_PRESENTS_XML = "/files/json/in/presents.xml";
    private final String EXPORT_AGENCIES_JSON = "src/main/resources/files/out/agencies-ordered.json";
    private final String EXPORT_WEDDINGS_JSON = "src/main/resources/files/out/guests.json";
    private final String EXPORT_VENUES_XML = "src/main/resources/files/out/venues.xml";
    private final String EXPORT_AGENCIES_BY_TOWN= "src/main/resources/files/out/agencies_by_town.xml";

    @Autowired
    public Terminal(VenueService venueService, AgencyService agencyService, PersonService personService, WeddingService weddingService, InvitationService invitationService, CashService cashService, GiftService giftService, PresentService presentService, JSonSerializer jSonSerializer, XMLSerializer xmlSerializer) {
        this.venueService = venueService;
        this.agencyService = agencyService;
        this.personService = personService;
        this.weddingService = weddingService;
        this.invitationService = invitationService;
        this.cashService = cashService;
        this.giftService = giftService;
        this.presentService = presentService;
        this.jSonSerializer = jSonSerializer;
        this.xmlSerializer = xmlSerializer;
    }

    @Override
    public void run(String... strings) throws Exception {

//        importAgencies();
//        importPeople();
//        importWeddingsAndInvitaions();
//        importVenues();
//        importPresents();

    //    exportAgencies();
    //    exportWeddings();
     //   ExportVenues();
        exportWEddingsByTown();


    }
    public void importAgencies(){
        ImportAgencyJsonDto[] importAgencyJsonDtos = this.jSonSerializer.deserialize(ImportAgencyJsonDto[].class,IMPORT_AGENCIES_JSON);
        this.agencyService.importAgenciesJson(importAgencyJsonDtos);
    }

    public void importPeople(){
        ImportPersonJsonDto[] importPersonJsonDtos = this.jSonSerializer.deserialize(ImportPersonJsonDto[].class,IMPORT_PEOPLE_JSON);
        this.personService.importPeople(importPersonJsonDtos);
    }

    public void importWeddingsAndInvitaions(){
        ImportWeddingJsonDto[] weddingJsonDtos = this.jSonSerializer.deserialize(ImportWeddingJsonDto[].class, IMPORT_WEDDINGS_JSON);
        this.weddingService.importWeddingsAndInvitations(weddingJsonDtos);
    }

    public void importVenues(){
        ImportVenuesXmlDto importVenuesXmlDto = this.xmlSerializer.deserialize(ImportVenuesXmlDto.class, IMPORT_VENUES_XML);
        this.venueService.importVenuesXml(importVenuesXmlDto);


    }

    public void importPresents(){
        ImportPresentsXmlDto importPresentsXmlDto = this.xmlSerializer.deserialize(ImportPresentsXmlDto.class,IMPORT_PRESENTS_XML);
        for (ImportPresentXmlDto importPresentXmlDto : importPresentsXmlDto.getPresents()) {

            if(importPresentXmlDto.getType() != null){
                this.presentService.importPresents(importPresentXmlDto);
            }else{
                System.out.println("Error. Invalid data provided.");
            }
        }
    }

    public void exportAgencies(){
        List<ExportAgenciesJsonDto> exportAgenciesJsonDtos = this.agencyService.exportAgencies();
        this.jSonSerializer.serialize(exportAgenciesJsonDtos,EXPORT_AGENCIES_JSON);
    }

    public void exportWeddings(){
        List<ExportWeddingsJson> exportAgenciesJsonDtos = this.weddingService.exportWeddings();
        this.jSonSerializer.serialize(exportAgenciesJsonDtos,EXPORT_WEDDINGS_JSON);
    }

    public void ExportVenues(){
        ExportVenuesInSofiaXmlDto venuesInSofiaXmlDto = this.venueService.exportVenues();
        this.xmlSerializer.serialize(venuesInSofiaXmlDto,EXPORT_VENUES_XML);
    }

    public void exportWEddingsByTown(){
        ExportTownsXmlDto exportTownXmlDto = this.weddingService.exportWeddingsByTown();
        this.xmlSerializer.serialize(exportTownXmlDto,EXPORT_AGENCIES_BY_TOWN);
    }



}
