package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.export_agencies_json.ExportAgenciesJsonDto;
import softuni.dto.import_agencies.ImportAgencyJsonDto;
import softuni.entities.Agency;
import softuni.io.DtoMappingUtil;
import softuni.resources.repositories.AgencyRepository;
import softuni.service.api.AgencyService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    private final DTOValidator validator;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository, DTOValidator validator) {
        this.agencyRepository = agencyRepository;
        this.validator = validator;
    }

    @Override
    public List<Agency> findAll() {
        return this.agencyRepository.findAll();
    }

    @Override
    public Agency findOne(Long aLong) {
        return this.agencyRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.agencyRepository.delete(aLong);
    }

    @Override
    public void delete(Agency entity) {
            this.agencyRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void importAgenciesJson(ImportAgencyJsonDto[] agenciesDto) {

        for (ImportAgencyJsonDto agencyJsonDto : agenciesDto) {

            Agency agency = DtoMappingUtil.convert(agencyJsonDto, Agency.class);

            if(validator.isValid(agency)){
                this.agencyRepository.saveAndFlush(agency);
                System.out.println("Successfully imported "+agency.getName());
            }
            else {
                System.out.println("Error.Invalid data provided.");
            }
        }
    }

    @Override
    public List<ExportAgenciesJsonDto> exportAgencies() {
        return this.agencyRepository.findAllAgenciesOrderedByEmployeesCount();
    }
}