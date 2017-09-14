package softuni.service.api;

import softuni.entities.Venue;

import java.util.List;

public interface VenueService {

    List<Venue> findAll();
    Venue findOne(Long aLong);
    void delete(Long aLong);
    void delete(Venue car);
    void importVenue(Venue venue);
}