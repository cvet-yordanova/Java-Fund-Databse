package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.export_venues_in_sofia_xml.ExportVenueInSofiaXmlDto;
import softuni.dto.export_venues_in_sofia_xml.ExportVenuesInSofiaXmlDto;
import softuni.dto.import_venues_xml.ImportVenueXmlDto;
import softuni.dto.import_venues_xml.ImportVenuesXmlDto;
import softuni.entities.Venue;
import softuni.entities.Wedding;
import softuni.io.DtoMappingUtil;
import softuni.resources.repositories.VenueRepository;
import softuni.resources.repositories.WeddingRepository;
import softuni.service.api.VenueService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class VenueServiceImpl implements VenueService {

    @Autowired
    private final VenueRepository venueRepository;
    private final WeddingRepository weddingRepository;
    private final DTOValidator validator;

    public VenueServiceImpl(VenueRepository venueRepository, WeddingRepository weddingRepository, DTOValidator validator) {
        this.venueRepository = venueRepository;
        this.weddingRepository = weddingRepository;
        this.validator = validator;
    }

    @Override
    public List<Venue> findAll() {
        return this.venueRepository.findAll();
    }

    @Override
    public Venue findOne(Long aLong) {
        return this.venueRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.venueRepository.delete(aLong);
    }

    @Override
    public void delete(Venue entity) {
            this.venueRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importVenuesXml(ImportVenuesXmlDto importVenuesXmlDto) {
        List<ImportVenueXmlDto> venuesImport = importVenuesXmlDto.getVenues();

        for (ImportVenueXmlDto venueDto : venuesImport) {
            Venue venue = DtoMappingUtil.convert(venueDto, Venue.class);

            List<Wedding> weddings = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                long i = ThreadLocalRandom.current().nextLong(1,this.weddingRepository.findAll().size());
                if(!weddings.contains(this.weddingRepository.findOne(i))){
                    weddings.add(this.weddingRepository.findOne(i));
                }else{
                    j--;
                }

            }

            venue.setWeddings(weddings);
            if(validator.isValid(venue)){
                this.venueRepository.saveAndFlush(venue);
                System.out.println("Successfully imported "+venue.getName());
            }else {
                System.out.println("Error.Invalid data provided.");
            }
        }

    }

    @Override
    public ExportVenuesInSofiaXmlDto exportVenues() {

        List<Venue> venuesInSofia = this.venueRepository.exportVenuesInSofia();
        List<ExportVenueInSofiaXmlDto> venueInSofiaXmlDtos = DtoMappingUtil.convert(venuesInSofia, ExportVenueInSofiaXmlDto.class);

        for (ExportVenueInSofiaXmlDto venueInSofiaXmlDto : venueInSofiaXmlDtos) {
             venueInSofiaXmlDto.setWeddingsCount(venueInSofiaXmlDto.getWeddings().size());
        }
        ExportVenuesInSofiaXmlDto exportVenuesInSofiaXmlDto = new ExportVenuesInSofiaXmlDto();
        exportVenuesInSofiaXmlDto.setVenues(venueInSofiaXmlDtos);
        exportVenuesInSofiaXmlDto.setTown("Sofia");
        return exportVenuesInSofiaXmlDto;
    }
}