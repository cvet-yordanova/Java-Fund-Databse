package softuni.service.api;

import softuni.entities.EmployeeCard;
import softuni.models.binding.import_employee_cards.ImportEmployeeCardJsonDto;
import softuni.models.view.export_cards_without_owner.ExportCardViewDtoJson;

import java.util.List;

public interface EmployeeCardService {

    List<EmployeeCard> findAll();
    EmployeeCard findOne(Long aLong);
    void delete(Long aLong);
    void delete(EmployeeCard car);
    void saveEmployeeCardDto(ImportEmployeeCardJsonDto employeeCard);
    EmployeeCard findEmployeeCardByNumber(String number);
    List<ExportCardViewDtoJson> findEmployeeCardsWithoutOwner();
}