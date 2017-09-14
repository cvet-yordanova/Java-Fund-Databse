package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Venue;
import softuni.repositories.VenueRepository;
import softuni.service.api.VenueService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VenueServiceImpl implements VenueService {

    @Autowired
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
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
    public void importVenue(Venue venue) {
        this.venueRepository.save(venue);
    }
}