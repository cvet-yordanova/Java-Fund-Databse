package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Agency;
import softuni.repositories.AgencyRepository;
import softuni.service.api.AgencyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
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
    public void save(Agency agency) {
        this.agencyRepository.saveAndFlush(agency);
        System.out.printf("Successfully imported %s\n",agency.getName());
    }

    @Override
    public Agency findByName(String name) {
        return this.agencyRepository.findByName(name);
    }
}