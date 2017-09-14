package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Branch;
import softuni.entities.Town;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.import_branch.ImportBranchDtoJson;
import softuni.repositories.BranchRepository;
import softuni.repositories.TownRepository;
import softuni.service.api.BranchService;
import softuni.validation.DTOValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    private final DTOValidator validator;

    @Autowired
    private final BranchRepository branchRepository;

    @Autowired
    private final TownRepository townRepository;

    public BranchServiceImpl(DTOValidator validator, BranchRepository branchRepository, TownRepository townRepository) {
        this.validator = validator;
        this.branchRepository = branchRepository;
        this.townRepository = townRepository;
    }

    @Override
    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }

    @Override
    public Branch findOne(Long aLong) {
        return this.branchRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.branchRepository.delete(aLong);
    }

    @Override
    public void delete(Branch entity) {
            this.branchRepository.delete(entity);
    }

    @Override
    public void importBranchDto(ImportBranchDtoJson branchDto, Town town) {
        Branch branch = DtoMappingUtil.convert(branchDto, Branch.class);
        branch.setTown(town);

        if(validator.isValid(branch)){
            this.branchRepository.saveAndFlush(branch);
            System.out.println("Successfully imported Branch "+branch.getName());
        }

        else {
            System.out.println("Error: Invalid data.");
        }
    }

    @Override
    public Branch findByName(String name) {
        return this.branchRepository.findBranchByName(name);
    }

    //--------------------------------------------------------------------
}