package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.*;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.*;
import softuni.models.binding.ImportWeddingJson.Guest;
import softuni.models.binding.ImportWeddingJson.ImportVenuesXml;
import softuni.models.binding.ImportWeddingJson.ImportWeddingJson;
import softuni.serialize.JSonSerializer;
import softuni.serialize.XMLSerializer;
import softuni.service.api.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner{

    private final VenueService VenueService;

    private final AgencyService AgencyService;

    private final PersonService PersonService;

    private final WeddingService WeddingService;

    private final CashService CashService;

    @Autowired
    private final PresentService presentService;

    @Autowired
    private JSonSerializer jSonSerializer;

    @Autowired
    private XMLSerializer xmlSerializer;


    @Autowired
    public Terminal(VenueService VenueService, AgencyService AgencyService, PersonService PersonService, WeddingService WeddingService, CashService CashService, PresentService presentService, JSonSerializer jSonSerializer) {
        this.VenueService = VenueService;
        this.AgencyService = AgencyService;
        this.PersonService = PersonService;
        this.WeddingService = WeddingService;
        this.CashService = CashService;
        this.presentService = presentService;
        this.jSonSerializer = jSonSerializer;
    }

    private final String IMPORT_AGENCIES = "/files/json/in/agencies.json";
    private final String IMPORT_PEOPLE = "/files/json/in/people.json";
    private final String IMPORT_WEDDING = "/files/json/in/weddings.json";
    private final String IMPORT_VENUES = "/files/xml/in/venues.xml";
    private final String IMPORT_PRESENTS = "/files/xml/in/presents.xml";

    @Override
    public void run(String... strings) throws Exception {


//       importAgencies();
//        importPeople();
//        importWedding();
//        importVenuesXml();
//        setRandomVenues();
        importPresents();
      //  savePresent();

    }

    private void importAgencies(){
        ImportAgencyJson[] importAgencyJsons = jSonSerializer.deserialize(ImportAgencyJson[].class,IMPORT_AGENCIES);
        for (ImportAgencyJson importAgencyJson : importAgencyJsons) {
             Agency agency = DtoMappingUtil.convert(importAgencyJson, Agency.class);
             this.AgencyService.save(agency);
        }
    }

    private void importPeople(){
        ImportPersonJson[] importPersonJson = jSonSerializer.deserialize(ImportPersonJson[].class,IMPORT_PEOPLE );

        for (ImportPersonJson personJson : importPersonJson) {
            Person person = DtoMappingUtil.convert(personJson, Person.class);
            this.PersonService.save(person);
        }
    }

    private void importWedding(){

         ImportWeddingJson[] importWeddingJson = jSonSerializer.deserialize(ImportWeddingJson[].class,IMPORT_WEDDING);

        for (ImportWeddingJson weddingJson : importWeddingJson) {
            Wedding wedding = new Wedding();
            String[] groomData = weddingJson.getBride().split("\\s+");
            String[] brideData = weddingJson.getBride().split("\\s+");

            Person groom = this.PersonService.findByName(groomData[0], groomData[1], groomData[2]);
            Person bride = this.PersonService.findByName(brideData[0], brideData[1], brideData[2]);
            Agency agency = this.AgencyService.findByName(weddingJson.getAgency());

            wedding.setBride(bride);
            wedding.setBrideGroom(groom);

             Set<Invitation> guests = new HashSet<>();

            for (Guest guest : weddingJson.getGuests()) {
                Invitation invitation = DtoMappingUtil.convert(guest,Invitation.class);

                Person inv = this.PersonService.findByName(guest.getFirstName(), guest.getMiddleNameInitial(), guest.getLastName());

                invitation.setGuest(inv);

                if(inv != null){
                    guests.add(invitation);
                }
            }

            wedding.setDate(weddingJson.getDate());
            wedding.setAgency(agency);

            wedding.setInvitations(guests);

            this.WeddingService.saveWedding(wedding);

        }

    }

    private void importVenuesXml(){
        ImportVenuesXml importVenuesXml = this.xmlSerializer.deserialize(ImportVenuesXml.class, IMPORT_VENUES);

        for (ImportVenue importVenue : importVenuesXml.getImportVenues()) {
            Venue venue = DtoMappingUtil.convert(importVenue, Venue.class);
            this.VenueService.importVenue(venue);
        }
    }

    private void setRandomVenues(){

        List<Wedding> weddingList = this.WeddingService.findAll();
        List<Venue> veneus = this.VenueService.findAll();

        Random random = new Random();

        for (Wedding wedding : weddingList) {
            Set<Venue> venues = new HashSet<>();
            venues.add(veneus.get(random.nextInt(veneus.size())));
            venues.add(veneus.get(random.nextInt(veneus.size())));

            wedding.setVenues(venues);
            this.WeddingService.saveWedding(wedding);
        }
    }

    private void importPresents(){
        ImportPresentsXml importPresentsXml = xmlSerializer.deserialize(ImportPresentsXml.class,IMPORT_PRESENTS );

        for (ImportPresentXml importPresentXml : importPresentsXml.getPresentXmls()) {
            this.presentService.importPresents(importPresentXml);
        }
        System.out.println(importPresentsXml);
        ImportPresentXml importPresentXml = importPresentsXml.getPresentXmls().get(1);

        System.out.println(importPresentsXml);
    }

    private void savePresent(){
        Cash cash = new Cash();

        cash.setAmount(new BigDecimal("12345"));
        this.CashService.saveCash(cash);

    }
}
