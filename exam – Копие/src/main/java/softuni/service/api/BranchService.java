package softuni.service.api;

import softuni.entities.Branch;
import softuni.entities.Town;
import softuni.models.binding.import_branch.ImportBranchDtoJson;

import java.util.List;

public interface BranchService {

    List<Branch> findAll();
    Branch findOne(Long aLong);
    void delete(Long aLong);
    void delete(Branch car);
    void importBranchDto(ImportBranchDtoJson branchDto, Town town);
    Branch findByName(String name);
}