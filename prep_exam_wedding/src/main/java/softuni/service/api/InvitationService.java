package softuni.service.api;

import softuni.entities.Invitation;

import java.util.List;

public interface InvitationService {

    List<Invitation> findAll();
    Invitation findOne(Long aLong);
    void delete(Long aLong);
    void delete(Invitation car);
}