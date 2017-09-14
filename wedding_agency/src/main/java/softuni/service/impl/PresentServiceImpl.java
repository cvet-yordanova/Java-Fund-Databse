package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.import_presents_xml.ImportPresentXmlDto;
import softuni.entities.*;
import softuni.io.DtoMappingUtil;
import softuni.resources.repositories.InvitationRepository;
import softuni.resources.repositories.PersonRepository;
import softuni.resources.repositories.PresentRepository;
import softuni.service.api.PresentService;
import softuni.validation.DTOValidator;

@Service
@Transactional
public class PresentServiceImpl implements PresentService {

    @Autowired
    private final PresentRepository presentRepository;
    private final InvitationRepository invitationRepository;
    private final DTOValidator validator;
    private final PersonRepository personRepository;

    public PresentServiceImpl(PresentRepository presentRepository, InvitationRepository invitationRepository, DTOValidator validator, PersonRepository personRepository) {
        this.presentRepository = presentRepository;
        this.invitationRepository = invitationRepository;
        this.validator = validator;
        this.personRepository = personRepository;
    }


    @Override
    public void importPresents(ImportPresentXmlDto presentXmlDto) {
        Invitation invitation = null;
        Person owner = null;
        if (presentXmlDto.getInvitaionId() != null) {
            invitation = this.invitationRepository.findOne(presentXmlDto.getInvitaionId());
        }
        if (invitation != null) {
            owner = this.personRepository.findOne(invitation.getGuest().getId());
        }

        switch (presentXmlDto.getType()){
            case "cash":
                Cash cash = DtoMappingUtil.convert(presentXmlDto, Cash.class);
                cash.setInvitation(invitation);
                cash.setOwner(owner);
                 if(validator.isValid(cash) && invitation!= null){
                     invitation.setPresent(cash);
                     this.presentRepository.saveAndFlush(cash);
                     this.presentRepository.saveAndFlush(cash);
                     System.out.println("Successfully imported present by "+ owner.getFirstName()+ invitation.getGuest().getFirstName()+" "+invitation.getGuest().getLastName());
                 }
                 else {
                     System.out.println("Error.");
                 }
                break;

            case "gift":
                Gift gift = DtoMappingUtil.convert(presentXmlDto, Gift.class);
                if(gift.getSize() == null){
                    gift.setSize(Size.NotSpecified);
                }
//                gift.getSize().equals(Size.Large) || !gift.getSize().equals(Size.Medium) || !gift.getSize().equals(Size.Small)

                gift.setInvitation(invitation);
                gift.setOwner(owner);
                if(validator.isValid(gift) && invitation!= null){
                    this.presentRepository.saveAndFlush(gift);
                    invitation.setPresent(gift);
                    this.presentRepository.saveAndFlush(gift);
                    System.out.println("Successfully imported present by "+ owner.getFirstName()+ invitation.getGuest().getFirstName()+" "+invitation.getGuest().getLastName());
                }
                else {
                    System.out.println("Error.");
                }
                break;
        }

    }

}
