package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Cash;
import softuni.entities.Gift;
import softuni.entities.Invitation;
import softuni.entities.Present;
import softuni.enums.Size;
import softuni.models.binding.ImportPresentXml;
import softuni.repositories.InvitationRepository;
import softuni.repositories.PresentRepository;
import softuni.service.api.PresentService;

@Service
@Transactional
public class PresentServiceImpl implements PresentService {

    @Autowired
    private final PresentRepository presentRepository;

    @Autowired
    private final InvitationRepository invitationRepository;

    public PresentServiceImpl(PresentRepository presentRepository, InvitationRepository invitationRepository) {
        this.presentRepository = presentRepository;
        this.invitationRepository = invitationRepository;
    }

    @Override
    public void importPresent(Present present) {
        this.presentRepository.saveAndFlush(present);
    }

    @Override
    public void importPresents(ImportPresentXml importPresent) {
        if(importPresent.getType() == null || importPresent.getInvitationId() == null){
            System.out.println("Invalid data.");
        } else {
            Invitation invitation = this.invitationRepository.findById(importPresent.getInvitationId());

      //      Boolean checkInvName = (importPresent.getType().equals("gift"))&&(importPresent.getName() != null);
            Boolean checkInvAmount = (importPresent.getType().equals("cash"))&&(importPresent.getAmount() != null);
            if((invitation != null) && ((checkInvAmount))){

                switch (importPresent.getType()){case "gift":
                        Gift gift = new Gift();
           //             gift.setName(importPresent.getName());
                        gift.setInvitation(invitation);
                      //   if(importPresent.getSize() == null){
                             gift.setSize(Size.Not_Specified);
                      //   }

                         this.presentRepository.saveAndFlush(gift);
            //            System.out.println("Successfully imported present "+importPresent.getName());
                         break;
                    case "cash":

                        Cash cash = new Cash();
                        cash.setAmount(importPresent.getAmount());
                      //  cash.setInvitation(invitation);
                        this.presentRepository.save(cash);
                        System.out.println("Successfully imported cash "+ importPresent.getAmount());
                        break;
                }

            }
            else {
                System.out.println("Invalid data.");
            }

        }


    }
}
