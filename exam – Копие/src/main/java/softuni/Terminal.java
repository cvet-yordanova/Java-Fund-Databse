package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.Branch;
import softuni.entities.EmployeeCard;
import softuni.entities.Town;
import softuni.models.binding.ImportTownJsonDto;
import softuni.models.binding.import_branch.ImportBranchDtoJson;
import softuni.models.binding.import_employee_cards.ImportEmployeeCardJsonDto;
import softuni.models.binding.import_employees.ImportEmployeeXmlDto;
import softuni.models.binding.import_employees.ImportEmployeesXmlDto;
import softuni.models.binding.import_products.ImportProductXmlDto;
import softuni.models.binding.import_products.ImportProductsXmlDto;
import softuni.models.view.export_cards_without_owner.ExportCardViewDtoJson;
import softuni.models.view.export_productive_employees.ExportEmployeeDto;
import softuni.serialize.JSonSerializer;
import softuni.serialize.XMLSerializer;
import softuni.service.api.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final EmployeeCardService employeeCardService;

    @Autowired
    private final BranchService branchService;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final TownService townService;

    @Autowired
    private final JSonSerializer jSonSerializer;

    @Autowired
    private final XMLSerializer xmlSerializer;

    private final String IMPORT_TOWNS = "/files/json/input/towns.json";
    private final String IMPORT_BRANCHES = "/files/json/input/branches.json";
    private final String IMPORT_EMPLOYEE_CARDS = "/files/json/input/employee_cards.json";
    private final String IMPORT_PRODUCTS = "/files/xml/input/products.xml";
    private final String IMPORT_EMPLOYEES = "/files/xml/input/employees.xml";
    private final String EXPORT_CARDS = "src/main/resources/files/json/output/free_cards.json";
    private final String EXPORT_PRODUCTIVE_EMPLOYEES = "src/main/resources/files/json/output/productive-employees.json";

    public Terminal(EmployeeService employeeService, EmployeeCardService employeeCardService,
                    BranchService branchService, ProductService productService, TownService townService,
                    JSonSerializer jSonSerializer, XMLSerializer xmlSerializer) {
        this.employeeService = employeeService;
        this.employeeCardService = employeeCardService;
        this.branchService = branchService;
        this.productService = productService;
        this.townService = townService;
        this.jSonSerializer = jSonSerializer;
        this.xmlSerializer = xmlSerializer;
    }

    @Override
    public void run(String... strings) throws Exception {
        importTowns();
        importBranch();
        importProducts();
        importEmployeeCards();
        importEmployeesXml();
        exportCardsWithoutOwnerJson();
        exportProductiveEmployees();
    }

    public void importTowns(){
        ImportTownJsonDto[] importTownJsonDtos = jSonSerializer.deserialize(ImportTownJsonDto[].class,IMPORT_TOWNS);

        for (ImportTownJsonDto importTownJsonDto : importTownJsonDtos) {
                this.townService.importTownJsonDto(importTownJsonDto);
        }
    }

    public void importBranch(){
        ImportBranchDtoJson[] importBranchDtoJsons = jSonSerializer.deserialize(ImportBranchDtoJson[].class, IMPORT_BRANCHES);
        for (ImportBranchDtoJson importBranchDtoJson : importBranchDtoJsons) {
            Town town = this.townService.findTownByName(importBranchDtoJson.getTownName());

            if(town == null){
                System.out.println("Error: Invalid data.");
            }
            else {
                this.branchService.importBranchDto(importBranchDtoJson, town);
            }
        }
    }

    public void importProducts(){
        ImportProductsXmlDto importProductsXmlDto = this.xmlSerializer.deserialize(ImportProductsXmlDto.class,IMPORT_PRODUCTS );

        for (ImportProductXmlDto productXmlDto : importProductsXmlDto.getImportProductXmlDtos()) {
            Branch branch = this.branchService.findByName(productXmlDto.getBranchName());

            if(branch == null){
                System.out.println("Error");
            }

            else {
                this.productService.importProductsXml(productXmlDto, branch);
            }

        }

    }
    
    public void importEmployeeCards(){
        ImportEmployeeCardJsonDto[] importEmployeeCards = jSonSerializer.deserialize(ImportEmployeeCardJsonDto[].class,IMPORT_EMPLOYEE_CARDS );

        for (ImportEmployeeCardJsonDto importEmployeeCard : importEmployeeCards) {

            if(this.employeeCardService.findEmployeeCardByNumber(importEmployeeCard.getNumber()) != null){
                System.out.println("Error: Invalid data.");
            }
            else {
                this.employeeCardService.saveEmployeeCardDto(importEmployeeCard);
            }

        }
    }

    public void importEmployeesXml(){
        ImportEmployeesXmlDto importEmployees = xmlSerializer.deserialize(ImportEmployeesXmlDto.class,IMPORT_EMPLOYEES);


        for (ImportEmployeeXmlDto importEmployee : importEmployees.getImportEmployeeXmlDtos() ) {
            EmployeeCard employeeCard = this.employeeCardService.findEmployeeCardByNumber(importEmployee.getCardName());
            Branch branch = this.branchService.findByName(importEmployee.getBranchName());

            if(employeeCard != null && branch != null){
                this.employeeService.saveEmployeeDto(importEmployee, employeeCard, branch);
            }
            else {
                System.out.println("Error: Invalid data.");
            }
        }
    }

    public void exportCardsWithoutOwnerJson(){
        List<ExportCardViewDtoJson> exportCards = this.employeeCardService.findEmployeeCardsWithoutOwner();

        jSonSerializer.serialize(exportCards, EXPORT_CARDS);
    }

    public void exportProductiveEmployees(){
        List<ExportEmployeeDto> exportEmployeeDtos = this.employeeService.getProductiveEmployees();
        jSonSerializer.serialize(exportEmployeeDtos,EXPORT_PRODUCTIVE_EMPLOYEES);
    }




}
