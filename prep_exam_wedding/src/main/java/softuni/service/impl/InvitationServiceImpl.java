package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Invitation;
import softuni.repositories.InvitationRepository;
import softuni.service.api.InvitationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    private final InvitationRepository invitationRepository;

    public InvitationServiceImpl(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    @Override
    public List<Invitation> findAll() {
        return this.invitationRepository.findAll();
    }

    @Override
    public Invitation findOne(Long aLong) {
        return this.invitationRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.invitationRepository.delete(aLong);
    }

    @Override
    public void delete(Invitation entity) {
            this.invitationRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}