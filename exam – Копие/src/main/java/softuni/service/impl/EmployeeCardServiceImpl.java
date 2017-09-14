package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.EmployeeCard;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.import_employee_cards.ImportEmployeeCardJsonDto;
import softuni.models.view.export_cards_without_owner.ExportCardViewDtoJson;
import softuni.repositories.EmployeeCardRepository;
import softuni.service.api.EmployeeCardService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeCardServiceImpl implements EmployeeCardService {

    @Autowired
    private final DTOValidator validator;

    @Autowired
    private final EmployeeCardRepository employeeCardRepository;

    public EmployeeCardServiceImpl(DTOValidator validator, EmployeeCardRepository employeeCardRepository) {
        this.validator = validator;
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public List<EmployeeCard> findAll() {
        return this.employeeCardRepository.findAll();
    }

    @Override
    public EmployeeCard findOne(Long aLong) {
        return this.employeeCardRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.employeeCardRepository.delete(aLong);
    }

    @Override
    public void delete(EmployeeCard entity) {
            this.employeeCardRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void saveEmployeeCardDto(ImportEmployeeCardJsonDto employeeCard) {
        EmployeeCard employeeCard1 = DtoMappingUtil.convert(employeeCard, EmployeeCard.class);

        if(validator.isValid(employeeCard1)){
            this.employeeCardRepository.saveAndFlush(employeeCard1);
            System.out.println("Successfully imported Employee Card "+employeeCard1.getNumber());
        }
        else {
            System.out.println("Error: Invalid data.");
        }
    }

    @Override
    public EmployeeCard findEmployeeCardByNumber(String number) {
        return this.employeeCardRepository.findEmployeeCardByNumber(number);
    }

    @Override
    public List<ExportCardViewDtoJson> findEmployeeCardsWithoutOwner() {

        List<EmployeeCard> employeeCards = this.employeeCardRepository.findEmployeeCardsWithoutOwner();
        List<ExportCardViewDtoJson> exportCards = new ArrayList<>();

        for (EmployeeCard card : employeeCards) {
            ExportCardViewDtoJson exportCard = DtoMappingUtil.convert(card,ExportCardViewDtoJson.class );
            exportCards.add(exportCard);
        }
        return exportCards;
    }
}